package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "menu-item-125")
    private WebElement myAccountMenuItem;

    @FindBy(className = "woocommerce-error")
    public WebElement errorMessage;

    @FindBy(xpath = "//input[@id='username']")
    private WebElement inputUserName;

    @FindBy(css = "#password")
    private WebElement inputPassword;

    @FindBy(css = "button[name='login']")
    private WebElement buttonLogin;

    public LoginPage(WebDriver driverChrome){
        PageFactory.initElements(driverChrome, this);
    }
    public void loginOnPage(String login, String password) {
        myAccountMenuItem.click();
        inputUserName.sendKeys(login);
        inputPassword.sendKeys(password);
        buttonLogin.click();
    }

}
