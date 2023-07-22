package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    @Test
    void shouldVerifyNegativeLoginWithoutUserName() {
        LoginPage loginPage = new LoginPage(driver);


        loginPage.loginOnPage("", "temporaryPassword");

        Assertions.assertEquals("Błąd: Nazwa użytkownika jest wymagana.", loginPage.errorMessage.getText());
    }

    @Test
    void shouldVerifyNegativeLoginWithoutPassword() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.loginOnPage("tester_tf", "");

        Assertions.assertEquals("Błąd: pole hasła jest puste.", loginPage.errorMessage.getText());
    }

    @Test
    void shouldVerifyNegativeLoginWrongEmailProvided() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.loginOnPage("wrong@yopmail.com", "temporaryPassword");

        Assertions.assertEquals("Nieznany adres e-mail. " +
                        "Proszę sprawdzić ponownie lub wypróbować swoją nazwę użytkownika.",
                loginPage.errorMessage.getText());
    }

    @Test
    void shouldVerifyNegativeLoginWrongPasswordProvided() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.loginOnPage("tester_tf", "wrongPassword");

        Assertions.assertEquals("Błąd: wpisano niepoprawne hasło dla użytkownika tester_tf. " +
                "Nie pamiętasz hasła?", loginPage.errorMessage.getText());
    }

    @Test
    void shouldVerifyPositiveLogin() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.loginOnPage("tester_tf", "$Programista2023$");

        Assertions.assertEquals("Witaj tester_tf (nie jesteś tester_tf?", loginPage.myAccountContent.getText());
    }
}
