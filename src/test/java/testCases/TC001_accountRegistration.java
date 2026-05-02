package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.accountRegistrationPage;

public class TC001_accountRegistration extends testBase.BaseClass {


    @Test(groups={"Master","Sanity"})
    public void verify_account_registration()
    {
        logger.info("****Starting TC001_AccountReg****");
       HomePage hp=new HomePage(driver);
       hp.clickMyAccount();
       hp.clickRegister();
       logger.info("****In to Register page****");
        String pass= randomAlphanumericString();
       accountRegistrationPage ar= new accountRegistrationPage(driver);
       ar.setFirstName(randomString());
       ar.setLastName(randomString());
       ar.setEmail(randomString()+"@gmail.com");
       ar.setMobile(randomNumbers());

       ar.setcfmpassword(pass);
       ar.setPass(pass);

       ar.clickAgree();
       ar.clickSubmit();
        logger.info("****Finished TC001_AccountReg****");
       String confmsg=ar.getConfirmationMsg();
       //Assert.assertEquals(confmsg, "Your Account Has Been Created!");
       if(confmsg.equals("Your Account Has Been Created!"))
       {
        Assert.assertTrue(true);
       }
       else
       {
        logger.error("Test Failed");
        logger.debug("Debug log");
        Assert.assertTrue(false);
       }
    }
}
