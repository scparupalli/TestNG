package com.maven.testNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class DataProviderLoginTest {

    @Test(dataProvider = "userCredentialsProvider")
    public void loginTest(String username, String password) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://tekarch-7b-dev-ed.develop.my.salesforce.com");
        WebElement userField = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        userField.sendKeys(username);
        WebElement passField = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        passField.sendKeys(password);
        System.out.println("Logging in with Username: " + username + " and Password: " + password);
        WebElement login = driver.findElement(By.xpath("//*[@id=\"Login\"]"));
        login.click();
        boolean isLoggedIn = driver.getCurrentUrl().contains("home.jsp");
        if (isLoggedIn) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed!");
        }

        
        driver.quit();
    }

    @DataProvider(name = "userCredentialsProvider")
    public Object[][] userCredentialsProvider() {
        String filePath = "user_credentials.xlsx";
        List<Object[]> credentialsList = XlsxUtility.readUserCredentials(filePath);
        return credentialsList.toArray(new Object[0][]);
    }
}
