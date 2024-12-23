package org.example.testNGExample;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITest010_Grouping {


@Test(groups = {"sanity", "qa", "preprod"})
public void sanityRun()
{
    System.out.println("sanity");
    System.out.println("QA");
    Assert.assertTrue(true);
}

@Test(groups = {"qa", "preprod", "reg"})
public void RegRun()
{
    System.out.println("Req");
    Assert.assertTrue(true);
}

@Test(groups = {"dev", "stag"})
public void SmokeRun()
{
    System.out.println("smoke");
    Assert.assertTrue(false);
}

@Test(groups = {"sanity", "qa", "preprod"})
public void sanityRun1()
{
    System.out.println("sanity");
    System.out.println("QA");
    Assert.assertTrue(true);
}

@Test(groups = {"dev",  "stag"})
public void RegRun2()
{
    System.out.println("Req");
    Assert.assertTrue(true);
}

@Test(groups = {"qa", "preprod", "reg"})
public void SomkeRun3()
{
    System.out.println("Smoke");
    Assert.assertTrue(true);
}


}
