package tests;
import com.github.javafaker.Faker;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import io.qameta.allure.Description;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import pages.*;
import io.qameta.allure.Feature;
import utils.DriverFactory;
import utils.ConfigReader;


@Feature("End-to-End Scenario")
@Listeners({listeners.TestListener.class, listeners.MethodListener.class,io.qameta.allure.testng.AllureTestNg.class})
public class fullScenarioTest extends BaseTest  {
    private Faker faker;
    // Generate dynamic test data

     // at least one number
    private final String USERNAME = ConfigReader.getJsonData("validLogin", "username");
    private final String PASSWORD = ConfigReader.getJsonData("validLogin", "password");

    @Severity(SeverityLevel.CRITICAL)
    @Description("End-to-end test: Add a new employee, verify it exists, and delete it.")
    @Test
    public void EndtoEnd() {
        faker = new Faker();
        String employeeName = faker.bothify("?"); // Random one letter
        String username = faker.name().username();
        String password = faker.bothify("???????#"); // Random pass with at least 7 characters and one number
        // Step 1: Login
        new LoginPage(DriverFactory.getDriver())
                .enterUsername(USERNAME)
                .enterPassword(PASSWORD)
                .clickLogin();

        // Step 2: Navigate to Admin tab
        new DashboardPage(DriverFactory.getDriver()).goToAdmin();

        // Step 3: Capture initial record count
        int initialCount = new AdminPage(DriverFactory.getDriver()).getRecordCount();
        System.out.println("Initial Count: " + initialCount);

        // Step 4: Add new user
        new AdminPage(DriverFactory.getDriver()).clickAdd()
                .selectUserRoleAdmin(1)
                .enterEmployeeName(employeeName)
                .selectStatusByArrowDown(1)
                .enterUsername(username)
                .enterPassword(password)
                .enterConfirmPassword(password)
                .clickSave();

        // Verify record count increased by 1
        int afterAddCount = new AdminPage(DriverFactory.getDriver()).getRecordCount();
        System.out.println("after add Count: " + afterAddCount);
        Assert.assertEquals(afterAddCount, initialCount + 1, "Record count should increase by 1");

        // Step 6: Search and Delete the user
        new AdminPage(DriverFactory.getDriver()).searchUser(username).deleteUser();


        // Click on the reset button then Verify record count decreased by 1
        new AdminPage(DriverFactory.getDriver()).clickReset();
        int afterDeleteCount = new AdminPage(DriverFactory.getDriver()).getRecordCount();
        System.out.println("after Delete Count: " + afterDeleteCount);
        Assert.assertEquals(afterDeleteCount, initialCount, "Record count should decrease by 1");
    }


}
