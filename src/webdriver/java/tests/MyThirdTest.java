package webdriver.java.tests;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyThirdTest {
	private WebDriver driver;
	
	private String bulldogId = "K9-BD-01";
	private String chihuahuaId = "K9-CW-01";
	private String dalmationId = "K9-DL-01";
	private String poodle = "K9-PO-01";
	
	private List<String> allowedDogs = Arrays.asList("Bulldog", "Chihuahua" ,"Dalmation", "Poodle");
	private List<String> allowedIds = Arrays.asList("K9-BD-01", "K9-CW-01" ,"K9-DL-01", "K9-PO-02");

	@BeforeMethod(alwaysRun = true)
	public void setup() {
		driver = new FirefoxDriver();
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
//		driver.quit();
	}

	@Test
	public void test1() {
		String url = "http://taasvn.kainos.com:8080/jpetstore/shop/index.shtml";
		driver.get(url);
		
		driver.findElement(By.cssSelector("img[src='../images/sign-in.gif']")).click();
		
		WebElement username = driver.findElement(By.name("username"));
		username.clear();
		username.sendKeys("j2ee");
		
		WebElement password = driver.findElement(By.name("password"));
		password.clear();
		password.sendKeys("j2ee");
		password.submit();
		
		driver.findElement(By.cssSelector("area[href='viewCategory.shtml?categoryId=DOGS']")).click();
		
		List<WebElement> downloadedDogs =  driver.findElements(By.xpath("/html/body/table[3]/tbody/tr/td[2]"));
		for(int i=1;i<downloadedDogs.size();i++) {
			assert allowedDogs.contains(downloadedDogs.get(i).getText());
		}
		
		List<WebElement> downloadedIds =  driver.findElements(By.xpath("/html/body/table[3]/tbody/tr/td[1]"));
		for(int i=1;i<downloadedIds.size()-1;i++) {
			assert allowedIds.contains(downloadedIds.get(i).getText());
		}
		
		driver.findElement(By.linkText("K9-BD-01")).click();
		assert driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[2]/td[2]")).getText().equals("K9-BD-01");
	}

}
