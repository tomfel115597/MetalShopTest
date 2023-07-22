package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.ContactPage;

public class ContactTest extends BaseTest {
    @Test
    void shouldVerifyFromMainPageNavigateToContact() {
        ContactPage contactPage = new ContactPage(driver);
        contactPage.contact.click();

        Assertions.assertEquals("Kontakt", contactPage.getContactHeader());
    }

    @Test
    void checkSendMessageContact() {
        ContactPage contactPage = new ContactPage(driver);
        contactPage.contact.click();

        contactPage.inputYourName.sendKeys("Jan Tester");
        contactPage.inputYourEmail.sendKeys("brabumonnoido-5897@yopmail.com");
        contactPage.inputYourSubject.sendKeys("Zapytanie");
        contactPage.inputYourMessage.sendKeys("Wiadomość próbna");
        contactPage.buttonSubmit.click();

        Assertions.assertEquals("Wystąpił problem z wysłaniem twojej wiadomości. Spróbuj ponownie później.",
                contactPage.getContactMessageText());
    }



}
