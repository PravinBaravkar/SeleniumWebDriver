package com.test.exercises.javascriptexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SendKeysAndClick {

	public static void main(String args[]) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./../resources/drivers/chromedriver_win32/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.google.co.in");

		WebElement search = driver.findElement(By.name("q"));
		WebElement gmail = driver.findElement(By.linkText("Gmail"));

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		// jse.executeScript("arguments[0].value='Selenium'", search);

		jse.executeScript("arguments[0].value=arguments[1]", search, "Selenium tutorials");

		Thread.sleep(2000);

		jse.executeScript("arguments[0].click()", gmail);

		Thread.sleep(2000);

		driver.quit();
	}
}
