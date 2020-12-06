package com.test.exercises.actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./../resources/drivers/chromedriver_win32/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		// first example
		// driver.get("https://docs.dhtmlx.com/suite/samples/tree/02_configuration/05_drag_modes.html");

		// second example
		driver.navigate().to("https://jqueryui.com/droppable/");

		new DragAndDrop().individualActions(driver);

		new DragAndDrop().inBuiltMethod(driver);

		new DragAndDrop().dragByCoordinates(driver);

		driver.quit();

	}

	public void individualActions(WebDriver driver) throws InterruptedException {

		// elements for first example
		// WebElement src = driver.findElement(By.xpath("(//span[text()='Lawrence
		// Block'])[1]"));
		// WebElement dest =
		// driver.findElement(By.xpath("(//span[text()='Magazines'])[3]"));

		// elements for second example
		driver.switchTo().frame(0);
		WebElement src = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement dest = driver.findElement(By.xpath("//div[@id='droppable']"));

		Actions act = new Actions(driver);

		act.clickAndHold(src).pause(Duration.ofSeconds(2)).moveToElement(dest).pause(Duration.ofSeconds(2)).release()
				.pause(Duration.ofSeconds(2)).build().perform();

		Thread.sleep(2000);

	}

	public void inBuiltMethod(WebDriver driver) throws InterruptedException {

		driver.navigate().refresh();

		Thread.sleep(4000);

		// elements for first example
		// WebElement src = driver.findElement(By.xpath("(//span[text()='Lawrence
		// Block'])[1]"));
		// WebElement dest =
		// driver.findElement(By.xpath("(//span[text()='Magazines'])[3]"));

		// elements for second example
		driver.switchTo().frame(0);
		WebElement src = driver.findElement(By.xpath("//p[text()='Drag me to my target']"));
		WebElement dest = driver.findElement(By.xpath("//p[text()='Drop here']"));

		Actions act = new Actions(driver);

		act.dragAndDrop(src, dest).perform();

		Thread.sleep(2000);

	}

	public void dragByCoordinates(WebDriver driver) throws InterruptedException {

		driver.navigate().to("https://jqueryui.com/draggable/");

		driver.switchTo().frame(0);
		WebElement src = driver.findElement(By.xpath("//div[@id='draggable']"));
		Actions act = new Actions(driver);

		Thread.sleep(3000);

		// scroll manually a little bit to avoid move out of bounds exception
		act.dragAndDropBy(src, 200, 70).perform();

		Thread.sleep(2000);

	}
}
