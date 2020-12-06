package com.browsertest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenChromeBrowser {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"./../resources/drivers/chromedriver_win32/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.facebook.com");

		System.out.println("Web page title is: " + driver.getTitle());

		driver.quit();

	}

}
