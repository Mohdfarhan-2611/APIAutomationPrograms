package org.example.Assertion;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class APITest_016_Assertion {
    //TestNG Assertion
    //ER == AR
    //Expected Result == Actual Result

    @Test
    public void test_HardAssertExample()
    {
        System.out.println("Start of the program");
        Assert.assertTrue(true);
        System.out.println("End of the program");

        Assert.assertEquals("Pramod", "pramod");
        Assert.assertEquals("Pramod", "pramod");

    }


    @Test
    public void test_softAssertExamples()
    {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(false);
        System.out.println("This line will be executed");
        softAssert.assertAll();
    }


}
