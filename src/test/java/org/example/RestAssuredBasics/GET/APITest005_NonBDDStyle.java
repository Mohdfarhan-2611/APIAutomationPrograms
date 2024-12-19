package org.example.RestAssuredBasics.GET;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITest005_NonBDDStyle {

    static RequestSpecification r = RestAssured.given();

    String pincode = "560037";

    @Severity(SeverityLevel.CRITICAL)
    @Description("TC1 - NonBDDStyle - Positive testcase")
    @Test
    public void test_NonBDDStyleGET_Positive() {
        r.baseUri("https://api.zippopotam.us/");
        r.basePath("/IN/388620");
        r.when().log().all().get();
        r.then().log().all().statusCode(200);
    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("TC2 - NonBDDStyle - Negative testcase")
      @Test
        public void test_NonBDDStyleGET_Negative() {
          r.baseUri("https://api.zippopotam.us/");
          r.basePath("/IN/-1");
            r.when().log().all().get();
            r.then().log().all().statusCode(200);
    }

}