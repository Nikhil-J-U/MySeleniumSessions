package JavaSeleniumSession;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitConcept {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		By input = By.id("input-firstname");

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(2)).ignoring(NoSuchElementException.class)
				.withMessage("element not found...");
		
//		wait.until(ExpectedConditions.presenceOfElementLocated(input)).sendKeys("Nikhil");
		waitForElementpresentUsingFluentWait(input, 10, 2).sendKeys("Nikhil");
	}
	
	public static WebElement waitForElementpresentUsingFluentWait(By locator, int timeOut, long pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofMillis(pollingTime))
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.withMessage("element not found...");
		
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				
	}
	
	public static WebElement waitForElementUsingWebDriverWait(By locator, int timeOut, long pollingTime) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait
			.withTimeout(Duration.ofSeconds(timeOut))
			.pollingEvery(Duration.ofMillis(pollingTime))
			.ignoring(NoSuchElementException.class)
			.ignoring(StaleElementReferenceException.class)
			.withMessage("element not found...");
		
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		
	}

}
