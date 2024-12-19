package org.example.RestAssuredBasics.GET;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITest003_Get {

    @Test
    public void test_Get_Rest()
    {
        RestAssured
                .given()
                   .baseUri("https://restful-booker.herokuapp.com")
                   .basePath("/booking")
                .when()
                   .get()
                .then().log().all()
                   .statusCode(200);
    }

    public static void main(String[] args)
    {
                      
    }
}
