package tests;

import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.RegisterPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterTest extends BaseTest {
    @Test
    void shouldVerifyPositiveRegistration() {
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        registerPage.registerOnPage("testerek_tf", "$Testerek2023", "testerek@yopmail.com");

        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[@class='user-registration-password-strength strong']")));//sprawdzić

        assertEquals("User successfully registered.", registerPage.registerMessage.getText());

        loginPage.loginOnPage("nowy_login", "nowe_haslo");
    }

    @Test
    void registerUserWithSameEmail() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.myAccountMenuItem.click();
        registerPage.inputUserName.click();
        registerPage.inputUserName.sendKeys("tester21_tf");
        registerPage.inputPassword.click();
        registerPage.inputPassword.sendKeys("$Testerek2023");
        registerPage.inputUserEmail.click();
        registerPage.inputUserEmail.sendKeys("testerek@yopmail.com");
        registerPage.inputConfirmPassword.click();
        registerPage.inputConfirmPassword.sendKeys("$Testerek2023");
        registerPage.inputConfirmPassword.sendKeys(Keys.ENTER);
        registerPage.buttonSubmit.click();

        Assertions.assertEquals("Email already exists.", registerPage.getError());
    }

}
