package JavaSeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorConcept {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://demo.opencart.com/index.php?route=account/login&language=en-gb");

		// 1. by id
		// 1st
//		driver.findElement(By.id("input-email")).sendKeys("test@gmail.com");
//		driver.findElement(By.id("input-password")).sendKeys("test@123");
//		
		// 2nd webelement
//		WebElement emailId = driver.findElement(By.id("input-email"));
//		WebElement password = driver.findElement(By.id("input-password"));
//		
//		emailId.sendKeys("test@gmail.com");
//		password.sendKeys("test@123");

		// 3 by locator:

//		By username = By.id("input-email");
//		By password = By.id("input-password");
//		
//		WebElement emailId = driver.findElement(username);
//		WebElement pwd = driver.findElement(password);
//		
//		emailId.sendKeys("test@gmail.com");
//		pwd.sendKeys("test@123");

		// 4th: by locator with generic method (getElement())
//		By username = By.id("input-email");
//		By password = By.id("input-password");
//		
//		getElement(username).sendKeys("test@gmail.com");
//		getElement(password).sendKeys("test@123");
//		
		// 5th: by locator with generic method (getElement() with action methods)
//		
//		By username = By.id("input-email");
//		By password = By.id("input-password");
//		
//		doSendKeys(username,"test@gmail.com");
//		doSendKeys(password,"test123");

		// 6th ElementUtil class with generic methods
//		By username = By.id("input-email");
//		By pwd = By.id("input-password");
//		
//		ElementUtil EU = new ElementUtil(driver);
//		EU.doSendKeys(username, "test@gmail.com");
//		EU.doSendKeys(pwd, "test123");
//		
		// 7th using string instead of by locator
		String username = "input-email";
		String pwd = "input-password";
		
		doSendKeys("id", username, "test@gmail.com");
		doSendKeys("id", pwd, "test123");

	}

	public static By getBy(String locatorType, String locatorValue) {
		By locator = null;
		switch (locatorType.toLowerCase()) {
		case "id":
			locator = By.id(locatorValue);
			break;
		default:
			System.out.println("please enter correct locator type and value....");
			break;
		}
		return locator;
	}

	public static WebElement getElement(By locator) {

		return driver.findElement(locator);
	}

	public static WebElement getElement(String locatorType, String locatorValue) {

		return driver.findElement(getBy(locatorType, locatorValue));
	}

	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	public static void doSendKeys(String locatorType, String locatorValue, String value) {
		getElement(locatorType,locatorValue).sendKeys(value);
	}

}
