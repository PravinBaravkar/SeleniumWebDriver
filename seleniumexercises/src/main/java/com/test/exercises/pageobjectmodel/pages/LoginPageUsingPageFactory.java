package com.test.exercises.pageobjectmodel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPageUsingPageFactory {

	WebDriver driver;

	@FindBy(id = "user_login")
	@CacheLookup
	WebElement uname;

	@FindBy(how = How.NAME, using = "pwd")
	WebElement pwd;

	@FindBy(how = How.XPATH, using = "//input[@id='wp-submit']")
	WebElement loginButton;

	public LoginPageUsingPageFactory(WebDriver driver) {
		this.driver = driver;
	}

	public void verifyLogin(String username, String password) {
		uname.sendKeys(username);
		pwd.sendKeys(password);
		loginButton.click();
	}
}
