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
            response body is like  {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }
     */

import Utilies.ObjectMapperUtils;
import base_urls.JsonplaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;

import static io.restassured.RestAssured.given;

public class Post05_ObjectMapper_Pojo extends JsonplaceHolderBaseUrl {
    @Test
    public void Post05() {

        //Set the url
        spec.pathParam("first","todos");

        //set the expected data

        JsonPlaceHolderPojo expectedData=new JsonPlaceHolderPojo(55,"Tidy your room",false);
        System.out.println("expectedData = " + expectedData);

        //send the request and get the response

        Response response=given(spec).body(expectedData).contentType(ContentType.JSON).post("{first}");
        response.prettyPrint();
        
        
        //do assertions
        
        JsonPlaceHolderPojo actuel= ObjectMapperUtils.convertJsonToJava(response.asString(),JsonPlaceHolderPojo.class);
        System.out.println("actuel = " + actuel);
        
        
    }
}
