package StepsDef;

import Pages.AccountPage;
import Pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ScreenshotHelper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class MyStepdefs {
    private WebDriver driver;
    LoginPage loginPage;
    AccountPage accountPage;
    LocalDateTime now = LocalDateTime.now();
    // Define a custom format
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    String formattedDate = now.format(formatter);



    @Before
    public void setUp() {

        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
    }
    @Given("User is on login page")
    public void userIsOnLoginPage() {
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);
        driver.get("https://www.way2automation.com/angularjs-protractor/banking/#/login");
    }

    //step definition file, it contains the actual implementation of what the feature steps should do.
    @When("User click customer login")
    public void userClickCustomerLogin() {
        loginPage.clickOnCustomerLoginButton();
        String filePath = "src/test/Screenshots/"+"screenshot"+formattedDate+".png";
        ScreenshotHelper.takeScreenshot(driver,filePath);
    }

    @And("User select customer name")
    public void userSelectCustomerName() {
        loginPage.selectOnCustomerName();

    }

    @And("User clicks on login button")
    public void userClicksOnLoginButton() {
        loginPage.clickOnLoginButton();
    }


    @Then("User is logged in successfully")
    public void userIsLoggedInSuccessfully() {
        loginPage.successMessage();

    }

    @Given("User is on account page")
    public void userIsOnAccountPage() {

    }

    @When("User select deposit")
    public void userSelectDeposit() {
        accountPage.clickOnDepositTab();
    }

    @And("User enter {string}")
    public void userEnter(String arg0) {
        accountPage.enterDepositAmount(arg0);
        accountPage.clickOnDepositButton();
    }

    @Then("User deposit successfully")
    public void userDepositSuccessfully() {
        accountPage.successMessage();
    }


    @Then("User deposit {string} to different accounts")
    public void userDepositToDifferentAccounts(String arg0) throws InterruptedException {
        accountPage.depositOnEachAccount(arg0);
    }
    @After
    public void tearDown() {
        System.out.println("Closing the browser...");
        if (driver != null) {
            driver.quit();
        }
    }
}