package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Utility;

import java.time.Duration;
import java.util.List;

public class AddUserPage {
    private final WebDriver driver;
    private final Actions actions;
    private final By userRoleDropdown = By.xpath("(//div[@class='oxd-select-text--after'])[1]");
    private final By statusDropdown = By.xpath("(//div[@class='oxd-select-text--after'])[2]");
    private final By employeeNameField = By.xpath("//input[@placeholder='Type for hints...']");
    private final By usernameField = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    private final By passwordField = By.xpath("(//input[@type='password'])[1]");
    private final By confirmPasswordField = By.xpath("(//input[@type='password'])[2]");
    private final By saveButton = By.xpath("//button[@type='submit']");

    public AddUserPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public AddUserPage selectUserRoleAdmin(int presses) {
        Utility.clickingOnElement(driver, userRoleDropdown);
        for (int i = 0; i < presses; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        actions.sendKeys(Keys.ENTER).perform();
        return this;
    }


    public AddUserPage enterEmployeeName(String empName)  {
        Utility.sendData(driver, employeeNameField, empName);
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[@class='oxd-input-group.oxd-input-field-bottom-space']")
            ));
        } catch (Exception ignored) {
        }
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

        return this;
    }

    public AddUserPage selectStatusByArrowDown(int presses) {
        Utility.clickingOnElement(driver, statusDropdown);
        for (int i = 0; i < presses; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        actions.sendKeys(Keys.ENTER).perform();
        return this;
    }
    public AddUserPage enterUsername(String username) {
        Utility.sendData(driver, usernameField, username);
        return this;
    }

    public AddUserPage enterPassword(String password) {
        Utility.sendData(driver, passwordField, password);
        return this;
    }

    public AddUserPage enterConfirmPassword(String password) {
        Utility.sendData(driver, confirmPasswordField, password);
        return this;
    }

    public AdminPage clickSave() {
        Utility.clickingOnElement(driver, saveButton);
        return new AdminPage(driver);
    }
}
