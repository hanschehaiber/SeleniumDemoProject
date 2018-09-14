package com.thedemosite.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/*
 * This class is the Login Page and governs the way
 * in which test cases interact with the Login Page
 */
public class LoginPage {
	WebDriver driver;
	//locators
	By loginButton = By.linkText("4. Login");
	By username = By.name("username");
	By password = By.name("password");
	By testLoginButton = By.xpath("//input[@value='Test Login']");
	By failedLoginAttempt = By.linkText("**Failed Login**");
	By successfulLoginAttempt = By.cssSelector(".auto-style1 > big:nth-child(6) > blockquote:nth-child(1) > blockquote:nth-child(1) > font:nth-child(1) > center:nth-child(1) > b:nth-child(1)");

	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	public void goToLoginPage() {
		driver.findElement(loginButton).click();
	}
	public void typeUserName(String username) {
		driver.findElement(this.username).sendKeys(username);
	}
	public void typerPassword(String password) {
		driver.findElement(this.password).sendKeys(password);
	}
	public void clickTestLoginButton() {
		driver.findElement(testLoginButton).click();
	}
	public boolean checkLoginAttempt() throws InterruptedException {
		return driver.findElements(successfulLoginAttempt).size() > 0;
	}
	
}
