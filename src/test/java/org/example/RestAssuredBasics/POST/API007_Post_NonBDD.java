package org.example.RestAssuredBasics.POST;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class API007_Post_NonBDD {


    @Description("TC2: Post NonBDDStyle : Negative Testcase")
    @Test
    public void test_Post_NonBDDStle()
    {
        String payload = "{\n" +
                " \"username\" : \"admin\",\n" +
                " \"password\" : \"password123\"\n" +
                "}";

        RequestSpecification r = RestAssured.given();

        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");
        r.contentType("application/json").log().all().body(payload);
        r.when();
        r.log().all();
        r.post();
        r.then().log().all().statusCode(200);


    }
}