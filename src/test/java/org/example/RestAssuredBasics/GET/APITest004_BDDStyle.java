package org.example.RestAssuredBasics.GET;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITest004_BDDStyle {

    @Test
    public void test_Get_req_POSITIVE()
    {
        String pincode = "560037";

        RestAssured
                .given()
                   .baseUri("https://api.zippopotam.us/")
                   .basePath("/IN/"+pincode)
                .when().log().all()
                   .get()
                .then()
                   .log().all()
                   .statusCode(200);
    }



    @Test
    public void test_Get_req_Negative()
    {
        String pincode = "-1";

        RestAssured
                .given()
                   .baseUri("https://api.zippopotam.us/")
                   .basePath("/IN/"+pincode)
                .when().log().all()
                    .get()
                .then().log().all()
                    .statusCode(200);
    }

}
