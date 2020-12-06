package com.test.exercises.advancedelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFrames {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./../resources/drivers/chromedriver_win32/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("D:\\Pravin\\workspace\\SeleniumWebDriver\\seleniumexercises\\myframes.html");
		
		driver.switchTo().frame("blog");
		
		Thread.sleep(10000);
				
		if (driver.findElement(By.xpath("//a[text()='✕']")).isDisplayed()) {
			driver.findElement(By.xpath("//a[text()='✕']")).click();
		}
		
		driver.findElement(By.xpath("//button[contains(text(),'Menu')]")).click();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(0);
		
		Thread.sleep(10000);
		
		if (driver.findElement(By.xpath("//a[text()='✕']")).isDisplayed()) {
			driver.findElement(By.xpath("//a[text()='✕']")).click();
		}
		
		driver.findElement(By.xpath("//button[contains(text(),'Menu')]")).click();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='selenium_site']")));
		
		driver.findElement(By.xpath("//a[contains(text(),'MENU')]")).click();
		
		Thread.sleep(3000);
		
		driver.switchTo().defaultContent();
		
		driver.findElement(By.partialLinkText("Click Here")).click();
		
		driver.quit();
	}

}
