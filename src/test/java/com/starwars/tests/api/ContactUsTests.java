package com.starwars.tests.api;

import com.starwars.tests.TestInit;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ContactUsTests extends TestInit {
    public final String endpoint = "/api/contact-us";
    private static String requestBody = "{\"full_name\":\"Test\",\"email\":\"email_test@gmail.com\",\"message\":\"test\"}";

    @Test
    public void verifyPostContactUsTest() {
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post(HOST + endpoint)
                .then()
                .extract().response();
        Assert.assertEquals(201, response.statusCode());
    }

    @Test
    public void verifyBadRequestTest() {
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body("body")
                .when()
                .post(HOST + endpoint)
                .then()
                .extract().response();
        Assert.assertEquals(400, response.statusCode());
    }
}
