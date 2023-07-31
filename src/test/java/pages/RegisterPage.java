package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    @FindBy(id = "menu-item-146")
    public WebElement myAccountMenuItem;

    @FindBy(xpath = "//input[@id='user_login']")
    public WebElement inputUserName;

    @FindBy(xpath = "//input[@id='user_pass']")
    public WebElement inputPassword;

    @FindBy(xpath = "//input[@id='user_email']")
    public WebElement inputUserEmail;

    @FindBy(xpath = "//input[@id='user_confirm_password']")
    public WebElement inputConfirmPassword;

    @FindBy(xpath = "//button[contains(.,'Submit')]")
    public WebElement buttonSubmit;

    @FindBy(xpath = "//ul[contains(.,'User successfully registered.')]")
    public WebElement registerMessage;

    @FindBy(xpath = "//li[contains(.,'Email already exists.')]")
    private WebElement error;

    public RegisterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public  WebElement getError(){
        return error;
    }

    public void registerOnPage(String login, String password, String email) {
        myAccountMenuItem.click();
        inputUserName.click();
        long currentTime = System.currentTimeMillis();
        inputUserName.sendKeys(currentTime + login);
        inputPassword.click();
        inputPassword.sendKeys(password);
        inputUserEmail.click();
        inputUserEmail.sendKeys(currentTime + email);
        inputConfirmPassword.click();
        inputConfirmPassword.sendKeys(password);
        inputConfirmPassword.sendKeys(Keys.ENTER);
        buttonSubmit.click();
    }


}
