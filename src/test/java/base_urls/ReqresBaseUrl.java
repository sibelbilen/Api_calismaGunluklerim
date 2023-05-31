package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

import java.util.HashMap;
import java.util.Map;

public class ReqresBaseUrl {

    protected RequestSpecification spec;

    @Before
    public void setUp() {
        spec = new RequestSpecBuilder().
                setContentType(ContentType.JSON).
                setAccept(ContentType.JSON).
                setBaseUri("https://reqres.in/api/users/3").
                build();
    }

    public Map<String, Object> expectedDataMapReqres(String email, String firstname, String lastname, String text) {
        Map<String, Object> data = new HashMap<>();
        data.put("email", email);
        data.put("first_name", firstname);
        data.put("last_name", lastname);
        data.put("text", text);

        return data;

    }
}