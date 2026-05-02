package testCases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;

public class TC006_currencycheck extends testBase.BaseClass {
    @Test(groups={"Sanity","Master"})
    public void TC006_currencycheck() throws Exception
    {
        HomePage hp=new HomePage(driver);
        hp.clickCurrency();
        Thread.sleep(3000);
        hp.selectUSdollars();
        // Validation
        for(WebElement ele: hp.checkcurrency())
        {
            System.out.println(ele.getText());
            if(ele.getText().contains("$"))
        {
            Assert.assertTrue(true);
        }
        else
        {
            Assert.assertTrue(false);
        }
        }
        
    }

}
