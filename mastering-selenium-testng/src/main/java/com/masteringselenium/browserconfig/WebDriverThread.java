package com.masteringselenium.browserconfig;

import static com.masteringselenium.browserconfig.DriverType.FIREFOX;
import static com.masteringselenium.browserconfig.DriverType.valueOf;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.masteringselenium.util.BrowserCapabilitiesUtil;

public class WebDriverThread {

	private WebDriver webdriver;
	private DriverType selectedDriverType;
	private DesiredCapabilities capabilities;

	private final DriverType defaultDriverType = FIREFOX;
	private final String operatingSystem = System.getProperty("os.name").toUpperCase();
	private final String systemArchitecture = System.getProperty("os.arch");
	// read below property values from maven configuration variables
	private final String browser = System.getProperty("browser");
	private final Boolean useRemoteGridServer = Boolean.parseBoolean(System.getProperty("useRemoteGridServer"));
	private final String seleniumGridServer = System.getProperty("seleniumGridServerUrl");
	private final String desiredTestPlatform = System.getProperty("desiredTestPlatform");
	private final String desiredBrowserVersion = System.getProperty("desiredBrowserVersion");

	public WebDriver getDriver() throws Exception {

		if (null == webdriver) {
			selectedDriverType = getDriverType();
			capabilities = new BrowserCapabilitiesUtil().setWebDriverCapabilities(selectedDriverType.toString().toUpperCase());
			instantiateWebDriver(capabilities);
		}
		return webdriver;
	}

	public void quitDriver() {

		if (null != webdriver) {
			webdriver.quit();
			webdriver = null;
		}
	}

	private DriverType getDriverType() {
		DriverType driverType = defaultDriverType;
		try {
			driverType = valueOf(browser.toUpperCase());
		} catch (IllegalArgumentException e) {
			System.out.println("Unknown driver specified, defaulting to '" + defaultDriverType + "'...");
		} catch (NullPointerException e) {
			System.out.println("No driver specified, defaulting to '" + defaultDriverType + "'...");
		}
		return driverType;
	}

	private void instantiateWebDriver(DesiredCapabilities capabilities) throws MalformedURLException, IOException {
		
		if (useRemoteGridServer) {
			URL seleniumGridUrl = new URL(seleniumGridServer);
			
			if (null != desiredTestPlatform && !desiredTestPlatform.isEmpty()) {
				capabilities.setPlatform(Platform.valueOf(desiredTestPlatform.toUpperCase()));
				System.out.println("Setting Platform " + Platform.valueOf(desiredTestPlatform.toUpperCase()));
			}

			if (null != desiredBrowserVersion && !desiredBrowserVersion.isEmpty()) {
				capabilities.setVersion(desiredBrowserVersion);
				System.out.println("Setting browser version " + desiredBrowserVersion);
			}
			
			webdriver = new RemoteWebDriver(seleniumGridUrl, capabilities);
			System.out.println("Here it goes...");
		} else {
			System.out.println("Current Operating System : " + operatingSystem);
			System.out.println("Current System Architecture : " + systemArchitecture);
			System.out.println("Current Browser Selection : " + selectedDriverType);
			
			webdriver = selectedDriverType.getWebDriverObject(capabilities);
		}
	}
}
