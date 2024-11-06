package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
    private static ExtentReports extent;
    private static ExtentTest test;

    public static void initReports() {
        // Initialize the HTML reporter
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("src/test/reports/extentReport.html");
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle("DemoBlaze Automation Report");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);


    }

    public static ExtentTest startTest(String testName) {

        test = extent.createTest(testName);
        return test;
    }

    public static void endTest() {
        extent.flush(); // Write the results to the report
    }
}