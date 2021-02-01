package com.test.exercises.advancedelements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeOptionsDesiredCapabilities {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./../resources/drivers/chromedriver_win32/chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		// options.addArguments("disable-infobars");

		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setAcceptInsecureCerts(true);
		// capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		// options.setAcceptInsecureCerts(true);

		options.merge(capabilities);

		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.get("https://www.cacert.org");

		Thread.sleep(2000);

		driver.quit();

	}
}
