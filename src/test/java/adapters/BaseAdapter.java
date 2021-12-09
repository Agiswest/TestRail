package adapters;

import io.restassured.specification.RequestSpecification;
import lombok.extern.log4j.Log4j2;
import utils.PropertyReader;

import static io.restassured.RestAssured.*;

@Log4j2
public class BaseAdapter{
    final String BASE_URL = System.getenv().getOrDefault("TESTRAIL_API_URL",
            PropertyReader.getProperty("testrail.api.url"));
    final String TOKEN = System.getenv().getOrDefault("TESTRAIL_API_TOKEN",
            PropertyReader.getProperty("testrail.api.token"));
    final String USER = System.getenv().getOrDefault("TESTRAIL_USER",
            PropertyReader.getProperty("testrail.user"));
    RequestSpecification requestSpec;

    public BaseAdapter() {
        requestSpec = given()
                .header("Content-Type", "application/json")
                .auth().preemptive().basic(USER, TOKEN);
    }

    public String post(String body, String uri) {
        return given().spec(requestSpec)
                .body(body)
        .when()
                .post(BASE_URL + uri)
        .then()
                .log().all()
                .statusCode(200)
                .extract().body().asString();
    }

    public void delete(String uri) {
        given().spec(requestSpec)
        .when()
                .delete(BASE_URL + uri)
        .then()
                .log().all()
                .statusCode(200);
    }

    public String get(String uri) {
        return given()
                .spec(requestSpec)
        .when()
                .get(BASE_URL + uri)
        .then()
                .log().all()
                .statusCode(200)
                .extract().body().asString();
    }
}
