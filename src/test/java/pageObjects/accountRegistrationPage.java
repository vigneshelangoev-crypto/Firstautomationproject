package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class accountRegistrationPage extends BasePage{

    public accountRegistrationPage(WebDriver driver)
    {
        super(driver);
    }

    //Locators
@FindBy(xpath="//input[@id='input-firstname']") WebElement firstname;
@FindBy(xpath="//input[@id='input-lastname']") WebElement lastname;
@FindBy(xpath="//input[@id='input-email']") WebElement email;
@FindBy(xpath="//input[@id='input-telephone']") WebElement mobile;
@FindBy(xpath="//input[@id='input-password']") WebElement password;
@FindBy(xpath="//input[@id='input-confirm']") WebElement cfmpassword;
@FindBy(xpath="//input[@name='agree']") WebElement agree;
@FindBy(xpath="//input[@value='Continue']") WebElement submit;
@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement msgConfirmation;

//Actions

public void setFirstName(String fn)
{
    firstname.sendKeys(fn);
}
public void setLastName(String ln)
{
    lastname.sendKeys(ln);
}
public void setEmail(String em)
{
    email.sendKeys(em);
}
public void setMobile(String mb)
{
    mobile.sendKeys(mb);
}
public void setPass(String ps)
{
    password.sendKeys(ps);
}
public void setcfmpassword(String cps)
{
    cfmpassword.sendKeys(cps);
}
public void clickAgree()
{
    agree.click();
}
public void clickSubmit()
{
    submit.click();
}
public String getConfirmationMsg() {
    try {
        return (msgConfirmation.getText());
    } catch (Exception e) {
        return(e.getMessage());
    }
}
}
