package com.salesforce.utilities;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class ExtentReportUtility {

	private static ExtentReports extent;
    private static ExtentTest test;

    private static ExtentReportUtility instance = null;

    private ExtentReportUtility() {
        // Initialize ExtentReports and ExtentHtmlReporter
        extent = new ExtentReports();
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("path/to/report.html");
        extent.attachReporter(htmlReporter);
    }

    public static ExtentReportUtility getInstance() {
        if (instance == null) {
            instance = new ExtentReportUtility();
        }
        return instance;
    }

    public void startSingleTestReport(String testName) {
        test = extent.createTest(testName);
    }

    public void logTestPassed(String message) {
        test.log(Status.PASS, message);
    }

    public void logTestFailed(String message) {
        test.log(Status.FAIL, message);
    }
    
    public void logTestInfo(String message) {
        test.log(Status.INFO, message);
    }

    public void logTestFailedWithException(Throwable throwable) {
        test.log(Status.FAIL, throwable);
    }

    public void logTestWithScreenshot(String screenshotPath) throws IOException {
        test.addScreenCaptureFromPath(screenshotPath);
    }

    public void startExtentReport() {
        // Start the extent report
    }

    public void endReport() {
        // End the extent report
        extent.flush();
    }
}
