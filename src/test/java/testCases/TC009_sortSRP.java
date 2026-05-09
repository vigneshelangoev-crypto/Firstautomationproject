package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DPPage;
import pageObjects.HomePage;
import pageObjects.SRPpage;

public class TC009_sortSRP extends testBase.BaseClass{
@Test(groups={"Master","Sanity"})
    public void TC009_sortSRP ()
    {
        logger.info("****Starting TC009");
        HomePage hp=new HomePage(driver);
        hp.inputSearchText("mac");
        hp.clickSearch();
        SRPpage srp=new SRPpage(driver);
        srp.clickSort();
        srp.clickHightoLow();
        srp.clickFirstASIN();
        DPPage dp=new DPPage(driver);
        //Validation
        logger.info(dp.DPHeader());
        Assert.assertEquals(dp.DPHeader().toLowerCase(), "macbook pro");
    }
}
