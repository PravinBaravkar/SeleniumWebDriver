package com.test.exercises.dataprovider.datadrivenframework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTestExcel {

	WebDriver driver;

	@Test(dataProvider = "LoginDetails")
	public void verifyLogin(String username, String password) {

		System.setProperty("webdriver.chrome.driver", "./../resources/drivers/chromedriver_win32/chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://demosite.center/wordpress/wp-login.php");

		By uname = By.id("user_login");
		By pwd = By.name("pwd");
		By loginButton = By.xpath("//input[@id='wp-submit']");

		driver.findElement(uname).sendKeys(username);
		driver.findElement(pwd).sendKeys(password);
		driver.findElement(loginButton).click();
		
		Assert.assertTrue(driver.getTitle().contains("Dashboard"), "Invalid credentials, try with valid credentials!");
	}

	@DataProvider(name = "LoginDetails")
	public Object[][] getLoginDetails() {

		Object[][] loginData = new Object[3][2];

		loginData[0][0] = "admin1";
		loginData[0][1] = "demo1";

		loginData[1][0] = "admin";
		loginData[1][1] = "demo123";

		loginData[2][0] = "admin1";
		loginData[2][1] = "demo13";

		return loginData;
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
