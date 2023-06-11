package gmi_bank;

import base_urls.HerokuAppBaseurl;
import org.junit.Test;
import pojos.Account;
import pojos.Country;
import pojos.Customer;
import pojos.User;

import java.util.ArrayList;
    /*
    Given
        https://www.gmibank.com/api/tp-customers/133986
    When
        User sends Get request
    Then
        Status code should be 200
     And
        Response body should be like:
{
    "id": 133986,
    "firstName": "Danika",
    "lastName": "Huel",
    "middleInitial": "S",
    "email": "danikahuel@gmail.com",
    "mobilePhoneNumber": "155-489-7844",
    "phoneNumber": "155-489-7844",
    "zipCode": "32476",
    "address": "3848 Lang Hill",
    "city": "Free City",
    "ssn": "725-97-6213",
    "createDate": "2022-01-21T05:00:00Z",
    "zelleEnrolled": false,
    "country": {
        "id": 187679,
        "name": "Banana",
        "states": null
    },
    "state": "Apple",
    "user": {
        "id": 134701,
        "login": "raymundo.moen",
        "firstName": "Danika",
        "lastName": "Huel",
        "email": "danikahuel@gmail.com",
        "activated": true,
        "langKey": "en",
        "imageUrl": null,
        "resetDate": null
    },
    "accounts": [
        {
            "id": 128481,
            "description": "Description",
            "balance": 0,
            "accountType": "CHECKING",
            "accountStatusType": "ACTIVE",
            "createDate": "2022-01-04T21:00:00Z",
            "closedDate": "2022-01-04T21:00:00Z",
            "employee": null,
            "accountlogs": null
        },
        {
            "id": 131776,
            "description": "mfy",
            "balance": 536846,
            "accountType": "CREDIT_CARD",
            "accountStatusType": "ACTIVE",
            "createDate": "2022-01-18T21:00:00Z",
            "closedDate": "2022-01-18T21:00:00Z",
            "employee": null,
            "accountlogs": null
        }
    ]
}
     */

public class GetCustomer  extends HerokuAppBaseurl {

    @Test
    public void getCustomer() {

        //set the url

        spec.pathParams("first","api","second","tp-customers","third",133986);

        //set the expected data

        Country country=new Country("banana",null);
        User user = new User(134701, "raymundo.moen", "Danika", "Huel", "danikahuel@gmail.com", true, "en", null, null);
        Account account1 = new Account(128481, "Description", 0, "CHECKING", "ACTIVE", "2022-01-04T21:00:00Z", "2022-01-04T21:00:00Z", null, null);
        Account account2 = new Account(131776, "mfy", 536846, "CREDIT_CARD", "ACTIVE", "2022-01-18T21:00:00Z", "2022-01-18T21:00:00Z", null, null);
        ArrayList<Account> accountList = new ArrayList<>();
        accountList.add(account1);
        accountList.add(account2);

        Customer expectedData = new Customer(133986, "Danika", "Huel", "S", "danikahuel@gmail.com", "155-489-7844", "155-489-7844", "32476", "3848 Lang Hill", "Free City", "725-97-6213", "2022-01-21T05:00:00Z", false, country, "Apple", user, accountList);
        System.out.println("expectedData = " + expectedData);


    }
}
