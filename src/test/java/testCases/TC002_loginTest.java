package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviderClass;

public class TC002_loginTest extends testBase.BaseClass{

@Test(dataProvider="LoginData", dataProviderClass=DataProviderClass.class, groups={"Sanity","Master"})
public void verifyLogin(String email, String pwd, String expres) throws InterruptedException
{
    logger.info("****Starting TC002****");
   try{
    HomePage hp=new HomePage(driver);
    Thread.sleep(1000);
    hp.clickMyAccount();
    hp.clickLogin();

    LoginPage lp=new LoginPage(driver);
    lp.emailInput(email);
    lp.passInput(pwd);
    lp.loginbtn();
    
    //Validation
    // if expres is valid - login sucess - pass
    // if expres is valid - login fail - fail

    // if expres is invalid - login sucess - fail
    // if expres is invalid - login fail - pass
    MyAccountPage ap=new MyAccountPage(driver);
    boolean targetele=ap.DisplayAcc();
    System.out.println(expres+"  "+targetele);
    
    if(expres.equalsIgnoreCase("valid"))
    {
        if(targetele==true)
        {
            ap.clickLogout();
            Assert.assertTrue(true);
        }
        else
        {
            Assert.assertTrue(false);
        }
    }
   if(expres.equalsIgnoreCase("invalid"))
    {
        if(targetele==false)
        {
           
            Assert.assertTrue(true);
            logger.info("invalid passes");

        }
        else
        {
             ap.clickLogout();
            logger.info("this got executed");
            Assert.assertTrue(false);
        }
    }
}
catch(Exception e)
{
    Assert.fail();
}

}

}
