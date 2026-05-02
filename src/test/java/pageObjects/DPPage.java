package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DPPage extends BasePage{

    public DPPage(WebDriver driver)
    {
        super(driver);
    }

@FindBy (xpath="//div[@id='content']//h1")
WebElement DPHeaderElement;

@FindBy (xpath="//button[@id='button-cart']")
WebElement lnkaddToCartElement;

public String DPHeader()
{
    return DPHeaderElement.getText();
}
public void AddtoCart()
{
    lnkaddToCartElement.click();
}
}
