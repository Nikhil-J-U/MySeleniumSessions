package JavaSeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyElement {
	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		By formFields = By.className("form-control");
		int fieldscount = driver.findElements(formFields).size();
		if(fieldscount == 0) {
			System.out.println("form fields are not available");
		}
		else {
			System.out.println("form fields are available");
		}
		
		By loginLink = By.linkText("Login");
		driver.findElement(loginLink).click();
		boolean flag = driver.findElement(loginLink).isDisplayed();
		System.out.println(flag);
		
		if(driver.findElements(loginLink).size() >=1) {
			System.out.println("login link is present on the page");
		}
		
		System.out.println(isElementExists(loginLink));
	}
	
	public static boolean isElementExists(By locator) {
		int elementcount = driver.findElements(locator).size();
		System.out.println("total elements found: "+ elementcount);
		if(elementcount>=1) {
			System.out.println("element is found.. "+locator);
			return true;
		}
		else {
			System.out.println("element is not found.."+locator);
			return false;
		}
	}

}
