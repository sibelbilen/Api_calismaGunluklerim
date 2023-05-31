package herokuapp_smokeTest;

import base_urls.HerokuAppBaseurl;
import io.restassured.response.Response;

import static herokuapp_smokeTest.C01_PostRequest.bookingId;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

/*
   Given
       https://restful-booker.herokuapp.com/booking/:id
   When
       Send delete request
   Then
       Status code is 200
   And
       Body should be : "Created"
    */
public class C05_DeleteRequest extends HerokuAppBaseurl {
    public void delete01(){
        //Set the url
        spec.pathParams("first", "booking", "second",bookingId);

        //Set the expected data
        String expectedData = "Created";

        //Send the request and get the response
        Response response = given(spec).delete("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        assertEquals(201, response.statusCode());
        assertEquals(expectedData, response. asString());

    }

}
