package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Utility;

public class DashboardPage {
    private final WebDriver driver;
    private final By adminTab = By.xpath("//span[text()='Admin']");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public AdminPage goToAdmin() {
        Utility.clickingOnElement(driver, adminTab);
        return new AdminPage(driver);
    }
}
