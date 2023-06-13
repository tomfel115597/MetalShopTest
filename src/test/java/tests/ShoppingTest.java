package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ShoppingPage;

import java.time.Duration;

public class ShoppingTest extends BaseTest {

    @Test
    void checkIfLogoAndSearchIsPresentOnMain() {
        ShoppingPage shoppingPage = new ShoppingPage(driverChrome);

        shoppingPage.myAccountMenuItem.click();
        Assertions.assertEquals("Softie Metal Shop", shoppingPage.logo.getText());
        Assertions.assertTrue(shoppingPage.search.isDisplayed());
    }
    @Test
    void shouldVerifyNavigateFromLoginSiteToHome() {
        ShoppingPage shoppingPage = new ShoppingPage(driverChrome);
        driverChrome.navigate().to
                ("http://serwer169007.lh.pl/autoinstalator/serwer169007.lh.pl/wordpress10772/moje-konto/");
        shoppingPage.homeSiteMenuItem.click();
        Assertions.assertEquals("Sklep", shoppingPage.homeHeader.getText());
    }
    @Test
    void checkCartIsEmptyAddProduct() {
        ShoppingPage shoppingPage = new ShoppingPage(driverChrome);
        shoppingPage.cart.click();

        Assertions.assertEquals("Twój koszyk aktualnie jest pusty.", shoppingPage.cartMessage.getText());

        shoppingPage.homeSiteMenuItem.click();

        shoppingPage.productId24.click();

        Wait wait = new WebDriverWait(driverChrome, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(shoppingPage.showCart));

        shoppingPage.showCart.click();

        Assertions.assertEquals("Srebrna moneta 5g - UK 1980", shoppingPage.showProduct.getText());
    }

    @Test
    void checkAddAndRemoveProductFromCart() {
        ShoppingPage shoppingPage = new ShoppingPage(driverChrome);
        shoppingPage.productSrebrnaMoneta.click();

        Wait waitCart = new WebDriverWait(driverChrome, Duration.ofSeconds(10));
        waitCart.until(ExpectedConditions.visibilityOf(shoppingPage.showCart));

        shoppingPage.showCart.click();
        shoppingPage.removeProduct.click();

        Wait waitCartMessage = new WebDriverWait(driverChrome, Duration.ofSeconds(10));
        waitCartMessage.until(ExpectedConditions.visibilityOfElementLocated
                (By.className("woocommerce-message")));

        Assertions.assertEquals("Twój koszyk aktualnie jest pusty.", shoppingPage.getMessageEmptyCart());
    }

    @Test
    void shouldAddPromotedProductToCartAndVerifyPrice() {
        ShoppingPage shoppingPage = new ShoppingPage(driverChrome);
        int sum = 0;
        for (int i = 0; i < shoppingPage.products.size(); i++) {
            shoppingPage.productOnSaleList(i);
            shoppingPage.addToCart.click();
            shoppingPage.toShop.click();
        }
        shoppingPage.shopBox.click();
        for (int i = 0; i < shoppingPage.productPrice.size(); i++) {
            shoppingPage.productOnSaleStringToInt(i);
            sum += shoppingPage.productOnSaleStringToInt(i);
        }
        String totalPrice = shoppingPage.totalCartPrice.getText().replaceAll("[^0-9]", "");
        int totalPriceInteger = Integer.parseInt(totalPrice);
        Assertions.assertEquals(sum, totalPriceInteger);
    }
}
