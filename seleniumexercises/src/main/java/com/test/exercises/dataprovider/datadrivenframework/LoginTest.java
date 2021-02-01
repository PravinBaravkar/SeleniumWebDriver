package com.test.exercises.dataprovider.datadrivenframework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.exercises.excelreadwrite.ReadExcel;

public class LoginTest {

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

		Object[][] loginData = new Object[][] {};

		loginData = ReadExcel.getData();

		return loginData;
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
