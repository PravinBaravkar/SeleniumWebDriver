package com.test.exercises.demo;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindBrokenLink {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./../resources/drivers/chromedriver_win32/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.google.co.in");

		List<WebElement> linksList = driver.findElements(By.tagName("a"));

		System.out.println("Total links on page are : " + linksList.size());

		for (WebElement link : linksList) {
			String url = link.getAttribute("href");

			verifyIfLinkBroken(url);
		}

		driver.quit();
	}

	public static void verifyIfLinkBroken(String linkUrl) {

		try {
			URL url = new URL(linkUrl);

			HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
			httpConn.setConnectTimeout(3000);
			httpConn.connect();

			if (httpConn.getResponseCode() == 200) {
				System.out.println(linkUrl + " - " + httpConn.getResponseMessage());
			}

			if (httpConn.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
				System.out.println(
						linkUrl + " - " + httpConn.getResponseMessage() + " - " + HttpURLConnection.HTTP_NOT_FOUND);
			}
		} catch (Exception e) {
			System.out.println("Exception : " + e.getStackTrace());
		}

	}

}
