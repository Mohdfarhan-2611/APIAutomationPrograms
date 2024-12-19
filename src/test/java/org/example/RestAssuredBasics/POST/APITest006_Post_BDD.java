package org.example.RestAssuredBasics.POST;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITest006_Post_BDD {

    @Description("TC1: Post BDDStyle : Negative Testcase")
    @Test
    public void test_Post_BDDStle()
    {
    String payload = "{\n" +
           " \"username\" : \"admin\",\n" +
       " \"password\" : \"password123\"\n" +
       "}";

        RestAssured
                .given()
                 .baseUri("https://restful-booker.herokuapp.com")
                 .basePath("/auth")
                 .contentType("application/json").log().all().body(payload)
                .when()
                  .log().all()
                  .post()
                .then()
                  .log().all()
                  .statusCode(201);

    }
}
