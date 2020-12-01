package com.browsertest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class OpenMicrosoftEdgeBrowser {

	public static void main(String[] args) {

		System.setProperty("webdriver.edge.driver",
				"./resources/drivers/edgedriver_win64/msedgedriver.exe");

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.facebook.com");

		System.out.println("Web page title is: " + driver.getTitle());

		driver.quit();

	}

}
