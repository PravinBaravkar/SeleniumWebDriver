package com.test.exercises.actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardEvents {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./../resources/drivers/chromedriver_win32/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.facebook.com");

		Actions act = new Actions(driver);

		act.sendKeys(Keys.ENTER).perform();

		driver.findElement(By.name("email")).sendKeys("pravin");

		act.pause(Duration.ofSeconds(3)).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys("password")
				.pause(Duration.ofSeconds(1)).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE)
				.pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys(Keys.ENTER)
				.build().perform();

	}

}
