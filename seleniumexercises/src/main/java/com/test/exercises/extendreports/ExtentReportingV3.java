package com.test.exercises.extendreports;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportingV3 {

	ExtentHtmlReporter reporter;
	ExtentReports report;
	ExtentTest logger;
	WebDriver driver;

	@BeforeClass
	public void setUp() {

		reporter = new ExtentHtmlReporter("../resources/reports/extentreports_v3.html");

		report = new ExtentReports();

		report.attachReporter(reporter);

		logger = report.createTest("Verify page title");

		System.setProperty("webdriver.chrome.driver", "../resources/drivers/chromedriver_win32/chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		logger.log(Status.INFO, "Browser opened...");
	}

	@Test
	public void verifyTitle() throws Exception {

		driver.get("https://www.google.co.in");

		logger.log(Status.INFO, "Application Loaded...");

		Assert.assertTrue(driver.getTitle().contains("Google"), "Error : Title does not match..");

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(src, new File("../resources/reports/screenshots/screen3.png"));

		// Method 1
		// logger.addScreenCaptureFromPath("./screenshots/screen3.png", "Screenshot");

		// Method 2
		logger.pass("Test passed", MediaEntityBuilder.createScreenCaptureFromPath("./screenshots/screen3.png").build());

		logger.log(Status.PASS, "Title verified...");
	}

	@AfterClass
	public void tearDown() {

		report.flush();

		driver.quit();
	}
}
