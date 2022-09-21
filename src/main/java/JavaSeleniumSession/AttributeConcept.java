package JavaSeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AttributeConcept {
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.amazon.com/");
		
//		String attrname = driver.findElement(By.linkText("Amazon Devices")).getAttribute("href");
//		System.out.println(attrname);
//		
		By attrname = By.linkText("Amazon Devices");
		String hrefVal = getAttributeValue(attrname, "href");
		if(hrefVal.contains("footer_devices")) {
			System.out.println("this is correct");
		}
		
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static String getAttributeValue(By locator, String value) {
		String attrValue = getElement(locator).getAttribute(value);
		System.out.println(attrValue);
		return attrValue;
	}

}
