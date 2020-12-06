package com.test.exercises.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicLocatorMethods {

	public static void main(String args[]) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./../resources/drivers/chromedriver_win32/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");

		// 1-id
		WebElement username = driver.findElement(By.id("email"));
		username.sendKeys("Email Id");

		Thread.sleep(3000);

		// 2-name
		WebElement password = driver.findElement(By.name("pass"));
		password.sendKeys("My Password");

		Thread.sleep(3000);

		// 3-className
		WebElement txt = driver.findElement(By.className("_8eso"));
		System.out.println("Text is: " + txt.getText());

		// 4-xpath
		WebElement loginBtn = driver.findElement(By.xpath("//button[@name='login']"));
		System.out.println("Inner text is: " + loginBtn.getAttribute("innerHTML"));

		// 5-css
		WebElement createAccount = driver.findElement(By.cssSelector("#u_0_2"));
		System.out.println("Inner text is: " + createAccount.getText());

		// 6-linkText
		WebElement createPage = driver.findElement(By.linkText("Create a Page"));
		System.out.println("Link text is: " + createPage.getText());

		// 7-partialLinkText
		WebElement forgotPwdLink = driver.findElement(By.partialLinkText("Forgotten password"));
		System.out.println("Link text for partialLinkText is: " + forgotPwdLink.getAttribute("innerHTML"));

		// 8-tagName
		WebElement txt_1 = driver.findElement(By.tagName("h2"));
		System.out.println("Text is: " + txt_1.getAttribute("innerHTML"));

		driver.quit();
	}
}
