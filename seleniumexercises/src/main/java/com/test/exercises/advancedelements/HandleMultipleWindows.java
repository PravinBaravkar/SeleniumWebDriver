package com.test.exercises.advancedelements;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleMultipleWindows {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./../resources/drivers/chromedriver_win32/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://seleniumpractise.blogspot.com/2017/07/multiple-window-examples.html");

		String parentWindowHandle = driver.getWindowHandle();

		System.out.println("Parent window handle id is: " + parentWindowHandle);

		driver.findElement(By.xpath("//a[contains(@href,'www.google.com')]")).click();

		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println("Title : " + driver.getTitle());

		for (String window : windowHandles) {

			if (!parentWindowHandle.equals(window)) {

				driver.switchTo().window(window);
				System.out.println("Title : " + driver.getTitle());

				driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Selenium Tutorials");

				Thread.sleep(3000);

				driver.close();
			}
		}
		driver.switchTo().window(parentWindowHandle);
		System.out.println("Title : " + driver.getTitle());

		driver.findElement(By.xpath("//a[contains(@href,'www.google.com')]")).click();
		driver.findElement(By.xpath("//a[contains(@href,'www.facebook.com')]")).click();
		driver.findElement(By.xpath("//a[contains(@href,'www.yahoo.com')]")).click();

		windowHandles = driver.getWindowHandles();
		System.out.println("Size is:" + windowHandles.size());
		ArrayList<String> windowHandlesList = new ArrayList<String>(windowHandles);
		System.out.println("Window handle list is: " + windowHandlesList.toString());

		driver.switchTo().window(windowHandlesList.get(1));
		System.out.println("Title is:" + driver.getTitle());
		driver.close();

		driver.switchTo().window(windowHandlesList.get(2));
		System.out.println("Title is:" + driver.getTitle());
		driver.close();

		driver.switchTo().window(windowHandlesList.get(3));
		System.out.println("Title is:" + driver.getTitle());
		driver.close();

		driver.switchTo().window(windowHandlesList.get(0));
		System.out.println("Title : " + driver.getTitle());

		driver.quit();

	}

}
