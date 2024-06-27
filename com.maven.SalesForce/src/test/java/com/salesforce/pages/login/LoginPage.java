package com.salesforce.pages.login;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.salesforce.pages.base.BasePage;

public class LoginPage extends BasePage{
	
	@FindBy(id = "username") WebElement userNameEle;
    @FindBy(id = "password") WebElement passwordElement;
    @FindBy(id = "Login") WebElement loginButtonElement;
    @FindBy(id = "error") WebElement errorMessage;
    @FindBy(id = "rememberUn") WebElement rememberMeCheckbox;
    @FindBy(id = "forgot_password_link") WebElement forgotPasswordLink;
	
	
	public LoginPage(WebDriver driver) {
		
		super(driver);
	}
	
	public void enterUserName(String data) {
		enterText(userNameEle, data, "username field");
	}
	
	 public String getUsernameFieldValue() {
	        return userNameEle.getAttribute("value");
	    }
	
	public void enterPassword(String data) {
		enterText(passwordElement, data, "password field");
	}
	
	public WebDriver clickLoginButton() {
		clickElement(loginButtonElement,"login button");
		return driver;
		
	}
	
	 public void clearPasswordField() {
		 passwordElement.clear();
	    }
	 
	 public boolean isPasswordFieldEmpty() {
	        return passwordElement.getText().isEmpty();
	    }
	
	public String getTitleOfThePage() {
		//waitUntilPageLoads();
		return getTitleOfThePage();
	}
	
	
    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public void clickRememberMe() {
        rememberMeCheckbox.click();
    }

    public void clickForgotPassword() {
        forgotPasswordLink.click();
    }

	public boolean isLoginPageDisplayed(String expectedTitle) {
        return super.isPageTitleDisplayed(expectedTitle);
    }
}
