package com.test.exercises.advancedelements;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleDropdown {

	public static void main(String[] args) throws InterruptedException {

		List<String> actual_monthslist = new ArrayList<String>();
		List<String> expected_monthslist = new ArrayList<String>();
		expected_monthslist.add("Month");
		expected_monthslist.add("Jan");
		expected_monthslist.add("Feb");
		expected_monthslist.add("Mar");
		expected_monthslist.add("Apr");
		expected_monthslist.add("May");
		expected_monthslist.add("Jun");
		expected_monthslist.add("Jul");
		expected_monthslist.add("Aug");
		expected_monthslist.add("Sep");
		expected_monthslist.add("Oct");
		expected_monthslist.add("Nov");
		expected_monthslist.add("Dec");

		System.setProperty("webdriver.chrome.driver", "./../resources/drivers/chromedriver_win32/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");

		driver.findElement(By.xpath("//*[@role='button' and contains(text(), 'Create New Account')]")).click();
		Thread.sleep(4000);

		WebElement monthElement = driver.findElement(By.xpath("//select[@id='month']"));

		Select month = new Select(monthElement);

		int month_size = month.getOptions().size();

		System.out.println("Month list size is: " + month_size);

		System.out.println("Default Selected value is: " + month.getFirstSelectedOption().getText());

		for (int i = 0; i <= month_size - 1; i++) {
			month.selectByIndex(i);
			actual_monthslist.add(month.getFirstSelectedOption().getText());
			System.out.println("Index " + i + " and Selected value is: " + month.getFirstSelectedOption().getText());
			Thread.sleep(1000);
		}

		System.out.println("Expected list: " + expected_monthslist);
		System.out.println("Actual list: " + actual_monthslist);
		System.out.println(actual_monthslist.equals(expected_monthslist) ? "Actual and Expected month list are equal"
				: "Actual and Expected month list are not equal");

		month.selectByValue("10");
		System.out.println("Selected value selectByValue is: " + month.getFirstSelectedOption().getText());

		Thread.sleep(1000);

		month.selectByVisibleText("Mar");
		System.out.println("Selected value selectByVisibleText is: " + month.getFirstSelectedOption().getText());

		driver.quit();
	}

}
