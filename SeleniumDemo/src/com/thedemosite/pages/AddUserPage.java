package com.thedemosite.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.thedemosite.utility.Tokenizer;
/*
 * This class is the Add User Page and governs the way
 * in which test cases interact with the Add User Page
 */
public class AddUserPage {
	WebDriver driver;
	//locators
	By usernamePassword = By.xpath("/html/body/table/tbody/tr/td[1]/blockquote/blockquote[2]/blockquote");
	By addAUser = By.linkText("3. Add a User");

	Tokenizer tokens = new Tokenizer();
	
	public AddUserPage(WebDriver driver) {
		this.driver=driver;
	}
	public void goToAddUserPage() {
		driver.findElement(addAUser).click();
	}
	public String getLastEnteredUsername() {
		String str = driver.findElement(usernamePassword).getText();
		List<String> strList = tokens.tokenizeString(str);
		String username = strList.get(2); //get username
		return username;
	}
	public String getLastEnteredPassword() {
		String str = driver.findElement(usernamePassword).getText();
		List<String> strList = tokens.tokenizeString(str);
		String password = strList.get(5); //get password
		return password;
	}
}
