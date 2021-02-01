package com.masteringselenium.browserconfig;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public interface DriverSetup {

	WebDriver getWebDriverObject(DesiredCapabilities capabilities) throws IOException;
}
