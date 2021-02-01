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
import com.relevantcodes.extentreports.LogStatus;
*/
public class ExtentReportingV1 {
/*
	ExtentReports report;
	WebDriver driver;

	@BeforeClass
	public void setUp() {

		report = ExtentReports.get(ExtentReportingV1.class);

		report.init("../resources/reports/extentreports_v1.html", true);

		report.startTest("Verify page title");

		System.setProperty("webdriver.chrome.driver", "../resources/drivers/chromedriver_win32/chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		report.log(LogStatus.INFO, "Browser opened...");

	}

	@Test
	public void verifyTitle() throws Exception {

		driver.get("https://www.google.co.in");

		report.log(LogStatus.INFO, "Application Loaded...");

		Assert.assertTrue(driver.getTitle().contains("Google"), "Error : Title does not match..");

		report.log(LogStatus.PASS, "Title verified...");

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(src, new File("../resources/reports/screenshots/screen1.png"));

		report.attachScreenshot("./screenshots/screen1.png");

	}

	@AfterClass
	public void tearDown() {

		report.endTest();

		driver.quit();
	} */
}
