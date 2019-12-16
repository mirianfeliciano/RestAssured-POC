package utils;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class BaseTest implements ConstantsHelper {

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = BASE_URL;

        RestAssured.port = PORT;

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }


}
