package webdriver.java.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JakToZrobicSpam {
	private WebDriver driver;

	public JakToZrobicSpam() {
		super();
		setup();
	}

	public void setup() {
		driver = new FirefoxDriver();
	}

	public void tearDown() {
		driver.quit();
	}

	public void go() {
		String url = "http://www.jaktozrobic.org/";
		driver.get(url);

		WebElement el1 = driver.findElement(By.className("box_image"));
		el1.click();

		for (int i = 0; i < 2; i++) {
			WebElement author = driver.findElement(By.id("author"));
			WebElement email = driver.findElement(By.id("email"));
			WebElement comment = driver.findElement(By.id("comment"));
			
			author.clear();
			email.clear();
			comment.clear();
			
			author.sendKeys(authorGen());
			email.sendKeys(emailGen());
			comment.sendKeys(commentGen());

			comment.submit();
		}
	}

	private String authorGen() {
		return "name" + (System.currentTimeMillis() + "").substring(0, 2)
				+ ((Math.random() * 1000) + "").substring(0, 3);
	}

	private String emailGen() {
		return "email" + (System.currentTimeMillis() + "").substring(0, 2)
				+ ((Math.random() * 1000) + "").substring(0, 3) + "@wp.pl";
	}

	private String commentGen() {
		return "comment xxx " + (System.currentTimeMillis() + "").substring(0, 2)
				+ ((Math.random() * 1000) + "").substring(0, 3);
	}
}
