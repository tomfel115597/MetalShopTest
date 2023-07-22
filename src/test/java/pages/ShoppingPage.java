package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

public class ShoppingPage {
    @FindBy(xpath = "//a[@class=\'cart-contents\']")
    public WebElement cart;

    @FindBy(xpath = "//p[@class='cart-empty woocommerce-info']")
    public WebElement cartMessage;

    @FindBy(linkText = "Strona główna")
    public WebElement homeSiteMenuItem;

    @FindBy(id = "menu-item-124")
    public WebElement toShop;
    @FindBy(id = "menu-item-125")
    public WebElement myAccountMenuItem;

    @FindBy(xpath = "//a[@rel='home']")
    public WebElement logo;

    @FindBy(xpath = "//header/h1[@class='woocommerce-products-header__title page-title']")
    public WebElement homeHeader;

    @FindBy(id = "woocommerce-product-search-field-0")
    public WebElement search;

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

    @FindBy(css = "span[class=\"onsale\"]")
    public List<WebElement> products;

    @FindBy(css = "td.product-subtotal > span > bdi")
    public List<WebElement> productPrice;

    @FindBy(css = "button[name=\"add-to-cart\"]")
    public WebElement addToCart;


    @FindBy(id = "site-header-cart")
    public WebElement shopBox;

    @FindBy(css = "tr.cart-subtotal > td > span > bdi")
    public WebElement totalCartPrice;

    public String getMessageEmptyCart() {
        return messageEmptyCart.getText();
    }

    public void productOnSaleList(int i) {
//        List<WebElement> products = driverChrome.findElements(By.cssSelector("span[class=\"onsale\"]"));
        products.get(i).click();
    }

    public int productOnSaleStringToInt(int i) {
        String prodPrice;
        prodPrice = productPrice.get(i).getText();
        String numberOnly = prodPrice.replaceAll("[^0-9]", "");
        int number = Integer.parseInt(numberOnly);
        return number;
    }


    public ShoppingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}