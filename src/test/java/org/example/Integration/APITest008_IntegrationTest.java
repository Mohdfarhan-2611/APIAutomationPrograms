package org.example.Integration;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.codehaus.groovy.syntax.Token;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class APITest008_IntegrationTest {
    //create token
    //create bookingid
    //perform put
    //verify put is success by get
    //delete the id
    //verify it does not exist by get req

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    String token;
    String bookingid;

    public String getToken()
    {
        String payload = "{\n" +
                " \"username\" : \"admin\",\n" +
                " \"password\" : \"password123\"\n" +
                "}";

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/auth");
        requestSpecification.contentType("application/json");
        requestSpecification.body(payload).log().all();

        //when
        response = requestSpecification.when().post();

        //Then
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        //Extract the token
        String Token = response.jsonPath().getString("token");
        System.out.println(Token);

        assertThat(Token).isNotEmpty().isNotNull().isAlphanumeric();



        return Token;

    }

    public String bookingID()
    {
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
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType("application/json");
        requestSpecification.body(payload_POST).log().all();

        //when
        response = requestSpecification.when().post();

        //Then
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        bookingid = response.jsonPath().getString("bookingid");
        System.out.println(bookingid);

        assertThat(bookingid).isNotNull().isNotEmpty().isNotBlank();

        return bookingid;
    }

    @Test
    public void test_update_request_put()
    {
        String token = getToken();
        String bookingid = bookingID();
        System.out.println("Token "+token);
        // System.out.println(response.asString());
        System.out.println("Bookingid "+bookingid);

        String payload_POST= "{\n" +
                "    \"firstname\" : \"Farhan\",\n" +
                "    \"lastname\" : \"Dutta\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-01\",\n" +
                "        \"checkout\" : \"2024-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/"+bookingid);
        requestSpecification.contentType("application/json");
        requestSpecification.cookie("token",token);
        requestSpecification.body(payload_POST).log().all();


        //when
        response = requestSpecification.when().put();

        //Then
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

    }

    @Test
    public void test_update_request_get()
    {
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/"+bookingid);
        //requestSpecification.contentType("application/json");
        //requestSpecification.cookie("token",token);
        //requestSpecification.body(payload_POST).log().all();

        //when
        response = requestSpecification.when().log().all().get();
        requestSpecification.then().log().all().statusCode(200);

        //String firstname = response.jsonPath().getString("firstname");
        //Assert.assertEquals(firstname,"Farhan");



    }

    @Test
    public void test_update_request_delete()
    {
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/"+bookingid);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);
        //requestSpecification.body(payload_POST).log().all();

        //when
        response = requestSpecification.when().delete();

        //Then
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

    }

    @Test
    public void test_after_delete_request_get()
    {
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/"+bookingid);
        //requestSpecification.contentType("application/json");
        //requestSpecification.cookie("token",token);
        //requestSpecification.body(payload_POST).log().all();

        //when
        response = requestSpecification.when().get();

        //Then
        requestSpecification.then().log().all().statusCode(200);


    }



}
