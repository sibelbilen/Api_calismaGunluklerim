package post_requests;

import base_urls.HerokuAppBaseurl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import test_data.HerOkuAppTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
 /*
    Given
        1) https://restful-booker.herokuapp.com/booking
        2) {
             "firstname": "John",
             "lastname": "Doe",
             "totalprice": 11111,
             "depositpaid": true,
             "bookingdates": {
                 "checkin": "2021-09-09",
                 "checkout": "2021-09-21"
              }

           }
    When
        I send POST Request to the Url
    Then
        Status code is 200
        And response body should be like {
                                            "bookingid": 5315,
                                            "booking": {
                                                "firstname": "John",
                                                "lastname": "Doe",
                                                "totalprice": 11111,
                                                "depositpaid": true,
                                                "bookingdates": {
                                                    "checkin": "2021-09-09",
                                                    "checkout": "2021-09-21"
                                                }
                                            }
                                         }
 */

public class Post02 extends HerokuAppBaseurl {

    @Test
    public void post02() {
        spec.pathParam("first", "booking");

        HerOkuAppTestData obj = new HerOkuAppTestData();
        Map<String, String> bookingdatesMap = obj.bookingdatesMapMethod("2021-09-09", "2021-09-21");
        Map<String, Object> expectedData = obj.expectedDataMapMethod("John", "Doe", 11111, true, bookingdatesMap, null);
        System.out.println("expectedData = " + expectedData);

        Response response = given(spec).body(expectedData).contentType(ContentType.JSON).post("{first}");
        response.prettyPrint();


        Map<String, Object> actualData = response.as(HashMap.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.get("firstname"), ((Map) actualData.get("booking")).get("firstname"));
        assertEquals(expectedData.get("lastname"), ((Map) ((Map<?, ?>) actualData.get("booking"))).get("lastname"));
        assertEquals(expectedData.get("totalprice"), ((Map) actualData.get("booking")).get("totalprice"));
        assertEquals(bookingdatesMap.get("checkin"), ((Map) ((Map) actualData.get("booking")).get("bookingdates")).get("checkin"));
        assertEquals(bookingdatesMap.get("checkout"),((Map) ((Map) actualData.get("booking")).get("bookingdates")).get("checkout"));


    }
}
