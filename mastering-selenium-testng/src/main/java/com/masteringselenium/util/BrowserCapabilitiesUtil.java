package com.masteringselenium.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserCapabilitiesUtil {

	public DesiredCapabilities setWebDriverCapabilities(String browser) throws IOException {
		DesiredCapabilities capabilities;
		switch (browser) {
		case "FIREFOX":
			capabilities = DesiredCapabilities.firefox();
			break;
		case "CHROME":
			capabilities = DesiredCapabilities.chrome();
			break;
		case "INTERNETEXPLORER":
			capabilities = DesiredCapabilities.internetExplorer();
			break;
		case "SAFARI":
			capabilities = DesiredCapabilities.safari();
			break;
		case "OPERA":
			capabilities = DesiredCapabilities.operaBlink();
			break;
		case "MICROSOFTEDGE":
			capabilities = DesiredCapabilities.edge();
			break;

		default:
			capabilities = null;
		}

		Properties prop = new Properties();
		String fileSeparator = File.separator;
		try {
			prop.load(new FileInputStream("." + fileSeparator + "resources" + fileSeparator + browser + ".capabilities"));
		} catch (FileNotFoundException exception) {
			System.out.println("File at location: ." + fileSeparator + "resources" + fileSeparator + browser + ".capabilities is not present... Hence opening browser with default capabilities...");
		}
		Set<Object> keys = prop.keySet();
		for (Object k : keys) {
			String key = (String) k;
			capabilities.setCapability(key, prop.getProperty(key));
			System.out.println("Browser capabilities are : " + key + "=" + prop.getProperty(key));
		}
		return capabilities;
	}
}
