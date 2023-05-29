package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.ContactPage;

public class ContactTest extends BaseTest {
    @Test
    void shouldVerifyFromMainPageNavigateToContact() {
        ContactPage contactPage = new ContactPage(driverChrome);
        contactPage.contact.click();

        String expectedContactText = "Kontakt";
        Assertions.assertEquals(expectedContactText, contactPage.contactHeader.getText());
    }
}
