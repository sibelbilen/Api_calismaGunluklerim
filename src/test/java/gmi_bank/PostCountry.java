package gmi_bank;

import Utilies.ObjectMapperUtils;
import base_urls.GmiBankBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.Country;
import pojos.State;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PostCountry extends GmiBankBaseUrl {
     /*
//    Given
//        https://gmibank.com/api/tp-countries
//    And
//        {
//          "name": "Banana",
//          "states": [
//            {
//              "id": 0,
//              "name": "Apple"
//            },
//            {
//              "id": 1,
//              "name": "Orange"
//            },
//            {
//              "id": 2,
//              "name": "Pear"
//            }
//          ]
//        }

//      When
//        Send post request
//      Then
//        Status code is 201
//      And
//        Body:
//        {
//            "id": 187487,
//            "name": "Banana",
//            "states": [
//                {
//                    "id": 1,
//                    "name": "Apple",
//                    "tpcountry": null
//                },
//                {
//                    "id": 2,
//                    "name": "Orange",
//                    "tpcountry": null
//                },
//                {
//                    "id": 3,
//                    "name": "Pear",
//                    "tpcountry": null
//                }
//            ]
//        }
//
//     */
//
   @Test
    public void post01() {
  //set teh url
  spec.pathParams("first","api","second","tp-countries") ;

//set the expected data
       State state1=new State(1,"Apple");
       State state2=new State(2,"Orange");
       State state3=new State(3,"Pear");
//objeleri bir listin icine koyacagiz

        List<State> stateList = new ArrayList<>();
        stateList.add(state1);
        stateList.add(state2);
        stateList.add(state3);

        Country expectedData = new Country("Banana",stateList);
        System.out.println("expectedData = " + expectedData);


       Country country=new Country("Banana",stateList);
       System.out.println("country = " + country);

//Send the request and get the response
        Response response = given(spec).body(expectedData).post("{first}/{second}");
        response.prettyPrint();

        //Do assertion


        

   }
   }

