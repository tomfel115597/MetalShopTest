package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
    @FindBy(id = "menu-item-132")
    public WebElement contact;
    @FindBy(xpath = "//header/h1[@class='entry-title']")
    public WebElement contactHeader;
    @FindBy(name = "your-name")
    public WebElement inputYourName;

    @FindBy(name = "your-email")
    public WebElement inputYourEmail;

    @FindBy(name = "your-subject")
    public WebElement inputYourSubject;

    @FindBy(name = "your-message")
    public WebElement inputYourMessage;

    @FindBy(xpath = "//input[@value='Wyślij']")
    public WebElement buttonSubmit;

    @FindBy(name = "wpcf7-response-output")
    public WebElement contactMessage;

    public ContactPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getContactHeader() {
        return contactHeader.getText();
    }
    public String getContactMessageText(){
        return contactMessage.getText();
    }
}
