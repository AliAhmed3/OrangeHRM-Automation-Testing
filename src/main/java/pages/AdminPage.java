package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Utility;


public class AdminPage {
    private final WebDriver driver;

    /* locators  */
    private final By recordsText = By.cssSelector(".orangehrm-horizontal-padding");
    private final By addButton = By.cssSelector("button[class='oxd-button oxd-button--medium oxd-button--secondary']");
    private final By searchUsernameField = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    private final By searchButton = By.xpath("//button[normalize-space()='Search']");
    private final By deleteButton = By.xpath("//i[@class='oxd-icon bi-trash']");
    private final By confirmDeleteButton = By.xpath("//button[normalize-space()='Yes, Delete']");
    private final By resetButton = By.xpath("//button[normalize-space()='Reset']");
    private final By noRecordsFound = By.xpath("//span[text()='No Records Found']");

    /* Constructor */
    public AdminPage(WebDriver driver) {
        this.driver = driver;
    }

    /* actions  */
    public int getRecordCount() {
        String text = Utility.getText(driver, recordsText);
        String num = text.replaceAll("[^0-9]", "");
        return num.isEmpty() ? 0 : Integer.parseInt(num);
    }

    public AddUserPage clickAdd() {
        Utility.clickingOnElement(driver, addButton);
        return new AddUserPage(driver);
    }


    public AdminPage searchUser(String username) {
        Utility.sendData(driver, searchUsernameField, username);
        Utility.clickingOnElement(driver, searchButton);
        return this;
    }

    public AdminPage deleteUser() {
        Utility.clickingOnElement(driver, deleteButton);
        Utility.clickingOnElement(driver, confirmDeleteButton);
        Utility.ElementNotPresent(driver, deleteButton);
        return this;
    }

    public AdminPage clickReset() {
        Utility.clickingOnElement(driver, resetButton);
        return this;
    }
    public boolean isNoRecordsFound() {
        return driver.findElements(noRecordsFound).size() > 0;
    }


}
