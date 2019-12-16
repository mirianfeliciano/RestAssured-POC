package test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.Test;
import utils.BaseTest;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class LoginTest extends BaseTest {


    @Test
    public void validarLoginComFalha() {
        Map<String, String> login = new HashMap<>();
        login.put("username", "admin");
        login.put("password", "1234");
        login.put("grant_type", "password");

        given()
                .header("Authorization", "Basic YW5ndWxhcjpAbmd1bEByMA==")
                //.body("username=admin&password=1&grant_type=password")
                .formParams(login)
                .accept("*/*")
                .contentType(ContentType.URLENC)
                .log().all()
         .when()
                .post(BASE_URL_LOGIN)
         .then()
                .statusCode(400)
                .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("error-login.json"));
    }

    @Test
    public void validarLoginComSucesso() {
        Map<String, String> login = new HashMap<>();
        login.put("username", "admin");
        login.put("password", "admin");
        login.put("grant_type", "password");

        given()
                .header("Authorization", "Basic YW5ndWxhcjpAbmd1bEByMA==")
                .formParams(login)
                .accept("*/*")
                .contentType(ContentType.URLENC)
                .log().all()
         .when()
                .post(BASE_URL_LOGIN)
         .then()
                .statusCode(200)
                .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("retorno-login.json"));
    }
}
