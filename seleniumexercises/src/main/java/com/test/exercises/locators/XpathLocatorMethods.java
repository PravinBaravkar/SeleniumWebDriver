package com.test.exercises.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathLocatorMethods {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./../resources/drivers/chromedriver_win32/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demosite.center/wordpress/wp-login.php");

		// single attribute //tagname[@attribute='value']
		driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys("admin123");
		Thread.sleep(2000);

		// multiple attributes //tagname[@attribute1='value'][@attribute2='value']...
		driver.findElement(By.xpath("//input[@class='input'][@type='password']")).clear();
		Thread.sleep(2000);

		// and //tagname[@attribute1='value' and @attribute2='value']
		driver.findElement(By.xpath("//input[@class='input' and @type='password']")).sendKeys("demo123");

		// or //tagname[@attribute1='value' or @attribute2='value']
		driver.findElement(By.xpath("//input[@class='input' or @name='log']"));
		Thread.sleep(2000);

		// contains() method //tagname[contains(@attribute,'text')]
		driver.findElement(By.xpath("//input[contains(@value, 'Log In')]")).click();
		Thread.sleep(2000);

		// text() method //tagname[text()='TextOnPage')]
		driver.findElement(By.xpath("//*[text()='Posts']"));
		driver.findElement(By.xpath("//a[contains(text(), 'Post')]"));
		Thread.sleep(2000);

		// starts-with() method //tagname[starts-with(@attribute, 'txt')]
		driver.findElement(By.xpath("//input[starts-with(@name, 'post')]"));
		driver.findElement(By.xpath("//a[starts-with(text(),'Customise')]"));
		Thread.sleep(2000);

		// following method //pathToElement//following::elementToFind
		System.out.println(driver.findElements(By.xpath("//div[text()='Dashboard']//following::a")).size());
		driver.findElement(By.xpath("//div[text()='Dashboard']//following::a[1]"));
		Thread.sleep(2000);

		// preceding method //pathToElement//preceding::elementToFind
		driver.findElement(By.xpath("//input[@name='save']//preceding::input[@name='post_title']"));
		Thread.sleep(2000);

		// ancestor method //pathToElement//ancestor::elementToFind
		driver.findElement(By.xpath("//div[@class='wp-menu-name' and text()='Users']//ancestor::a"));
		Thread.sleep(2000);

		// combination of relative path and absolute path
		driver.findElement(By.xpath("//div[@class='welcome-panel-column'][1]/a"));
		Thread.sleep(2000);

		driver.quit();

	}

}
