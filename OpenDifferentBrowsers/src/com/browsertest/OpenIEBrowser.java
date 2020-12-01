package com.browsertest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class OpenIEBrowser {

	public static void main(String[] args) {

		// 32 bit IE Driver
		System.setProperty("webdriver.ie.driver",
				"C:\\dev tools\\BrowserDrivers\\IEDriverServer_Win32_3.10.0\\IEDriverServer.exe");

		// 64 bit IE Driver
		/*
		 * System.setProperty("webdriver.ie.driver",
		 * "C:\\dev tools\\BrowserDrivers\\IEDriverServer_x64_3.10.0\\IEDriverServer.exe"
		 * );
		 * 
		 */
		WebDriver driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");

		System.out.println("Web page title is: " + driver.getTitle());

		driver.quit();

	}

}
