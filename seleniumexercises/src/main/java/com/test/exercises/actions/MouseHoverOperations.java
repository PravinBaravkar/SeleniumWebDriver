package com.test.exercises.actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverOperations {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./../resources/drivers/chromedriver_win32/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-perform-mouse-hover-in-selenium.html");

		WebElement btn = driver.findElement(By.xpath("//button[contains(text(),'Automation Tools')]"));

		Actions act = new Actions(driver);

		act.moveToElement(btn).perform();

		Thread.sleep(2000);

		List<WebElement> linkList = driver.findElements(By.xpath("//*[@class='dropdown-content']//a"));

		System.out.println("Size is: " + linkList.size());

		for (WebElement link : linkList) {

			System.out.println(link.getAttribute("innerHTML"));

			if (link.getAttribute("innerHTML").equals("Appium")) {
				link.click();
				System.out.println("Navigated to: " + driver.getTitle());
				break;
			}
		}

		driver.quit();
	}

}
