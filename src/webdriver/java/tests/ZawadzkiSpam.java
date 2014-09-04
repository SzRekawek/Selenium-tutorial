package webdriver.java.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZawadzkiSpam implements Runnable {
	private WebDriver driver;

	public ZawadzkiSpam() {
		super();
	}

	public void setup() {
		driver = new FirefoxDriver();
	}

	public void tearDown() {
		driver.quit();
	}

	public void go() {
		String url = "http://jason-web.pl/kontakt/";
		driver.get(url);

		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Imie")));

		WebElement author = driver.findElement(By.id("Imie"));
		WebElement email = driver.findElement(By.id("Email"));
		WebElement comment = driver.findElement(By.id("Tresc"));

		author.clear();
		email.clear();
		comment.clear();

		author.sendKeys(authorGen());
		email.sendKeys(emailGen());
		comment.sendKeys(commentGen());
		driver.findElement(By.name("submit")).click();
	}

	private String authorGen() {
		return "name" + (System.currentTimeMillis() + "").substring(0, 2)
				+ ((Math.random() * 10000) + "").substring(0, 2);
	}

	private String emailGen() {
		return "email" + (System.currentTimeMillis() + "").substring(0, 2)
				+ ((Math.random() * 10000) + "").substring(0, 2) + "@wp.pl";
	}

	private String commentGen() {
		return "comment xxx " + (System.currentTimeMillis() + "").substring(0, 2)
				+ ((Math.random() * 10000) + "").substring(0, 2);
	}

	@Override
	public void run() {
		setup();
		go();
		tearDown();
	}
}
