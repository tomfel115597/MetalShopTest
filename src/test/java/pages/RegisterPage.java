package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    @FindBy(id = "menu-item-146")
    private WebElement myAccountMenuItem;

    @FindBy(xpath = "//input[@id='user_login']")
    private WebElement inputUserName;

    @FindBy(xpath = "//input[@id='user_pass']")
    private WebElement inputPassword;

    @FindBy(xpath = "//input[@id='user_email']")
    private WebElement inputUserEmail;

    @FindBy(xpath = "//input[@id='user_confirm_password']")
    private WebElement inputConfirmPassword;

    @FindBy(xpath = "//button[contains(.,'Submit')]")
    private WebElement buttonSubmit;

    @FindBy(xpath = "//ul[contains(.,'User successfully registered.')]")
    public WebElement registerMessage;

       public RegisterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
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
