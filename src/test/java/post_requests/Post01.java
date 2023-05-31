package post_requests;

import base_urls.JsonplaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/*
         Given
           1)  https://jsonplaceholder.typicode.com/todos
           2)  {
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
public class Post01 extends JsonplaceHolderBaseUrl {
    @Test
    public void post01() {
        spec.pathParam("first","todos");

     String paayload=   "{\n" +
             "                                    \"userId\": 55,\n" +
             "                                    \"title\": \"Tidy your room\",\n" +
             "                                    \"completed\": false,\n" +
             "                                    \"id\": 201\n" +
             "                                    }";

        Response response=given(spec).body(paayload).post("{first}");
        response.prettyPrint();

      assertEquals(201,response.statusCode());
        JsonPath jsonPath=response.jsonPath();

        assertEquals(55,jsonPath.getInt("userId"));
        assertEquals("Tidy your room",jsonPath.getString("title"));
        assertFalse(jsonPath.getBoolean("completed"));
    }

    @Test
    public void post01Map() {
        spec.pathParam("first","todos");

        Map<String, Object>expectedData=new HashMap<>();
        expectedData.put("user",55);
        expectedData.put("title","Tidy your room");
        expectedData.put("completed",false);
        System.out.println("expectedData = " + expectedData);

        Response response=given(spec).body(expectedData).post("{first}");
        response.prettyPrint();

        Map<String,Object>actuelData=response.as(HashMap.class);
        System.out.println("actuelData = " + actuelData);

        assertEquals(201,response.statusCode());
        assertEquals(expectedData.get("completed"),actuelData.get("completed"));
        assertEquals(expectedData.get("title"),actuelData.get("title"));
        assertEquals(expectedData.get("userId"),actuelData.get("userId"));
    }
}
