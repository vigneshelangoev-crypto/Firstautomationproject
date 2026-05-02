package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import groovyjarjarasm.asm.Label;

public class SRPpage extends BasePage{

    public SRPpage(WebDriver driver)
{
    super(driver);
}
@FindBy (xpath="/html[1]/body[1]/div[2]/div[1]/div[1]/h1[1]")
WebElement srpvalidationtxElement;

@FindBy (xpath="//*[@id='content']//div[3]//div//h4")
List <WebElement> listOfASINsElement;

@FindBy(xpath="//select[@id='input-sort']")
WebElement clickSortlnkElement;

@FindBy(xpath="//option[@value='https://tutorialsninja.com/demo/index.php?route=product/search&sort=p.price&order=DESC&search=mac']")
WebElement selectHightoLoWebElement;

@FindBy(xpath="//div[3]/div[1]/div[1]/div[1]")
WebElement clickfirstASIElement;

public String srpValidationtxt()
{
    String v= srpvalidationtxElement.getText();
    return v;
} 
public List<WebElement> listOFASINs()
{
 return listOfASINsElement;
}
public void clickSort()
{
    clickSortlnkElement.click();
}
public void clickHightoLow()
{
    selectHightoLoWebElement.click();
}
public void clickFirstASIN()
{
    clickfirstASIElement.click();
}
}
