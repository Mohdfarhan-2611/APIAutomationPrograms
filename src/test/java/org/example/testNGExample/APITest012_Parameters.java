package org.example.testNGExample;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class APITest012_Parameters {

    @Parameters("browser")
    @Test
    public void demo(@Optional("chrome") String value)
    {
        System.out.println("Browser is"+value);
        if(value.equalsIgnoreCase("chrome"))
        {
            System.out.println("Starting my chrome");
        }

        if(value.equalsIgnoreCase("firefox"))
        {
            System.out.println("Starting my firefox");
        }
    }
}
