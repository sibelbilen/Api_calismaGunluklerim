package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.junit.Test;

public class HerokuAppBaseurl {
    //RequestSpecification:>> API isteklerinin yapılandırılmasını ve başlatılmasını sağlar.
    //setBaseUri>>:isteklerin gönderileceği temel URI belirlenir
    //RequestSpecBuilder():>>API isteklerini yapılandırmak için kullanılan çeşitli yöntemler sağlar.
 protected RequestSpecification spec;

    @Before
    public void setUp() {
        spec=new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com/").build();
    }
}
