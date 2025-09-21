package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.Utility;

public class LoginPage {
    private final WebDriver  driver;
/* locators  */
    private final By usernameField = By.name("username");
    private final By passwordField = By.name("password");
    private final By loginButton = By.cssSelector("button[type='submit']");


    /* Constructor */
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    /* actions  */
    public LoginPage enterUsername(String username) {
        Utility.sendData(driver, usernameField, username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        Utility.sendData(driver, passwordField, password);
        return this;
    }

    public DashboardPage clickLogin() {
        Utility.clickingOnElement(driver, loginButton);
        return new DashboardPage(driver);
    }

}
