package com.test.exercises.javascriptexecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExecuteJavascript {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./../resources/drivers/chromedriver_win32/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.google.co.in");

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("alert('Welcome!!')");

		Thread.sleep(2000);

		driver.quit();
	}

}
