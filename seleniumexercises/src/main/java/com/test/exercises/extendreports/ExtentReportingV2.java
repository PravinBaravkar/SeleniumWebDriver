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
/*
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
*/
public class ExtentReportingV2 {
/*
	ExtentReports report;
	ExtentTest logger;
	WebDriver driver;

	@BeforeClass
	public void setUp() {

		report = new ExtentReports("../resources/reports/extentreports_v2.html", true);

		logger = report.startTest("Verify page title");

		System.setProperty("webdriver.chrome.driver", "../resources/drivers/chromedriver_win32/chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		logger.log(LogStatus.INFO, "Browser opened...");
	}

	@Test
	public void verifyTitle() throws Exception {

		driver.get("https://www.google.co.in");

		logger.log(LogStatus.INFO, "Application Loaded...");

		Assert.assertTrue(driver.getTitle().contains("Google"), "Error : Title does not match..");

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(src, new File("../resources/reports/screenshots/screen2.png"));

		String img = logger.addScreenCapture("./screenshots/screen2.png");

		logger.log(LogStatus.PASS, "Title verified...", img);
	}

	@AfterClass
	public void tearDown() {

		report.endTest(logger);
		report.flush();

		driver.quit();
	} */
}
