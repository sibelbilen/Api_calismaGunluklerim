package herokuapp_smokeTest;

import Utilies.ObjectMapperUtils;
import base_urls.HerokuAppBaseurl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.testng.AssertJUnit;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import pojos.BookingResponsePojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
  /*
    Given
        https://restful-booker.herokuapp.com/booking
    And
        {
        "firstname" : "Jim",
        "lastname" : "Brown",
        "totalprice" : 111,
        "depositpaid" : true,
        "bookingdates" : {
            "checkin" : "2018-01-01",
            "checkout" : "2019-01-01"
        },
        "additionalneeds" : "Breakfast"
        }

    When
        Send post request
    Then
        Status code is 200
    And
        Body:
        {
        "bookingid": 937,
        "booking": {
            "firstname": "Jim",
            "lastname": "Brown",
            "totalprice": 111,
            "depositpaid": true,
            "bookingdates": {
                "checkin": "2018-01-01",
                "checkout": "2019-01-01"
            },
            "additionalneeds": ""Breakfast""
        }
    }


     */

public class C01_PostRequest  extends HerokuAppBaseurl {
    public static int bookingId;
    @Test
    public void post01() {

        //set the url
        spec.pathParam("first","booking");

        //set the expected data

        BookingDatesPojo bookingDatesPojo=new BookingDatesPojo("2018-01-01","2019-01-01");
        BookingPojo expectedData=new BookingPojo("Jim", "Brown", 111, true, bookingDatesPojo, "Breakfast");
        System.out.println("expectedData = " + expectedData);

        //send the request and get the response

        Response response=given(spec).body(expectedData).contentType(ContentType.JSON).post("{first}");
response.prettyPrint();

        //do assert
   BookingResponsePojo actualData= ObjectMapperUtils.convertJsonToJava(response.asString(),BookingResponsePojo.class);
        System.out.println("actualData = " + actualData);



        assertEquals(expectedData.getFirstname(),actualData.getBooking().getFirstname());
        assertEquals(expectedData.getLastname(),actualData.getBooking().getLastname());
     assertEquals(expectedData.getTotalprice(), actualData.getBooking().getTotalprice());
       assertEquals(expectedData.getDepositpaid(), actualData.getBooking().getDepositpaid());
        assertEquals(bookingDatesPojo.getCheckout(),actualData.getBooking().getBookingdates().getCheckout());
        assertEquals(bookingDatesPojo.getCheckin(),actualData.getBooking().getBookingdates().getCheckin());
        assertEquals(expectedData.getAdditionalneeds(), actualData.getBooking().getAdditionalneeds());

        bookingId = response.jsonPath().getInt("bookingid");
    }
}
