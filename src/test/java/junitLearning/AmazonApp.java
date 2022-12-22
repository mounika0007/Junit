package junitLearning;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class AmazonApp {
	public static WebDriver driver;
	public static long current_time = System.currentTimeMillis();;
	public static long endTime = System.currentTimeMillis();;
	@BeforeClass
	public static void BrowserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	@AfterClass
	public static void closeBrowser()
	{
		driver.quit();
	}
	
	@Before
	public void beforeMethod() {
		current_time = System.currentTimeMillis();
		System.out.println("Before Methd");
	}
	@After
	public void afterMethod() {
		endTime = System.currentTimeMillis();
		long Difference = endTime-current_time;
		System.out.println("After MEnthod "+Difference);
	}	
	@Test //annotations
	public void test1() {
		driver.navigate().to("https://www.amazon.com");		
		driver.manage().window().maximize();
		System.out.println("Launch");
	}
	@Test
	public void test2() {
		System.out.println("Search");
	}
	@Test
	public void test3() {
		System.out.println("Product");
	}
	@Test
	public void test4() {
		
		Assert.assertEquals(current_time, endTime);
		
//		WebElement search = driver.findElement(By.xpath("value"));
//		boolean displayed = search.isDisplayed();
//		Assert.assertTrue(displayed); //Boolean return Type
		System.out.println("SelectProduct");
	}
	//@Ignore //This will Ignore the method
	@Test
	public void test5() {
		System.out.println("Buy Now");
	}
}
