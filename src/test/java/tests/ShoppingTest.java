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

public class ShoppingTest extends BaseTest{
    @Test
    void checkCartIsEmptyAddProduct() {
        ShoppingPage shoppingPage = new ShoppingPage(driverChrome);
        shoppingPage.cart.click();
        String cartText = "Twój koszyk aktualnie jest pusty.";
        Assertions.assertEquals(cartText, shoppingPage.cartMessage.getText());

        shoppingPage.homeSiteMenuItem.click();

        shoppingPage.productId24.click();

        Wait wait = new WebDriverWait(driverChrome, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//a[@title='Zobacz koszyk']")));

        WebElement showCart = driverChrome.findElement(By.xpath("//a[@title='Zobacz koszyk']"));
        showCart.click();

        String productName = "Srebrna moneta 5g - UK 1980";
        Assertions.assertEquals(productName, shoppingPage.showProduct.getText());
    }
}
