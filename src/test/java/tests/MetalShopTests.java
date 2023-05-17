package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.RegisterPage;
import tests.BaseTest;

import java.time.Duration;
import java.util.List;

public class MetalShopTests extends BaseTest {
//    public void loginOnPage(String login, String password) {
//        WebElement inputUserName = driverChrome.findElement(By.xpath("//input[@id='username']"));
//        inputUserName.sendKeys(login);
//
//        WebElement inputPassword = driverChrome.findElement(By.cssSelector("#password"));
//        inputPassword.sendKeys(password);
//
//        WebElement buttonLogin = driverChrome.findElement(By.cssSelector("button[name='login']"));
//        buttonLogin.click();
//    }

    private void productOnSaleList(int i) {
        List<WebElement> products = driverChrome.findElements(By.cssSelector("span[class=\"onsale\"]"));
        products.get(i).click();
    }

    private int productOnSaleStringToInt(int i) {
        List<WebElement> productPrice = driverChrome.findElements(By.cssSelector("td.product-subtotal > span > bdi"));
        String prodPrice;
        prodPrice = productPrice.get(i).getText();
        String numberOnly = prodPrice.replaceAll("[^0-9]", "");
        int number = Integer.parseInt(numberOnly);
        return number;
    }

    @Test
    void checkIfLogoAndSearchIsPresentOnMain() {
        WebElement logo = driverChrome.findElement(By.xpath("//a[@rel='home']"));
        String expectedLogoText = "Softie Metal Shop";
        Assertions.assertEquals(expectedLogoText, logo.getText());

        WebElement search = driverChrome.findElement(By.id("woocommerce-product-search-field-0"));
        Assertions.assertTrue(search.isDisplayed());

        WebElement myAccountMenuItem = driverChrome.findElement(By.id("menu-item-125"));
        myAccountMenuItem.click();

        Assertions.assertEquals(expectedLogoText, logo.getText());
        Assertions.assertTrue(search.isDisplayed());
    }

    @Test
    void shouldVerifyFromMainPageNavigateToContact() {
        WebElement contact = driverChrome.findElement(By.id("menu-item-132"));
        contact.click();

        WebElement contactHeader = driverChrome.findElement(By.xpath("//header/h1[@class='entry-title']"));
        String expectedContactText = "Kontakt";
        Assertions.assertEquals(expectedContactText, contactHeader.getText());
    }

    @Test
    void shouldVerifyNavigateFromLoginSiteToHome() {
        driverChrome.navigate().to
                ("http://serwer169007.lh.pl/autoinstalator/serwer169007.lh.pl/wordpress10772/moje-konto/");
        WebElement HomeSiteMenuItem = driverChrome.findElement(By.linkText("Strona główna"));
        HomeSiteMenuItem.click();
        WebElement homeHeader = driverChrome.findElement
                (By.xpath("//header/h1[@class='woocommerce-products-header__title page-title']"));

        String expectedHomeText = "Sklep";
        Assertions.assertEquals(expectedHomeText, homeHeader.getText());
    }

    @Test
    void checkSendMessageContact() {
        WebElement contact = driverChrome.findElement(By.id("menu-item-132"));
        contact.click();

        WebElement inputYourName = driverChrome.findElement(By.name("your-name"));
        inputYourName.sendKeys("Jan Tester");

        WebElement inputYourEmail = driverChrome.findElement(By.name("your-email"));
        inputYourEmail.sendKeys("brabumonnoido-5897@yopmail.com");

        WebElement inputYourSubject = driverChrome.findElement(By.name("your-subject"));
        inputYourSubject.sendKeys("Zapytanie");

        WebElement inputYourMessage = driverChrome.findElement(By.name("your-message"));
        inputYourMessage.sendKeys("Wiadomość próbna");

        WebElement buttonSubmit = driverChrome.findElement(By.xpath("//input[@value='Wyślij']"));
        buttonSubmit.click();

        WebElement contactMessage = driverChrome.findElement(By.className("wpcf7-response-output"));
        String messageContactText = "Wystąpił problem z wysłaniem twojej wiadomości. Spróbuj ponownie później.";
        Assertions.assertEquals(messageContactText, contactMessage.getText());

    }

    @Test
    void checkCartIsEmptyAddProduct() {
        WebElement cart = driverChrome.findElement(By.xpath("//a[@class='cart-contents']"));
        cart.click();

        WebElement cartMessage = driverChrome.findElement(By.xpath("//p[@class='cart-empty woocommerce-info']"));
        String cartText = "Twój koszyk aktualnie jest pusty.";
        Assertions.assertEquals(cartText, cartMessage.getText());

        WebElement HomeSiteMenuItem = driverChrome.findElement(By.linkText("Strona główna"));
        HomeSiteMenuItem.click();

        WebElement productId24 = driverChrome.findElement(By.xpath("//a[@data-product_id='24']"));
        productId24.click();

        Wait wait = new WebDriverWait(driverChrome, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//a[@title='Zobacz koszyk']")));

        WebElement showCart = driverChrome.findElement(By.xpath("//a[@title='Zobacz koszyk']"));
        showCart.click();

        WebElement showProduct = driverChrome.findElement(By.xpath("//td[@data-title='Produkt']"));
        String productName = "Srebrna moneta 5g - UK 1980";
        Assertions.assertEquals(productName, showProduct.getText());
    }

    @Test
    void checkAddAndRemoveProductFromCart() {
        WebElement productSrebrnaMoneta = driverChrome.findElement(By.xpath("//a[@data-product_id='24']"));
        productSrebrnaMoneta.click();

        Wait waitCart = new WebDriverWait(driverChrome, Duration.ofSeconds(10));
        waitCart.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//a[@title='Zobacz koszyk']")));

        WebElement showCart = driverChrome.findElement(By.xpath("//a[@title='Zobacz koszyk']"));
        showCart.click();
        WebElement removeProduct = driverChrome.findElement(By.xpath("//a[text()='×']"));
        removeProduct.click();

        Wait waitCartMessage = new WebDriverWait(driverChrome, Duration.ofSeconds(10));
        waitCartMessage.until(ExpectedConditions.visibilityOfElementLocated
                (By.className("woocommerce-message")));

        WebElement messageCart = driverChrome.findElement
                (By.xpath("//p[text()='Twój koszyk aktualnie jest pusty.']"));
        String message = "Twój koszyk aktualnie jest pusty.";
        Assertions.assertEquals(message, messageCart.getText());
    }

    @Test
    void shouldAddPromotedProductToCartAndVerifyPrice() {
        List<WebElement> products = driverChrome.findElements(By.cssSelector("span[class=\"onsale\"]"));
        int sum = 0;
        for (int i = 0; i < products.size(); i++) {
            productOnSaleList(i);
            WebElement addToCart = driverChrome.findElement(By.cssSelector("button[name=\"add-to-cart\"]"));
            addToCart.click();
            WebElement toShop = driverChrome.findElement(By.id("menu-item-124"));
            toShop.click();
        }
        WebElement shopBox = driverChrome.findElement(By.id("site-header-cart"));
        shopBox.click();
        List<WebElement> productPrice = driverChrome.findElements(By.cssSelector("td.product-subtotal > span > bdi"));
        for (int i = 0; i < productPrice.size(); i++) {
            productOnSaleStringToInt(i);
            sum += productOnSaleStringToInt(i);
        }
        WebElement totalCartPrice = driverChrome.findElement(By.cssSelector("tr.cart-subtotal > td > span > bdi"));
        String totalPrice = totalCartPrice.getText().replaceAll("[^0-9]", "");
        int totalPriceInteger = Integer.parseInt(totalPrice);
        Assertions.assertEquals(sum, totalPriceInteger);

    }
}
