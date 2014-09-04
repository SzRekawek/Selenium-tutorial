package webdriver.java.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class facebookLogin {
	private static WebDriver driver;
	
	public facebookLogin() {
		setup();
	}
	
	
	public void go() {
		String url = "https://www.facebook.com/";
		driver.get(url);
		
		WebElement email = driver.findElement(By.id("email"));
		WebElement pass = driver.findElement(By.id("pass"));
		
		email.sendKeys("nynonn@gmail.com");
		pass.sendKeys("487154zxc");
		email.submit();
	}
	
	public void setup(){
		driver = new FirefoxDriver();
	}
	
	public void tearDown() {
		driver.quit();
	}
}
