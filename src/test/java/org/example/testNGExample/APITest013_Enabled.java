package org.example.testNGExample;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITest013_Enabled {

    @Test
    public void test1(){
        Assert.assertTrue(true);
        System.out.println("test1");
    }

    @Test(enabled = false)
    public void test2()
    {
        Assert.assertTrue(true);
        System.out.println("test2");
    }
}
