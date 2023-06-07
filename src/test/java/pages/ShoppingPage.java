package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.BaseTest;

public class ShoppingPage {
    @FindBy(xpath = "//a[@class=\'cart-contents\']")
    public WebElement cart;

    @FindBy(xpath = "//p[@class='cart-empty woocommerce-info']")
    public WebElement cartMessage;

    @FindBy(linkText = "Strona główna")
    public WebElement homeSiteMenuItem;

    @FindBy(xpath = "//a[@data-product_id='24']")
    public WebElement productId24;

    @FindBy(xpath = "//td[@data-title='Produkt']")
    public WebElement showProduct;
    @FindBy(xpath = "//a[@data-product_id='24']")
    public WebElement productSrebrnaMoneta;

    @FindBy(xpath = "//a[@title='Zobacz koszyk']")
    public WebElement showCart;

    @FindBy(xpath = "//a[text()='×']")
    public WebElement removeProduct;

    @FindBy(xpath = "//p[text()='Twój koszyk aktualnie jest pusty.']")
    public WebElement messageEmptyCart;

    public String getMessageEmptyCart() {
        return messageEmptyCart.getText();
    }


    public ShoppingPage(WebDriver driverChrome) {
        PageFactory.initElements(driverChrome, this);
    }
}