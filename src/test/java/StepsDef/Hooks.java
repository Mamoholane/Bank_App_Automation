package StepsDef;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ExtentReportManager;


public class Hooks {

    public static WebDriver driver;
    private ExtentTest test;
 // This hook runs before each scenario, it opens a driver (Chrome browser)
    @Before
    public void setUp() {

        if(driver == null){
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }

    }

    // This hook runs after each scenario
    @After
    public void tearDown() {
        System.out.println("Closing the browser...");
        if (driver != null) {
            driver.quit();
        }
    }
}
