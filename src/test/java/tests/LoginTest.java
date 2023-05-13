package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    @Test
    void shouldVerifyNegativeLoginWithoutUserName() {
        LoginPage loginPage = new LoginPage(driverChrome);

        loginPage.loginOnPage("", "tymczasowehaslo");

        String expectedErrorMessage = "Błąd: Nazwa użytkownika jest wymagana.";
        Assertions.assertEquals(expectedErrorMessage, loginPage.errorMessage.getText());
    }

    @Test
    void shouldVerifyNegativeLoginWithoutPassword() {
        LoginPage loginPage = new LoginPage(driverChrome);

        loginPage.loginOnPage("tester_tf", "");

        String expectedErrorMessage = "Błąd: pole hasła jest puste.";
        Assertions.assertEquals(expectedErrorMessage, loginPage.errorMessage.getText());
    }

    @Test
    void shouldVerifyPositiveLogin() {
        LoginPage loginPage = new LoginPage(driverChrome);
        loginPage.loginOnPage("tester_tf", "$Programista2023$");

        String myAccountTextVerification = "Witaj tester_tf (nie jesteś tester_tf?";
        Assertions.assertEquals(myAccountTextVerification, loginPage.myAccountContent.getText());
    }
}
