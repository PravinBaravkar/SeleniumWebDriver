package com.test.exercises.advancedelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleBootstrapModalPopUpWindow {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./../resources/drivers/chromedriver_win32/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://seleniumpractise.blogspot.com/2016/11/handle-bootstrap-model-dialog-in.html");

		driver.findElement(By.xpath("//button[text()='Click here to Login']")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[contains(text(),'This is a large modal.')]//following::input[@type='text']"))
				.sendKeys("Pravin");

		Thread.sleep(2000);

		driver.navigate().to("http://www.goibibo.com");

		driver.findElement(By.cssSelector("#get_sign_up")).click();

		Thread.sleep(3000);

		driver.switchTo().frame("authiframe");

		driver.findElement(By.cssSelector("#authMobile")).sendKeys("123456789");

		Thread.sleep(2000);

		driver.switchTo().defaultContent();

		driver.findElement(By.xpath("//a[contains(@class,'popClose')]")).click();

		driver.findElement(By.xpath("//button[text()='SEARCH']")).click();

		System.out.println("Please enter a valid Source".equals(
				driver.findElement(By.xpath("//span[text()='Please enter a valid Source']")).getText()) ? "SUCCESS"
						: "FAIL");

		driver.quit();

	}

}
