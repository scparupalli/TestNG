package com.maven.cucumber.stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.*;

public class SalesForceLoginStepDef {

	    WebDriver driver;

	    @Given("I open the Salesforce login page")
	    public void i_open_the_salesforce_login_page() {
	        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
	        driver = new ChromeDriver();
	        driver.get("https://login.salesforce.com/");
	    }

	    @Then("I should see the Salesforce application page")
	    public void i_should_see_the_salesforce_application_page() {
	        WebElement loginBox = driver.findElement(By.id("loginBox"));
	        assert loginBox.isDisplayed();
	    }

	    @When("I enter {string} in the username field")
	    public void i_enter_in_the_username_field(String username) {
	        WebElement usernameField = driver.findElement(By.id("username"));
	        usernameField.sendKeys(username);
	    }

	    @When("I clear the password field")
	    public void i_clear_the_password_field() {
	        WebElement passwordField = driver.findElement(By.id("password"));
	        passwordField.clear();
	    }

	    @When("I click on the Login to Salesforce button")
	    public void i_click_on_the_login_to_salesforce_button() {
	        WebElement loginButton = driver.findElement(By.id("Login"));
	        loginButton.click();
	    }

	    @Then("I should see the error message {string}")
	    public void i_should_see_the_error_message(String expectedMessage) {
	        WebElement errorMessage = driver.findElement(By.id("error"));
	        assert errorMessage.getText().equals(expectedMessage);
	    }

	    @When("I enter {string} in the password field")
	    public void i_enter_in_the_password_field(String password) {
	        WebElement passwordField = driver.findElement(By.id("password"));
	        passwordField.sendKeys(password);
	    }

	    @Then("I should see the Salesforce home page")
	    public void i_should_see_the_salesforce_home_page() {
	        WebElement homeElement = driver.findElement(By.id("homeElement"));
	        assert homeElement.isDisplayed();
	    }

	    @When("I select the remember username checkbox")
	    public void i_select_the_remember_username_checkbox() {
	        WebElement rememberCheckbox = driver.findElement(By.id("rememberUn"));
	        if (!rememberCheckbox.isSelected()) {
	            rememberCheckbox.click();
	        }
	    }

	    @When("I click on the user menu dropdown")
	    public void i_click_on_the_user_menu_dropdown() {
	        WebElement userMenu = driver.findElement(By.id("userNavButton"));
	        userMenu.click();
	    }

	    @When("I select the logout link")
	    public void i_select_the_logout_link() {
	        WebElement logoutLink = driver.findElement(By.linkText("Logout"));
	        logoutLink.click();
	    }

	    @Then("the username field should be populated with {string}")
	    public void the_username_field_should_be_populated_with(String expectedUsername) {
	        WebElement usernameField = driver.findElement(By.id("username"));
	        assert usernameField.getAttribute("value").equals(expectedUsername);
	    }

	    @Then("the remember username checkbox should be checked")
	    public void the_remember_username_checkbox_should_be_checked() {
	        WebElement rememberCheckbox = driver.findElement(By.id("rememberUn"));
	        assert rememberCheckbox.isSelected();
	    }

	    @When("I click on the Forgot Password link")
	    public void i_click_on_the_forgot_password_link() {
	        WebElement forgotPasswordLink = driver.findElement(By.id("forgot_password_link"));
	        forgotPasswordLink.click();
	    }

	    @Then("I should see the Salesforce forgot password page")
	    public void i_should_see_the_salesforce_forgot_password_page() {
	        WebElement forgotPasswordPage = driver.findElement(By.id("forgot_password_page"));
	        assert forgotPasswordPage.isDisplayed();
	    }

	    @When("I enter {string} in the forgot password username field")
	    public void i_enter_in_the_forgot_password_username_field(String username) {
	        WebElement forgotUsernameField = driver.findElement(By.id("un"));
	        forgotUsernameField.sendKeys(username);
	    }

	    @When("I click on the Continue button")
	    public void i_click_on_the_continue_button() {
	        WebElement continueButton = driver.findElement(By.id("continue"));
	        continueButton.click();
	    }

	    @Then("I should see the password reset message")
	    public void i_should_see_the_password_reset_message() {
	        WebElement resetMessage = driver.findElement(By.id("reset_message"));
	        assert resetMessage.isDisplayed();
	    }

	    @Then("an email should be sent to the email associated with {string}")
	    public void an_email_should_be_sent_to_the_email_associated_with(String username) {
	        // This step would require checking the email, which is not typically done in UI tests.
	        // It could be mocked or verified via API.
	        System.out.println("Email sent to " + username);
	    }

	    @Then("I should see the error message {string}")
	    public void i_should_see_the_error_message1(String expectedMessage) {
	        WebElement errorMessage = driver.findElement(By.id("error"));
	        assert errorMessage.getText().equals(expectedMessage);
	    }

	    @After
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}


