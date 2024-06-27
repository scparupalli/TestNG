package com.salesforce.base;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.salesforce.utilities.Constants;
import com.salesforce.utilities.PropertiesUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.logging.log4j.Logger;

public class BaseTest {

	Logger mylog = LogManager.getLogger(BaseTest.class);
	protected static WebDriver driver = null;
	
	@BeforeMethod
	@Parameters("browserName")

	public void setUpBeforeMethod(@Optional("chrome") String BrowserName1) throws InterruptedException {
		mylog.info("*********************setUpBeforeMethod**************************");
		launchBrowser(BrowserName1);
		String url=PropertiesUtility.readDataFromPropertyFile("url");
		goToUrl(url);
	}
	
	@AfterMethod
	public void tearDownAfterTestMethod() {
		closeBrowser();
		mylog.info("****************tearDownAfterTestMethod*******************");
	}
	
	
	public void launchBrowser(String browserName) {

		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			//mylog.info("chrome browser instance chrome created.");
			mylog.info("chrome browser instance chrome created.");
		//	extentReport.logTestInfo("chrome browser instance chrome created.");
			driver.manage().window().maximize();
			mylog.info("window is maximized");
			
			//mylog.log(Level.INFO,"window is maximized");
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			mylog.info("firefox browser instance chrome created.");
		//	extentReport.logTestInfo("firefox browser instance chrome created.");
			driver.manage().window().maximize();
			mylog.info("window is maximized");
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			mylog.info("edge browser instance chrome created.");
			driver.manage().window().maximize();
			mylog.info("window is maximized");
			break;

		case "opera":
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
			driver.manage().window().maximize();
			break;

		case "safari":
			// Safari does not require a separate driver setup, as it is included with macOS
			driver = new SafariDriver();
			break;

		default:
			mylog.error("Unsupported browser: " + browserName);
		}

		// return driver;
	}
	
	public void goToUrl(String url) throws InterruptedException {
		driver.get(url);
		mylog.info(url + "is entered");
		//Thread.sleep(5000);
		
	}
	
	public void closeBrowser() {
		driver.close();
		mylog.info("browser instance closed");
		driver=null;
	}
	
	public void takescreenshot(String filepath) {
		 TakesScreenshot screenCapture=(TakesScreenshot)driver;
	
	}
}
