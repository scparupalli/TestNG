package com.salesforce.pages.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.salesforce.utilities.ExtentReportUtility;


public class BasePage {
	protected WebDriver driver;
	Logger mylog = LogManager.getLogger(BasePage.class);
	private WebDriverWait wait=null;
	protected ExtentReportUtility extentReport=ExtentReportUtility.getInstance();
	
	public BasePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void enterText(WebElement ele, String data, String objectName) {
		if (ele.isDisplayed()) {
			ele.clear();
			ele.sendKeys(data);
			mylog.info("username data is entered in " + objectName + " textbox");
			extentReport.logTestInfo("username data is entered in " + objectName + " textbox");
			
		} else {
			mylog.error(objectName + " element is not displayed");
		}
	}
	
	public void clickElement(WebElement ele, String objectName) {
		if (ele.isEnabled()) {
			ele.click();
			mylog.info(objectName + "button is clicked");
			extentReport.logTestInfo(objectName + "button is clicked");
			
		} else {
			mylog.error(objectName+" element is not enabled");
			
		}
	}
	
	 public String getPageTitle() {
	        String title = driver.getTitle();
	        mylog.info("Page title is: " + title);
	        return title;
	    }

	    public boolean isPageTitleDisplayed(String expectedTitle) {
	        String actualTitle = getPageTitle();
	        boolean isDisplayed = actualTitle.equals(expectedTitle);
	        if (isDisplayed) {
	            mylog.info("Expected title: " + expectedTitle + " is displayed");
	        } else {
	            mylog.error("Expected title: " + expectedTitle + " is not displayed. Actual title is: " + actualTitle);
	        }
	        return isDisplayed;
	    }
	
	public String getTextFromElement(WebElement ele, String objectName) {
		String data=null;
		if(ele.isDisplayed()) {
		data = ele.getText();
		mylog.info("text is extracted from "+objectName);
		}
		else {
			mylog.error(objectName+" not dispalyed");
		}
		return data;
	}
}
