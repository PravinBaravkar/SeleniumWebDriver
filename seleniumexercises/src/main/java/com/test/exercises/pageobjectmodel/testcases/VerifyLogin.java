package com.test.exercises.pageobjectmodel.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.test.exercises.pageobjectmodel.pages.LoginPage;

public class VerifyLogin {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./../resources/drivers/chromedriver_win32/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://demosite.center/wordpress/wp-login.php");

		LoginPage login = new LoginPage(driver);
		login.verifyLogin("admin", "demo123");

		driver.quit();
	}
}
