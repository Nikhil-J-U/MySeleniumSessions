package JavaSeleniumSession;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForNonWebElements {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("http://automationpractice.com/index.php");

		driver.findElement(By.linkText("Contact us")).click();

		if (waitForURLToBe("controller=contact", 5)) {
			System.out.println("url is correct");
		}
		
		String text = doGetTitle("Contact us", 5);
		System.out.println(text);
	}
	
	public static String doGetTitleWithFraction(String titleFraction, int timeOut) {
		if(waitForTitleContains(titleFraction, timeOut)) {
			return driver.getTitle();
		}
		else {
			return null;
		}
	}
	
	public static String doGetTitle(String titleFraction, int timeOut) {
		if(waitForTitleToBe(titleFraction, timeOut)) {
			return driver.getTitle();
		}
		else {
			return null;
		}
	}
	public static boolean waitForTitleContains(String titleFraction, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.titleContains(titleFraction));
	}
	

	public static boolean waitForTitleToBe(String titleFraction, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.titleIs(titleFraction));
	}

	public static boolean waitForURLToContains(String urlFraction, int timeout) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.urlContains(urlFraction));

	}

	public static boolean waitForURLToBe(String url, int timeout) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.urlToBe(url));

	}

}
