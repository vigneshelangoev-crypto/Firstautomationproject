package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Cartpage extends BasePage{
     public Cartpage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy (xpath="//div[@class='table-responsive']//tr/td[2]/a")
    List<WebElement> listOfCartitemsElement;

    public List<WebElement> listOfCartitems()
    {
        return listOfCartitemsElement;
    }
}
