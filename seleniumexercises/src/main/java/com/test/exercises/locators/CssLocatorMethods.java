package com.test.exercises.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssLocatorMethods {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./../resources/drivers/chromedriver_win32/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demosite.center/wordpress/wp-login.php");

		// single attribute tagname[attribute='value']
		driver.findElement(By.cssSelector("input[id='user_login']")).sendKeys("Admin");
		driver.findElement(By.cssSelector("input[name='pwd']")).sendKeys("admin123");
		Thread.sleep(2000);

		// multiple attributes tagname[attribute1='value'][attribute2='value']...
		driver.findElement(By.cssSelector("input[class='input'][type='password']")).clear();
		Thread.sleep(2000);

		// id - tagname#id or just #id
		driver.findElement(By.cssSelector("#user_pass")).sendKeys("demo123");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#user_pass")).clear();

		// classname- tagname.classname or just .classname
		driver.findElement(By.cssSelector(".input"));
		driver.findElement(By.cssSelector("input.input"));
		Thread.sleep(2000);

		// contains() method tagname[attribute*='text']
		driver.findElement(By.cssSelector("input[id*='pass']")).sendKeys("demo123");
		driver.findElement(By.cssSelector("input[value*='Log In']")).click();
		Thread.sleep(2000);

		// starts-with() method tagname[attribute^='text']
		driver.findElement(By.cssSelector("input[name^='post']"));
		Thread.sleep(2000);

		// ends-with() method tagname[attribute$='text']
		driver.findElement(By.cssSelector("div[class$='menu-name']"));
		Thread.sleep(2000);

		// inner text - tagname:contains("text")
		// :contains() is not part of the current CSS3 specification so it will not work
		// on all browsers, only ones that implemented it before it was pulled. (see
		// w3.org/TR/css3-selectors)
		// driver.findElement(By.cssSelector("a:contains('Customise')"));
		// Thread.sleep(2000);

		driver.quit();

	}

}
