package herokuapp_smokeTest;
 /*
    Given
        https://restful-booker.herokuapp.com/booking/:id
    When
        Send get request
    Then
        Status code is 200
    And
        Body:
        {
            "firstname": "Jim",
            "lastname": "Brown",
            "totalprice": 111,
            "depositpaid": true,
            "bookingdates": {
                "checkin": "2018-01-01",
                "checkout": "2019-01-01"
            },
            "additionalneeds": "Breakfast"
        }

     */

import Utilies.ObjectMapperUtils;
import base_urls.HerokuAppBaseurl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.testng.AssertJUnit;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;

import static herokuapp_smokeTest.C01_PostRequest.bookingId;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C02_GetRequest  extends HerokuAppBaseurl {
    @Test
    public void get01() {
        //send the url
        spec.pathParams("first","booking","second",bookingId);


//send the expected data
        BookingDatesPojo bookingDatesPojo=new BookingDatesPojo("2018-01-01", "2019-01-01");
        BookingPojo expectedData=new BookingPojo("Jim", "Brown", 111, true, bookingDatesPojo, "Breakfast");
        System.out.println("expectedData = " + expectedData);

        //send the request and get the response

        Response response=given(spec).contentType(ContentType.JSON).get("{first}/{second}");
        response.prettyPrint();

        //do assertions

        BookingPojo actualData= ObjectMapperUtils.convertJsonToJava(response.asString(), BookingPojo.class);
        System.out.println("actualData = " + actualData);

    assertEquals(200,response.statusCode());
        AssertJUnit.assertEquals(expectedData.getFirstname(), actualData.getFirstname());
        AssertJUnit.assertEquals(expectedData.getLastname(), actualData.getLastname());
        AssertJUnit.assertEquals(expectedData.getTotalprice(), actualData.getTotalprice());
        AssertJUnit.assertEquals(expectedData.getDepositpaid(), actualData.getDepositpaid());
        AssertJUnit.assertEquals(bookingDatesPojo.getCheckin(), actualData.getBookingdates().getCheckin());
        AssertJUnit.assertEquals(bookingDatesPojo.getCheckout(), actualData.getBookingdates().getCheckout());
        AssertJUnit.assertEquals(expectedData.getAdditionalneeds(), actualData.getAdditionalneeds());

    }
}
