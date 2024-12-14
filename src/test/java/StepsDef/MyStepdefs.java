package StepsDef;

import Pages.AccountPage;
import Pages.LoginPage;
import com.aventstack.extentreports.Status;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ExtentReportManager;
import utils.ScreenshotHelper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class MyStepdefs {

    LoginPage loginPage;
    AccountPage accountPage;
    static LocalDateTime now = LocalDateTime.now();
    // Define a custom format
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    static String formattedDate = now.format(formatter);
    public static String filePath = "src/test/Screenshots/"+"screenshot"+formattedDate+".png";
    private WebDriver driver = Hooks.driver;

    
    @Given("User is on login screen")
    public void userIsOnLoginScreen() {
        ExtentReportManager.getTest().log(Status.INFO, "Navigating to the application...");
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);
        driver.get("https://www.way2automation.com/angularjs-protractor/banking/#/login");
    }

    @When("User enter Email {string}")
    public void userEnterEmail(String arg0) {
        
    }

    @And("User enter Password {string}")
    public void userEnterPassword(String arg0 ){
    }
    

    @And("User click on login button")
    public void userClickOnLoginButton() {
    }
}