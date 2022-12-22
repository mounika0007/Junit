package junitLearning;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PpractiseTest {
	public static WebDriver driver;
	public static long current_time;
	public static long endTime = System.currentTimeMillis();
	@BeforeClass
	public static void BrowserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	@AfterClass
	public static void closeBrowser()
	{
		//driver.quit();
	}
	@Before
	public void beforeMethod() {
		
		 current_time = System.currentTimeMillis();
		System.out.println("Before Methd");
	}
	@After
	public void afterMethod() {
		long Difference = current_time-endTime;
		System.out.println("After MEnthod "+Difference);
	}	
	@Test //annotations
	public void test1() {
		driver.navigate().to("https://www.amazon.com");
		driver.manage().window().maximize();
		//System.out.println("Launch");
	}
	@Test
	public void test2() {
		WebElement search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		search.sendKeys("Iphone");
		boolean displayed = search.isDisplayed();
		Assert.assertTrue(displayed);
		WebElement searchClick = driver.findElement(By.xpath("//input[contains(@value,'Go')]"));
		searchClick.click();
		
		WebElement textValue = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span"));
		String value1 = textValue.getText();
		textValue.click();
		System.out.println(value1);
		
		WebElement secondVal = driver.findElement(By.xpath("//span[contains(@class,'a-size-large product-title-word-break')]"));
		String value2 = secondVal.getText();
		System.out.println(value2);
	
		WebElement addtoCart = driver.findElement(By.xpath("//*[@id=\"exportsUndeliverable-cart-announce\"]"));
		addtoCart.click();
		System.out.println("Item Added to Cart");
		
		Assert.assertEquals(value1, value2);
			
		System.out.println("Search");
	}
	@Test
	public void test3() {
		System.out.println("Welcome");
	}
	@Test
	public void test4() {

		System.out.println("SelectProduct");
	}
	
	@Test
	public void test5() {
		System.out.println("Buy cart");
	}

}
