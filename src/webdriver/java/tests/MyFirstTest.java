package webdriver.java.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.*;

public class MyFirstTest {
	
	private WebDriver driver;
	
	@BeforeMethod (alwaysRun = true)
	public void setup(){
		driver = new FirefoxDriver();
	}
	
	@AfterMethod (alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
	// http://taasvn.kainos.com:8080/jpetstore/
	@Test(groups = { "testGroup1" }, priority = 0, description = "My first test.")
	public void myFirstTest(){
		String url = "http://taasvn.kainos.com:8080/jpetstore/shop/index.shtml";
		String titleExpected = "JPetStore Demo";		
		
		driver.get(url);
		
		String title = driver.getTitle();
		assert title.equals(titleExpected) == true;		
		
		WebElement element = driver.findElement(By.cssSelector("img[src=\"../images/logo-topbar.gif\"]"));
		assert element.isDisplayed() == true;
	}
	
	@Test(groups = { "testGroup1" }, priority = 1, description = "My first test.", enabled=false)
	public void myFirstTest2(){
		String url = "http://taasvn.kainos.com:8080/jpetstore/shop/index.shtml";
		String titleExpected = "JPetStore Demo";		
		
		driver.get(url);
		
		String title = driver.getTitle();
		assert title.equals(titleExpected) == true;		
		
		WebElement element = driver.findElement(By.cssSelector("img[src=\"../images/logo-topbar.gif\"]"));
		assert element.isDisplayed() == true;
	}
	
	@Test
	public void myFirstTest3() {
		String url = "http://taasvn.kainos.com:8080/jpetstore/shop/index.shtml";
		
		driver.get(url);
		
		driver.findElement(By.cssSelector("img[src='../images/fish_icon.gif']")).click();
		
		assert driver.findElement(By.name("keyword")).isDisplayed();
		assert driver.findElement(By.linkText("<< Main Menu")).isDisplayed();
		assert driver.findElement(By.xpath("//center[2]/h2")).isDisplayed();
		assert driver.findElement(By.cssSelector("img[name='img_cart']")).isDisplayed();
	}
}
