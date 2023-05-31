package post_requests;

import base_urls.JsonplaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

/*
        Given
           https://jsonplaceholder.typicode.com/todos
           {
           "userId": 55,
           "title": "Tidy your room",
           "completed": false
           }
       When
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

public class Post03 extends JsonplaceHolderBaseUrl {
    @Test
    public void post03() {
        spec.pathParam("first", "todos");

        JsonPlaceHolderPojo expectedData=new JsonPlaceHolderPojo(55,"Tidy your room",false);
        System.out.println("expectedData : = " + expectedData);

        Response response=given(spec).body(expectedData).contentType(ContentType.JSON).post("{first}") ;
        response.prettyPrint();
        
        JsonPlaceHolderPojo actualData=response.as(JsonPlaceHolderPojo.class);
        System.out.println("actualData = " + actualData);
    assertEquals(201,response.statusCode());
      assertEquals(expectedData.getUserId(),actualData.getUserId());
      assertEquals(expectedData.getTitle(),actualData.getTitle());
      assertEquals(expectedData.getCompleted(),actualData.getCompleted());

    }
}
