package com.test.exercises.javascriptexecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollPage {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./../resources/drivers/chromedriver_win32/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.learn-automation.com");

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		Thread.sleep(3000);

		jse.executeScript("scroll(0,500)"); // scroll vertically downwards

		Thread.sleep(3000);

		jse.executeScript("scroll(0,-500)"); // scroll vertically upwards

		Thread.sleep(2000);

		driver.quit();
	}

}
