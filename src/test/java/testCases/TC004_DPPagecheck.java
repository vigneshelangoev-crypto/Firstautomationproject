package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DPPage;
import pageObjects.HomePage;
import pageObjects.SRPpage;

public class TC004_DPPagecheck extends testBase.BaseClass{
    String input= "macbook";
    String ASINmatch= "macbook air";
    @Test(groups="Master")
    public void TC004_DPPagecheck() throws InterruptedException{
        HomePage hp=new HomePage(driver);
        hp.inputSearchText(input);
        hp.clickSearch();

        SRPpage srp= new SRPpage(driver);
        
        for(WebElement ele: srp.listOFASINs())
        {
            if(ele.getText().equalsIgnoreCase(ASINmatch))
            {
                System.out.println(ele.getText());
                WebElement link = ele.findElement(By.xpath("./a"));
                link.click();
                break;
            }
            else
            {
                continue;
            }
        }
        DPPage dp=new DPPage(driver);
        System.out.println(dp.DPHeader());
        //Validation
        if (dp.DPHeader().equalsIgnoreCase(ASINmatch)) {
            
            Assert.assertTrue(true);         
        }
        else
        {
            Assert.assertTrue(false);
        }

    }
    

}
