package com.thedemosite.testcases;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.thedemosite.pages.AddUserPage;
import com.thedemosite.pages.LoginPage;
/*
 * This test case verifying user login on the test demo site.
 * The test demo site has a single record at the time, so
 * the test cases retrieves this single record and then verify
 * that login with this single record is working correctly.
 */
public class VerifyTheDemoSiteLogin {

	@Test
	public void verifyValidLogin() {
		
		//configure and engage WebDriver
		System.setProperty("webdriver.gecko.driver","//Users//hanschehaiber//geckodriver");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://thedemosite.co.uk/index.php"); //go to Website using the URL
		
		//Go to Add User Page to retrieve the current single record on test web site. 
		AddUserPage addUserPage = new AddUserPage(driver);
		addUserPage.goToAddUserPage();
		String username = addUserPage.getLastEnteredUsername();
		String password = addUserPage.getLastEnteredPassword();
		LoginPage loginPage = new LoginPage(driver);
		
		//Go to Login Page with recently acquired username and password and verify login
		loginPage.goToLoginPage();
		loginPage.typeUserName(username);
		loginPage.typerPassword(password);
		loginPage.clickTestLoginButton();
		
		//Check to make sure the login was successful
		try {
			assertTrue(loginPage.checkLoginAttempt());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			//close the browser at conclusion of test
			driver.quit();
		}
		
		
	}
	
	
	
}
