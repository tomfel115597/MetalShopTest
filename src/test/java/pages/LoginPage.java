package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "menu-item-125")
    public WebElement myAccountMenuItem;

    @FindBy(className = "woocommerce-error")
    public WebElement errorMessage;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement inputUserName;

    @FindBy(css = "#password")
    public WebElement inputPassword;

    @FindBy(css = "button[name='login']")
    public WebElement buttonLogin;

    @FindBy(className = "woocommerce-notices-wrapper")
    public WebElement myAccountContent;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void loginOnPage(String login, String password) {
        myAccountMenuItem.click();
        inputUserName.sendKeys(login);
        inputPassword.sendKeys(password);
        buttonLogin.click();
    }

}
