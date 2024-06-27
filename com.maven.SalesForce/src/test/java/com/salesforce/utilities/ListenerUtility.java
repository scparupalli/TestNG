package com.salesforce.utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.salesforce.base.BaseTest;

public class ListenerUtility extends BaseTest implements ITestListener {

    protected Logger mylog = LogManager.getLogger();
    public static ExtentReportUtility extentReport = ExtentReportUtility.getInstance();

    @Override
    public void onTestStart(ITestResult result) {
        mylog.info(result.getName() + " started------");
        extentReport.startSingleTestReport(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        mylog.info(result.getName() + " ended with success------------");
        extentReport.logTestPassed(result.getMethod().getMethodName() + " ended with success------------");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        mylog.error(result.getName() + " ended with failure------------");
        extentReport.logTestFailed(result.getMethod().getMethodName() + " test is failed");
        extentReport.logTestFailedWithException(result.getThrowable());
        String dir = Constants.SCREENSHOTS_DIRECTORY_PATH;
        String filename = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
        String path = dir + filename + ".png";
        takeScreenshot(path);
        try {
			extentReport.logTestWithScreenshot(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Handle skipped test case if needed
    }

    @Override
    public void onStart(ITestContext context) {
        mylog.info(context.getName() + " Test has started------------------");
        extentReport.startExtentReport();
    }

    @Override
    public void onFinish(ITestContext context) {
        mylog.info(context.getName() + " Test has ended-------------");
        extentReport.endReport();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Handle test failed within success percentage if needed
    }

    private void takeScreenshot(String path) {
        // Your screenshot capture logic here, assuming you have a method to capture screenshots
    }
}
