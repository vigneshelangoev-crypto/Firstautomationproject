package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SRPpage;


public class TC003_srpcheck extends testBase.BaseClass{

    String input= "macbook";
    @Test(groups={"Master","Sanity"})
    public void TC003_srpcheck()
    {
        HomePage hp=new HomePage(driver);
        hp.inputSearchText(input);
        hp.clickSearch();

        SRPpage srp= new SRPpage(driver);
        String result= srp.srpValidationtxt();

        //Validation
        System.out.println(result);
        if(result.contains(input))
        {
           Assert.assertTrue(true);
        }
        else
        {
            Assert.assertTrue(false);
        }

    }
}
