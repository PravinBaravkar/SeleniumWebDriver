package com.test.exercises.timeouts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlePageLoadAndScriptTimeouts {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./../resources/drivers/chromedriver_win32/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(4, TimeUnit.SECONDS);

		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);

		driver.get("http://www.google.com");

	}

}
