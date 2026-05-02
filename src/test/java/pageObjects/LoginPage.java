package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

@FindBy(xpath="//input[@id='input-email']")
WebElement emailInpuElement;

@FindBy(xpath = "//input[@id='input-password']")
WebElement passInpuElement;

@FindBy(xpath="//input[@value='Login']")
WebElement LoginbuttonElement;

//Actions
public void emailInput(String email)
{
    emailInpuElement.sendKeys(email);
}
public void passInput(String pass)
{
    passInpuElement.sendKeys(pass);
}
public void loginbtn()
{
    LoginbuttonElement.click();
}

}
