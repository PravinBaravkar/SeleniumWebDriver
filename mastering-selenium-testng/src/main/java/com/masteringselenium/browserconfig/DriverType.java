package com.masteringselenium.browserconfig;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public enum DriverType implements DriverSetup {

	FIREFOX {
		public WebDriver getWebDriverObject(DesiredCapabilities capabilities) throws IOException {
			System.setProperty("webdriver.gecko.driver",
					"./../resources/drivers/geckodriver-v0.28.0-win64/geckodriver.exe");
			// DesiredCapabilities capabilities = new
			// BrowserCapabilitiesUtil().setWebDriverCapabilities(DriverType.FIREFOX.toString().toUpperCase());

			FirefoxOptions options = new FirefoxOptions();
			options.merge(capabilities);

			return new FirefoxDriver(options);
		}
	},
	CHROME {
		public WebDriver getWebDriverObject(DesiredCapabilities capabilities) throws IOException {
			System.setProperty("webdriver.chrome.driver","./../resources/drivers/chromedriver_win32/chromedriver.exe");
			// DesiredCapabilities capabilities = new
			// BrowserCapabilitiesUtil().setWebDriverCapabilities(DriverType.CHROME.toString().toUpperCase());

			ChromeOptions options = new ChromeOptions();
			options.merge(capabilities);

			return new ChromeDriver(options);
		}
	},
	INTERNETEXPLORER {
		public WebDriver getWebDriverObject(DesiredCapabilities capabilities) throws IOException {
			System.setProperty("webdriver.ie.driver",
					"./../resources/drivers/IEDriverServer_Win32_3.10.0/IEDriverServer.exe");
			// DesiredCapabilities capabilities = new
			// BrowserCapabilitiesUtil().setWebDriverCapabilities(DriverType.IE.toString().toUpperCase());

			InternetExplorerOptions options = new InternetExplorerOptions();
			options.merge(capabilities);

			return new InternetExplorerDriver(options);
		}
	},
	SAFARI {
		public WebDriver getWebDriverObject(DesiredCapabilities capabilities) throws IOException {
			System.setProperty("webdriver.safari.driver", "./../resources/drivers/SafariDriver/safaridriver.exe");
			// DesiredCapabilities capabilities = new
			// BrowserCapabilitiesUtil().setWebDriverCapabilities(DriverType.SAFARI.toString().toUpperCase());

			SafariOptions options = new SafariOptions();
			options.merge(capabilities);

			return new SafariDriver(options);
		}
	},
	OPERA {
		public WebDriver getWebDriverObject(DesiredCapabilities capabilities) throws IOException {
			System.setProperty("webdriver.opera.driver", "./../resources/drivers/OperaDriver/operadriver.exe");
			// DesiredCapabilities capabilities = new
			// BrowserCapabilitiesUtil().setWebDriverCapabilities(DriverType.OPERA.toString().toUpperCase());

			OperaOptions options = new OperaOptions();
			options.merge(capabilities);

			return new OperaDriver(options);
		}
	},
	MICROSOFTEDGE {
		public WebDriver getWebDriverObject(DesiredCapabilities capabilities) throws IOException {
			System.setProperty("webdriver.edge.driver", "./../resources/drivers/edgedriver_win64/msedgedriver.exe");
			// DesiredCapabilities capabilities = new
			// BrowserCapabilitiesUtil().setWebDriverCapabilities(DriverType.MICROSOFTEDGE.toString().toUpperCase());

			EdgeOptions options = new EdgeOptions();
			options.merge(capabilities);

			return new EdgeDriver(options);
		}
	};
}
