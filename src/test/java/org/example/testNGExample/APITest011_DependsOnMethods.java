package org.example.testNGExample;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonTypeInfo;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APITest011_DependsOnMethods {

   @Test
    public void serverStartedOk()
   {
       System.out.println("I will run first");
       Assert.assertTrue(true);
   }

   @Test(dependsOnMethods = "serverStartedOk")
    public void method1()
   {
       System.out.println("method1");
       Assert.assertTrue(true);
   }

   @Test(dependsOnMethods = "serverStartedOk")
    public void method2()
   {
       System.out.println("method2");
       Assert.assertTrue(true);
   }



}
