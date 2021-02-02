package com.masteringselenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.masteringselenium.browserconfig.DriverFactory;

public class BasicTestDemo extends DriverFactory {

	private void searchInGoogle(final String searchString) throws Exception {

		WebDriver driver = DriverFactory.getDriver();
		driver.get("https://www.google.co.in");
		WebElement searchField = driver.findElement(By.name("q"));
		searchField.clear();
		searchField.sendKeys(searchString);

		System.out.println("Page title is : " + driver.getTitle());

		searchField.submit();

		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driverObject) {
				return driverObject.getTitle().toLowerCase().startsWith(searchString.toLowerCase());
			}
		});

		System.out.println("Page title is : " + driver.getTitle());

	}

	@Test
	public void googleSearchSeleniumExample() throws Exception {
		searchInGoogle("Selenium");
	}

	@Test
	public void googleSearchTestNGExample() throws Exception {
		searchInGoogle("TestNG");
	}

	@Test
	public void googleSearchWebDriverExample() throws Exception {
		searchInGoogle("WebDriver");
	}

	@Test
	public void googleSearchMavenExample() throws Exception {
		searchInGoogle("Maven");
	}

	@Test
	public void googleSearchJenkinsExample() throws Exception {
		searchInGoogle("Jenkins");
	}

	@Test
	public void googleSearchAntExample() throws Exception {
		searchInGoogle("Ant");
	}
}
