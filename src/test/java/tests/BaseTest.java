package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;
import utils.DriverFactory;
import pages.LoginPage;

import java.io.IOException;

public class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;

    @BeforeMethod
    public void setup() throws IOException {
        String baseUrl = ConfigReader.getPropertyValue("environment","BASE_URL");
        DriverFactory.getDriver().get(baseUrl);


        loginPage = new LoginPage(driver);

    }

    @AfterMethod
    public void closeBrowser() {
        DriverFactory.quitDriver();
    }
}