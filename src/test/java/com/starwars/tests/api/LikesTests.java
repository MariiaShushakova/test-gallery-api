package com.starwars.tests.api;

import com.starwars.tests.TestInit;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class LikesTests extends TestInit {
    public final String endpoint = "/api/likes/";

    @Test
    public void verifyIncreaseLikesTest() {
        given()
                .when()
                .get(HOST + endpoint + "873/increase")
                .then()
                .assertThat()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void verifyDecreaseLikesTest() {
        given()
                .when()
                .get(HOST + endpoint + "873/decrease")
                .then()
                .assertThat()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void verifyLikesIncreaseBodyTest() {
        given()
                .when()
                .get(HOST + endpoint + "873/increase")
                .then()
                .assertThat()
                .statusCode(200)
                .log().all()
                .body("html.body", equalTo("success"));
    }

    @Test
    public void verifyLikesDecreaseBodyTest() {
        given()
                .when()
                .get(HOST + endpoint + "873/decrease")
                .then()
                .assertThat()
                .statusCode(200)
                .log().all()
                .body("html.body", equalTo("success"));
    }

    @Test
    public void verifyNotFoundCallTest() {
        given()
                .when()
                .get(HOST + endpoint)
                .then()
                .assertThat()
                .log().all()
                .statusCode(404);
    }
}
