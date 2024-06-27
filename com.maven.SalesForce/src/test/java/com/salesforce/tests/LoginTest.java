package com.salesforce.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.salesforce.base.BaseTest;
import com.salesforce.pages.login.LoginPage;
import com.salesforce.utilities.PropertiesUtility;

public class LoginTest extends BaseTest{
	
	@Test
    public void loginWithNoPassword() {
        
        LoginPage loginPage = new LoginPage(driver);
        
        Assert.assertTrue(loginPage.isPageTitleDisplayed("Login | Salesforce"), "Salesforce application page is not displayed");

        String username = PropertiesUtility.readDataFromPropertyFile("username");
        
        loginPage.enterUserName(username);

        
        Assert.assertEquals(loginPage.getUsernameFieldValue(), username, "User Name is not displayed in User name field");

        loginPage.clearPasswordField();

        Assert.assertTrue(loginPage.isPasswordFieldEmpty(), "Password field is not empty");

        loginPage.clickLoginButton();

        Assert.assertEquals(loginPage.getErrorMessage(), "Please enter your password.", "Error message is not displayed");

        System.out.println("Test case executed successfully!");
        
    }


}
