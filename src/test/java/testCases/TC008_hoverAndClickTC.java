package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;

public class TC008_hoverAndClickTC extends testBase.BaseClass{
    @Test(groups={"regression","Sanity","Master"})
    public void TC008_hoverAndClickTC()
    {
        HomePage hp=new HomePage(driver);
        hp.hoverDesktop();
        hp.clickMac();

        // Validation
        if (hp.getCategoryHeader().equalsIgnoreCase("mac"))
        {
            Assert.assertTrue(true);
        }
        else
        {
            Assert.assertTrue(false);
        }
    }


}
