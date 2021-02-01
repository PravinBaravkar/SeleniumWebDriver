package com.test.exercises.actions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickAndDoubleClick {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./../resources/drivers/chromedriver_win32/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		new RightClickAndDoubleClick().rightClick(driver);

		new RightClickAndDoubleClick().doubleClick(driver);

		driver.quit();

	}

	public void rightClick(WebDriver driver) throws InterruptedException {

		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

		Actions act = new Actions(driver);

		act.contextClick(driver.findElement(By.xpath("//span[text()='right click me']"))).perform();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[text()='Copy']")).click();

		Thread.sleep(1000);

		Alert alertPopUp = driver.switchTo().alert();

		System.out.println("Alert message is: " + alertPopUp.getText());

		alertPopUp.accept();

	}

	public void doubleClick(WebDriver driver) throws InterruptedException {

		driver.navigate().to("http://api.jquery.com/dblclick/");

		Actions act = new Actions(driver);

		driver.switchTo().frame(driver.findElement(By.xpath("//iframe")));

		Thread.sleep(2000);

		act.doubleClick(driver.findElement(By.xpath("//span[text()='Double click the block']//preceding::div")))
				.perform();

		Thread.sleep(2000);

	}
}
