package com.test.mavendemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MavenTest {

	@Test
	public void test() {
		
		System.out.println("Welcome!");
		
		System.setProperty("webdriver.chrome.driver", "./../resources/drivers/chromedriver_win32/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		
		driver.get("http://www.facebook.com");
		
		System.out.println(driver.getTitle());
		
		driver.quit();
	}
}
