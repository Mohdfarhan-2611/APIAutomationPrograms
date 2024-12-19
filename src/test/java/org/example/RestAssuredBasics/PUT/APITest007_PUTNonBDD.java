package org.example.RestAssuredBasics.PUT;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.Validatable;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITest007_PUTNonBDD {


    @Description("Verify the put request for the retsful booker APIs")
    @Test
    public void test_put_nonbdd()
    {
          //BookingID
          //token
          //Payload
          //Content-Type

        //"token": "2cce9620e0203f7"
        //bookingid": 2115

        String Token = "048ccb9dc5aa9c7";
        String Bookingid = "2403";

        String payloadPUT= "{\n" +
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
        requestSpecification.basePath("/booking/"+Bookingid);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", Token);
        requestSpecification.body(payloadPUT).log().all();

        Response response = requestSpecification.when().put();

        ValidatableResponse validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);











    }

}
