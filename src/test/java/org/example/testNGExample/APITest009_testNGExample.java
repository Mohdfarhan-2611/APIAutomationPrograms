package org.example.testNGExample;

import io.qameta.allure.Severity;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.PriorityQueue;

public class APITest009_testNGExample {

    @Test(priority = 1)
    public void t1()
    {
        System.out.println("1");
    }

    @Test(priority = 3)
    public void t2()
    {
        System.out.println("3");
    }

    @Test(priority = 2)
    public void t3()
    {
        System.out.println("2");
    }






}
