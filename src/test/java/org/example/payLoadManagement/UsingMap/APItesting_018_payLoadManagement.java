package org.example.payLoadManagement.UsingMap;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import java.util.LinkedHashMap;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;


public class APItesting_018_payLoadManagement {



    public static void main(String[] args) {

        Map<String, Object> jsonBodyUsingMap = new LinkedHashMap();
        jsonBodyUsingMap.put("firstname", "jim");
        jsonBodyUsingMap.put("lastname", "brown");
        jsonBodyUsingMap.put("totalprice", 123);
        jsonBodyUsingMap.put("depositpaid",true);

        Map<String, Object> bookingDatesMap = new LinkedHashMap();
        bookingDatesMap.put("checkin", "2018-01-01");
        bookingDatesMap.put("checkout", "2019-01-01");

        jsonBodyUsingMap.put("bookingdates",bookingDatesMap);

        System.out.println(jsonBodyUsingMap);

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType("application/json");
        requestSpecification.body(jsonBodyUsingMap).log().all();

        //when
        Response response = requestSpecification.when().post();

        Integer bookingid = response.then().extract().path("bookingid");

        //Then
        ValidatableResponse validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        assertThat(bookingid).isNotNull().isPositive().isNotZero();
        System.out.println("Booking id is " +bookingid);


    }
}
