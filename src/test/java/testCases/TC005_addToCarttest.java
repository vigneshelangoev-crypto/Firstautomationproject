package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.Assert;

import pageObjects.Cartpage;
import pageObjects.DPPage;
import pageObjects.HomePage;
import pageObjects.SRPpage;


public class TC005_addToCarttest extends testBase.BaseClass {
    String input= "macbook";
    String ASINmatch= "macbook air";
    @Test(groups={"regression","Master"})
    public void TC005_addToCarttest() throws InterruptedException{
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
        dp.AddtoCart();
        hp.clickCart();
        Cartpage cart=new Cartpage(driver);
        //Validation
        for(WebElement elem: cart.listOfCartitems())
        {
            if(elem.getText().equalsIgnoreCase(ASINmatch))
            {
                Assert.assertTrue(true);
                break;
            }
            else
            {
                Assert.assertTrue(false);
            }
        }

    }
    }

