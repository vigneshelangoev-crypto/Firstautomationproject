package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

    public MyAccountPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
    WebElement lnkLogout;
    @FindBy(xpath="//h2[normalize-space()='My Account']")
    WebElement myAccDisplay;

    //Actions
    public void clickLogout()
    {
        lnkLogout.click();
    }
    public boolean DisplayAcc()
    {
        try {
            boolean targetelement=myAccDisplay.isDisplayed();
        return targetelement;
        } catch (Exception e) {
            return false;
        }
        
    }
}
