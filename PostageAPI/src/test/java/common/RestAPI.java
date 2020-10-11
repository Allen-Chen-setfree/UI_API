package common;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class RestAPI {

    final private String API_Key = readProperty().get("API_Key");
    final private String BaseURL = readProperty().get("BaseURL");

    public String GetCall(String route) {

        return given()
                .header("AUTH-KEY", API_Key)
                .with()
                .and()
                .when()
                .get(BaseURL+route)
                .then()
                .assertThat().statusCode(200).extract().response().asString();

    }


    public HashMap<String,String> readProperty () {
        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream("src/test/resources/API_config.properties"));
        } catch (Exception e) {

        }

        return new HashMap<String, String>((Map) properties);

    }


}
