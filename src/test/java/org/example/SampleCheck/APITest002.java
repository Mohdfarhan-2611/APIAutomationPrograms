package org.example.SampleCheck;

import io.restassured.RestAssured;

public class APITest002 {

    //Full url: https://restful-booker.herokuapp.com/booking/1
    //base uri: https://restful-booker.herokuapp.com
    //base path: /booking/1

    public static void main(String[] args) {

        RestAssured
                .given()
                   .baseUri("https://restful-booker.herokuapp.com")
                   .basePath("/booking/1")
                .when()
                   .get()
                .then().log().all()
                   .statusCode(200);

    }
}
