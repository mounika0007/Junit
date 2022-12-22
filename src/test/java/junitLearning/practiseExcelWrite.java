package junitLearning;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

public class practiseExcelWrite {
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
		System.out.println("Launch");
	}
	@Test
	public void test2() throws Throwable{
		
		
		System.out.println("Search1");
		WebElement search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		search.sendKeys("Iphone");
		boolean displayed = search.isDisplayed();
		Assert.assertTrue(displayed);
		WebElement searchClick = driver.findElement(By.xpath("//input[contains(@value,'Go')]"));
		searchClick.click();
		
		
		List<WebElement> textValues = driver.findElements(By.xpath("//span[contains(@class,'a-size-medium a-color-base a-text-normal')]"));
		
			System.out.println(textValues.size());
		File f = new File("C:\\Users\\91822\\Desktop\\MobilePhones.xlsx");
			Workbook w = new XSSFWorkbook();
			Sheet sheet = w.createSheet("Sheet1");
			for(int i=0;i<textValues.size();i++)
			{
				WebElement headLines = textValues.get(i);
			String val = headLines.getText();
				Row row = sheet.createRow(i);
			Cell cell = row.createCell(i);
				cell.setCellValue(val);
	
			}
			FileOutputStream f1 = new FileOutputStream(f);
			w.write(f1);
			f1.close();	
			//System.out.println(headLines.getText());
						
		
			
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
