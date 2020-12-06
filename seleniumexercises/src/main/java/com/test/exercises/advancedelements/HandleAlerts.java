package com.test.exercises.advancedelements;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlerts {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./../resources/drivers/chromedriver_win32/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ksrtc.in");
		
		driver.findElement(By.xpath("//button[contains(text(),'Search for Bus')]")).click();

		Alert alertPopUp = driver.switchTo().alert();
		
		System.out.println("Alert message is: " + alertPopUp.getText());
		
		alertPopUp.accept();
		//alertPopUp.sendKeys("enter data");
		//alertPopUp.dismiss();
		
		driver.quit();
	}

}
