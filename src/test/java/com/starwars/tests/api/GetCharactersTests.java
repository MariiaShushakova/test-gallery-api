package com.starwars.tests.api;

import com.starwars.tests.TestInit;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetCharactersTests extends TestInit {
    public final String endpoint = "/api/characters";

    @Test
    public void verifyGetCharactersCallTest() {
        given()
                .when()
                .get(HOST + endpoint)
                .then()
                .assertThat()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void verifyGetCharactersBodyTest() {
        given()
                .when()
                .get(HOST + endpoint)
                .then()
                .assertThat()
                .statusCode(200)
                .log().all()
                //check a few values
                .body("[0].id", equalTo(33))
                .body("[0].title", equalTo("darth vader"))
                .body("[0].rank", equalTo(1));
    }

    @Test
    public void verifyCharactersSchemaTest() {
        given()
                .when()
                .get(HOST + endpoint)
                .then()
                .assertThat()
                .statusCode(200)
                .log().all()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsons/CharactersSchema.json"));
    }

    @Test
    public void verifyNotFoundCallTest() {
        given()
                .when()
                .get(HOST + endpoint + "1")
                .then()
                .assertThat()
                .log().all()
                .statusCode(404);
    }
}
