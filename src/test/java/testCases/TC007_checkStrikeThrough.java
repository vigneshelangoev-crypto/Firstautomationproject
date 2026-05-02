package testCases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;

public class TC007_checkStrikeThrough extends testBase.BaseClass {
    @Test(groups={"Master","Sanity","regression"})
    public void checkStrikeThrough()
    {
        HomePage hp=new HomePage(driver);
        hp.clickSpecials();
        //Validation
        for(WebElement ele: hp.checkstrikethrough())
        {
            if(ele.getCssValue("text-decoration").contains("line-through"))
            {
                String a= ele.getCssValue("text-decoration");
                System.out.println(a);
                Assert.assertTrue(true);
            }
            else
            {
                 Assert.assertTrue(false);
            }
        }
    }

}
