package webdriver.java.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MySecondTest {
	int iterator = 15;
	String username = "szymonre" + iterator;
	String password = "password" + iterator;
	String accountFirstname = "Szymon" + iterator;
	String accountLastname = "Rekawek" + iterator;
	String accountEmail = "ggg@wp.pl" + iterator;
	String accountPhone = "555444333" + iterator;
	String accountAddress1 = "Sloneczna 3/5" + iterator;
	String accountAddress2 = "Workowa 2/15" + iterator;
	String accountCity = "Gdansk" + iterator;
	String accountState = "PM" + iterator;
	String accountZip = "80-309" + iterator;
	String accountCountry = "Poland" + iterator;
	
	private WebDriver driver;
	private static Logger logger;

	
	@BeforeMethod (alwaysRun = true)
	public void setup(){
		driver = new FirefoxDriver();
		logger = LogManager.getLogger(MyFirstTestWithLogs.class.getName());
		logger.entry();
	}
	
	@AfterMethod (alwaysRun = true)
	public void tearDown() {
		driver.quit();
		logger.exit();

	}
	
	@Test
	public void checkCreateAccount() {
		assert createAccount();
		driver.findElement(By.cssSelector("img[src='../images/my_account.gif']")).click();
		
		assert driver.findElement(By.xpath("//*[contains(.,'"+username+"')]")) !=null;
		assert driver.findElement(By.name("account.firstName")).getAttribute("value").equals(accountFirstname);
		assert driver.findElement(By.name("account.lastName")).getAttribute("value").equals(accountLastname);
		assert driver.findElement(By.name("account.email")).getAttribute("value").equals(accountEmail);
		assert driver.findElement(By.name("account.phone")).getAttribute("value").equals(accountPhone);
		assert driver.findElement(By.name("account.address1")).getAttribute("value").equals(accountAddress1);
		assert driver.findElement(By.name("account.address2")).getAttribute("value").equals(accountAddress2);
		assert driver.findElement(By.name("account.city")).getAttribute("value").equals(accountCity);
		assert driver.findElement(By.name("account.state")).getAttribute("value").equals(accountState);
		assert driver.findElement(By.name("account.zip")).getAttribute("value").equals(accountZip);
		assert driver.findElement(By.name("account.country")).getAttribute("value").equals(accountCountry);
		
		assert driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table[3]/tbody/tr[2]/td[2]/select/option[4]")).getAttribute("value").equals("CATS");
		
		assert driver.findElement(By.name("account.listOption")).getAttribute("value").equals("on");
		assert driver.findElement(By.name("account.bannerOption")).getAttribute("value").equals("on");
		logger.info("Skonczylem");
	}
	
	private boolean createAccount() {
		
		String url = "http://taasvn.kainos.com:8080/jpetstore/shop/index.shtml";
		
		logger.info("Im connecting to "+url);
		driver.get(url);
		
		driver.findElement(By.cssSelector("img[src='../images/sign-in.gif']")).click();
		driver.findElement(By.cssSelector("img[src='../images/button_register_now.gif']")).click();
		
		WebElement elem1 = driver.findElement(By.name("username"));
		elem1.sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("repeatedPassword")).sendKeys(password);
		driver.findElement(By.name("account.firstName")).sendKeys(accountFirstname);
		driver.findElement(By.name("account.lastName")).sendKeys(accountLastname);
		driver.findElement(By.name("account.email")).sendKeys(accountEmail);
		driver.findElement(By.name("account.phone")).sendKeys(accountPhone);
		driver.findElement(By.name("account.address1")).sendKeys(accountAddress1);
		driver.findElement(By.name("account.address2")).sendKeys(accountAddress2);
		driver.findElement(By.name("account.city")).sendKeys(accountCity);
		driver.findElement(By.name("account.state")).sendKeys(accountState);
		driver.findElement(By.name("account.zip")).sendKeys(accountZip);
		driver.findElement(By.name("account.country")).sendKeys(accountCountry);
		driver.findElement(By.cssSelector("option[value='CATS']")).click();
		driver.findElement(By.name("account.listOption")).click();
		driver.findElement(By.name("account.bannerOption")).click();
		elem1.submit();
		logger.info("User created");

		return true;
	}

}
