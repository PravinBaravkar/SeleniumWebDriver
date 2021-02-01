package com.test.exercises.pageobjectmodel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;

	By uname = By.id("user_login");
	By pwd = By.name("pwd");
	By loginButton = By.xpath("//input[@id='wp-submit']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void verifyLogin(String username, String password) {
		driver.findElement(uname).sendKeys(username);
		driver.findElement(pwd).sendKeys(password);
		driver.findElement(loginButton).click();
	}

	public void typeUserName() {
		driver.findElement(uname).sendKeys("admin");
	}

	public void typePassword() {
		driver.findElement(pwd).sendKeys("demo123");
	}

	public void clickLoginButton() {
		driver.findElement(loginButton).click();
	}
}
