package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.RegisterPage;

import java.time.Duration;

public class RegisterTest extends BaseTest {
    @Test
    void shouldVerifyPositiveRegistration() {
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        registerPage.registerOnPage("testerek_tf", "$Testerek2023", "testerek@yopmail.com");

        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[@class='user-registration-password-strength strong']")));//sprawdzić

        String expectedRegisterMessage = "User successfully registered.";
        Assertions.assertEquals(expectedRegisterMessage, registerPage.registerMessage.getText());

        loginPage.loginOnPage("nowy_login", "nowe_haslo");
    }

}
