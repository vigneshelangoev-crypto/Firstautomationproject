package pageObjects;

import org.openqa.selenium.WebDriver;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {


    public HomePage(WebDriver driver)
    {
        super(driver);
    }
Actions act=new Actions(driver);
@FindBy(xpath="//i[@class='fa fa-user']") 
WebElement lnkMyAccElement;

@FindBy(linkText="Register") 
WebElement lnkRegisterElement;

@FindBy(xpath="//a[normalize-space()='Login']")
WebElement lnkLoginElement;

@FindBy(xpath="//input[@placeholder='Search']")
WebElement lnkSearchTxtboxElement;

@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
WebElement lnkSearchIconElement;

@FindBy(xpath="//a[@title='Shopping Cart']//i[@class='fa fa-shopping-cart']")
WebElement lnkCarElement;

@FindBy(xpath="//button[@class='btn btn-link dropdown-toggle']")
WebElement lnkCurrencyElement;
@FindBy(xpath="//button[normalize-space()='£Pound Sterling']")
WebElement lnkPoundSterlingElement;
@FindBy(xpath="//button[normalize-space()='$US Dollar']")
WebElement lnkUSDollarsElement;
@FindBy(xpath="//button[contains(text(),'€Euro')]")
WebElement lnkEuroElement;
@FindBy(xpath="//div[@class='product-thumb transition']//p[2]")
List<WebElement> currencyvaltext;
@FindBy(xpath="//span[@class='price-old']")
List<WebElement> stikethourghElements;
@FindBy(xpath="//a[normalize-space()='Specials']")
WebElement lnkSpecialsElement;
@FindBy(xpath="//a[normalize-space()='Desktops']")
WebElement DesktopHoverlnk;
@FindBy(xpath="//a[normalize-space()='Mac (1)']")
WebElement maclnk;
@FindBy(xpath="//div[@id='content']//h2")
WebElement categoryHeader;

public void clickMyAccount()
{
    lnkMyAccElement.click();
}
public void clickRegister()
{
    lnkRegisterElement.click();
}
public void clickLogin()
{
    lnkLoginElement.click();
}
public void inputSearchText(String input)
{
    lnkSearchTxtboxElement.sendKeys(input);;
}
public void clickSearch()
{
    lnkSearchIconElement.click();
}
public void clickCart()
{
    lnkCarElement.click();
}
public void clickCurrency()
{
    lnkCurrencyElement.click();
}
public void selectEuro()
{
    lnkEuroElement.click();
}
public void selectUSdollars()
{
    lnkUSDollarsElement.click();
}
public void selectPound()
{
    lnkPoundSterlingElement.click();
}
public List<WebElement> checkcurrency()
{
   return currencyvaltext; 
} 
public List<WebElement> checkstrikethrough()
{
    return stikethourghElements;
}
public void clickSpecials()
{
    lnkSpecialsElement.click();
}
public void hoverDesktop()
{
    act.moveToElement(DesktopHoverlnk).perform();
}
public void clickMac()
{
    maclnk.click();
}
public String getCategoryHeader()
{
    return categoryHeader.getText();
}
}
