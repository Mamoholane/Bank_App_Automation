import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ExtentReportManager;
import utils.ScreenshotHelper;

public class TestListener implements ITestListener {
    private ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
        ExtentReportManager.initReports(); // Initialize reports
        System.out.println("Test Suite started: " + context.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = ExtentReportManager.startTest(result.getMethod().getMethodName());
        System.out.println("Test started: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test passed: " + result.getMethod().getMethodName());
        System.out.println("Test passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, "Test failed: " + result.getMethod().getMethodName());
        System.out.println("Test failed: " + result.getMethod().getMethodName());

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, "Test skipped: " + result.getMethod().getMethodName());
        System.out.println("Test skipped: " + result.getMethod().getMethodName());
    }





















}
