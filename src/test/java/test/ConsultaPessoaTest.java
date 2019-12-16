package test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.hamcrest.Matchers;
import org.junit.Test;
import utils.BaseTest;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ConsultaPessoaTest extends BaseTest {

    @Test
    public void buscarPessoa() {
        Map<String, String> login = new HashMap<>();
        login.put("username", "admin");
        login.put("password", "admin");
        login.put("grant_type", "password");

      String token =  given()
               .header("Authorization", "Basic YW5ndWxhcjpAbmd1bEByMA==")
               .formParams(login)
               .accept("*/*")
               .contentType(ContentType.URLENC)
               .log().all()
        .when()
               .post(BASE_URL_LOGIN)
         .then()
               .statusCode(200)
               .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("retorno-login.json"))
        .extract().path("access_token");

        Map<String, String> busca = new HashMap<>();
        busca.put("page", "0");
        busca.put("size", "5");
        busca.put("nome", "Pedro Santos");

      given()
              .header("Authorization", "Bearer "+token)
              .queryParams(busca)
              .contentType(ContentType.JSON)
      .when()
            .get(BASE_URL_PESSOAS)
      .then()
            .statusCode(200)
            .body("content[0].endereco.logradouro", Matchers.is("Rua da Bateria"))
            .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("consulta-pessoa.json"));

    }
}
