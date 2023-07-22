package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

public class BaseTest {
    public static WebDriver driver;

    @BeforeAll
    static void prepareBrowser() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = DriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://serwer169007.lh.pl/autoinstalator/serwer169007.lh.pl/wordpress10772/");
    }

    @BeforeEach
    void cleanCookies() {
        driver.manage().deleteAllCookies();
    }

    @AfterEach
    void cleanCookiesAfterTest() {
        driver.manage().deleteAllCookies();
    }

    @AfterAll

    static void closeBrowser() {
        driver.quit();
    }
}
