package com.test.exercises.advancedelements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleRadioAndCheckboxButtons {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./../resources/drivers/chromedriver_win32/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-automate-radio-button-in.html");

		List<WebElement> radioList = driver.findElements(By.xpath("//input[@type='radio' and @name='lang']"));

		for (WebElement radioBtn : radioList) {

			String value = radioBtn.getAttribute("value");
			System.out.println("Radio buttons are:" + value);

			if (value.equalsIgnoreCase("PYTHON")) {
				radioBtn.click();
				Thread.sleep(1000);
			}
		}

		List<WebElement> checkboxList = driver.findElements(By.xpath("//input[@type='checkbox']"));

		for (WebElement checkboxBtn : checkboxList) {

			String id = checkboxBtn.getAttribute("id");
			System.out.println("Checkbox buttons are:" + id);

			if (id.equalsIgnoreCase("code")) {
				checkboxBtn.click();
				Thread.sleep(1000);
			}
		}

		driver.quit();
	}

}
