package com.browsertest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenFirefoxBrowser {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver",
				"./resources/drivers/geckodriver-v0.28.0-win64/geckodriver.exe");

		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.facebook.com");

		System.out.println("Web page title is: " + driver.getTitle());

		driver.quit();

	}

}
