package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    @Test
    void shouldVerifyNegativeLoginWithoutUserName() {
        LoginPage loginPage = new LoginPage(driverChrome);

        loginPage.loginOnPage("", "tymczasowehaslo");

        Assertions.assertEquals("Błąd: Nazwa użytkownika jest wymagana.", loginPage.errorMessage.getText());
    }

    @Test
    void shouldVerifyNegativeLoginWithoutPassword() {
        LoginPage loginPage = new LoginPage(driverChrome);

        loginPage.loginOnPage("tester_tf", "");

        Assertions.assertEquals("Błąd: pole hasła jest puste.", loginPage.errorMessage.getText());
    }

    @Test
    void shouldVerifyNegativeLoginWrongEmailProvided() {
        LoginPage loginPage = new LoginPage(driverChrome);

        loginPage.loginOnPage("wrong@yopmail.com", "tymczasowehasło");

        Assertions.assertEquals("Nieznany adres e-mail. " +
                "Proszę sprawdzić ponownie lub wypróbować swoją nazwę użytkownika.", loginPage.errorMessage.getText());
    }

    @Test
    void shouldVerifyPositiveLogin() {
        LoginPage loginPage = new LoginPage(driverChrome);

        loginPage.loginOnPage("tester_tf", "$Programista2023$");

        Assertions.assertEquals("Witaj tester_tf (nie jesteś tester_tf?", loginPage.myAccountContent.getText());
    }
}
