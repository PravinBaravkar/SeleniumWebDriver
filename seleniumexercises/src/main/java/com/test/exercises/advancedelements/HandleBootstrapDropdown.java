package com.test.exercises.advancedelements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleBootstrapDropdown {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./../resources/drivers/chromedriver_win32/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/bootstrap-dropdown-example-for-selenium.html");

		String pageSource = driver.getPageSource();
		String expectedTitle = "<title>Selenium Practise: Bootstrap Dropdown Example for Selenium</title>";
		System.out.println(pageSource.contains(expectedTitle) ? "Title matches with expected!!" : "Title mismatch");

		driver.findElement(By.xpath("//button[@id='menu1']")).click();

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		// WebElement dropdownHTMLMenu =
		// driver.findElement(By.xpath("(//ul[@class='dropdown-menu']/li/a)[1]"));
		List<WebElement> dropdownMenu = driver.findElements(By.xpath("//ul[@class='dropdown-menu']/li/a"));

		for (WebElement menuItem : dropdownMenu) {

			String value = menuItem.getAttribute("innerHTML");
			System.out.println("Values from dropdown: " + value);
			if (value.equals("JavaScript")) {
				menuItem.click();
				break;
			}
		}

		driver.quit();
	}

}
