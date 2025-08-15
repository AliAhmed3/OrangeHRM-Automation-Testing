package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            options.addArguments("--disable-save-password-bubble");
            options.addArguments("--disable-autofill-keyboard-accessory-view");
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--disable-features=PasswordManagerOnboarding,PasswordLeakDetection");
            options.addArguments("--no-default-browser-check");
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options); // Selenium 4 auto-detects driver

        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
