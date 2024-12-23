package org.example.testNGExample;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITest015_InvocationCount {



    @Test(invocationCount = 5)
    public void method1()
    {
        Assert.assertTrue(true);
    }
}
