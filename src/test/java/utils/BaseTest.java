package utils;

import io.restassured.RestAssured;

public class BaseTest implements ConstantsHelper {

    public static void setup() {
        RestAssured.baseURI = BASE_URL;

        RestAssured.port = PORT;

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();


    }


}
