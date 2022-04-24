package com.starwars.tests.api;

import com.starwars.tests.TestInit;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class ViewsTests extends TestInit {
    public final String endpoint = "/api/increment-views/";

    @Test
    public void verifyIncreaseViewsTest() {
        given()
                .when()
                .get(HOST + endpoint + "873")
                .then()
                .assertThat()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void verifyIncreaseViewsForIncorrectIdTest() {
        given()
                .when()
                .get(HOST + endpoint + "99999")
                .then()
                .assertThat()
                .log().all()
                .statusCode(404);
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
