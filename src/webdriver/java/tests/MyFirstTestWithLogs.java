package webdriver.java.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class MyFirstTestWithLogs {
	
	private WebDriver driver;
	private static Logger logger;
	
	@BeforeMethod (alwaysRun = true) 
	public void setup() {
		driver = new FirefoxDriver();
		logger = LogManager.getLogger(MyFirstTestWithLogs.class.getName());
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
		logger.exit();
	}
	
	
	@Test
	public void test1() {
		String url = "http://taasvn.kainos.com:8080/jpetstore/shop/index.shtml";
		String titleExpected = "JPetStore Demo";
		Integer timeoutInSeconds = 10;
		
		logger.entry();
		logger.error("Getting the JPetStore url");
		driver.get(url);
		
		logger.fatal("Asserting title");
		String title = driver.getTitle();
		assert title.equals(titleExpected);
		
		logger.error("Asserting picture presence");
//		WebElement element = driver.findElement(By.cssSelector("img[src=\"../images/))
	}
}
