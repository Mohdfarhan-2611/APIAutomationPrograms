package org.example.Assertion;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import static org.assertj.core.api.Assertions.*;

public class APITest_017_AssertionReal {

    public static String bookingid;

    public static void main(String[] args) {

        String payload_POST= "{\n" +
                "    \"firstname\" : \"Pramod\",\n" +
                "    \"lastname\" : \"Dutta\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-01\",\n" +
                "        \"checkout\" : \"2024-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType("application/json");
        requestSpecification.body(payload_POST).log().all();

        //when
        Response response = requestSpecification.when().post();

        //Then
        ValidatableResponse validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

//        String bookingid = response.jsonPath().getString("bookingid");
//        System.out.println(bookingid);

        //Validatable Response - I - Hamcrest - RestAssured
        //Rest Assured Default - Hamcrest
        //import org.hamcrest.Matchers;


validatableResponse.body("booking.firstname", Matchers.equalTo("Pramod"));
validatableResponse.body("booking.lastname",  Matchers.equalTo("Dutta"));


         //SoftAssert vs
        //HardAssert
        //This means if any assertion fails,
        //the remaining statements in that method will not be executed

        bookingid =  response.then().extract().path("bookingid");
        String firstname = response.then().extract().path("booking.firstname");
        String lastname = response.then().extract().path("booking.lastname");
        Assert.assertNotNull(bookingid);
        Assert.assertEquals(firstname, "Pramod");
        Assert.assertEquals(lastname, "Dutta");


        //TestNG Assertion
        //AsserJ(3rd Library to Assertions)

        assertThat(bookingid).isNotNull();
        assertThat(firstname).isEqualTo("Pramod");
        assertThat(lastname).isEqualTo("Dutta").isNotNull().isNotBlank().isNotEmpty().isAlphanumeric();




    }
}
