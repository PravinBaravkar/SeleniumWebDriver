package com.test.exercises.advancedelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyErrorMessages {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./../resources/drivers/chromedriver_win32/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://gmail.com");

		WebElement nextButton = driver.findElement(By.xpath("//*[text()='Next']//ancestor::button"));
		//WebElement nextButton = driver.findElement(By.xpath("//span[contains(text(),'Next')]"));
		nextButton.click();

		// JavascriptExecutor executor = (JavascriptExecutor)driver;
		// executor.executeScript("arguments[0].click()", nextButton);

		String expectedErrorMessage = "Enter an email or phone number";

		String actualErrorMessage = driver
				.findElement(By.xpath(
						"//input[@type='email']//following::div/*[contains(text(),'Enter an email or phone number')]"))
				.getText();

		System.out.println("Actual error messsage for getText is: " + actualErrorMessage);

		System.out.println(actualErrorMessage.equals(expectedErrorMessage) ? "Error mesage as expected"
				: "Error message is NOT as expected");
		
		driver.quit();

	}

}
