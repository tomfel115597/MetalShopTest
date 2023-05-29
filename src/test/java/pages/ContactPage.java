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
    public ContactPage(WebDriver driverChrome) {
        PageFactory.initElements(driverChrome, this);
    }
}
