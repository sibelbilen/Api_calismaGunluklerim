package post_requests;
   /*
         Given
           1) https://jsonplaceholder.typicode.com/todos
           2) {
                 "userId": 55,
                 "title": "Tidy your room",
                 "completed": false
               }


            I send POST Request to the Url
        Then
            Status code is 201
        And
            response body is like {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }
     */

import base_urls.JsonplaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapper;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Post05_ObjectMapper_Map  extends JsonplaceHolderBaseUrl {
    @Test
    public void post05() {
   
        //set the url
        spec.pathParam("pp1","todos");
        
        //set the expected data

        Map<String,Object>expected=new JsonPlaceHolderTestData().expectedDataMapMethod(55,"Tidy your room",false);
        System.out.println("expected = " + expected);

        //send the request and get the response

        Response response=given().body(expected).post("{pp1}");
        response.prettyPrint();

        //assertion

//        Map<String,Object>actualData=new ObjectMapper().readvalue(response.asString(), HashMap.class);
//        System.out.println("actualData = " + actualData);


    }
}
