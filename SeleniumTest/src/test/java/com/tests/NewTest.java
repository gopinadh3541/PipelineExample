package com.tests;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeTest;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.AfterTest;

public class NewTest {

	private WebDriver driver;

	@Test
	public void testEasy() {

		//System.setProperty("webdriver.chrome.driver", "src/main/resources/Firefox_Installer");

		driver = new HtmlUnitDriver();

		driver.get("http://10.92.128.88:7100/BankExample/");

		driver.manage().window().maximize();
		WebElement Searchbox = driver.findElement(By.name("uname"));
		WebElement Searchbox1=driver.findElement(By.name("pwd"));
		Searchbox.sendKeys("admin");
		Searchbox1.sendKeys("admin");
		WebElement Searchbox2=driver.findElement(By.name("submit"));
		Searchbox2.submit();
		System.out.println("After Click");
		/*String title = driver.getTitle();
		driver.getCurrentUrl();
		String expectedTitle = "Frames";
		Assert.assertEquals(expectedTitle, title);
		System.out.println("After Assertion:" + title + " " + expectedTitle + " Matched");*/
		driver.switchTo().frame("menu");
		WebElement Searchbox3=driver.findElement(By.linkText("WithDraw"));
		Searchbox3.click();
		System.out.println("<======Execution 1======>");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("message");
		WebElement searchBox1=driver.findElement(By.name("accnumber"));
		searchBox1.sendKeys("1234567890");
		driver.findElement(By.name("amount")).sendKeys("2000");
		try
		{
			driver.switchTo().frame("withdraw");
			WebElement Searchbox4=driver.findElement(By.name("accnumber"));
			Searchbox4.sendKeys("1234567890");
		}
		catch(NoSuchFrameException e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println("<======Execution 2======>");
		String title1=driver.getTitle();
		System.out.println("<======Execution 3======>");
/*		String expectedTitle1 = "View Balance";
		Assert.assertEquals(expectedTitle1, title1);
	*/	
		

		

	}

	@BeforeTest
	public void beforeTest() {

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
