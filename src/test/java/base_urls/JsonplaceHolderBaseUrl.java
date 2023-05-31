package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class JsonplaceHolderBaseUrl {
 //
   protected RequestSpecification spec;
    //RequestSpecification:>> API isteklerinin yapılandırılmasını ve başlatılmasını sağlar.
    //setBaseUri>>:isteklerin gönderileceği temel URI belirlenir
    //RequestSpecBuilder():>>API isteklerini yapılandırmak için kullanılan çeşitli yöntemler sağlar.
    @Before
    public void setUp()  {
        spec=new RequestSpecBuilder().
                setContentType(ContentType.JSON).
                setAccept(ContentType.JSON).
                setBaseUri("https://jsonplaceholder.typicode.com/").
                build();
    }
}
