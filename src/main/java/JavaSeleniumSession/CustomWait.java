package JavaSeleniumSession;



import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomWait {
	static WebDriver driver;
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		By input = By.id("input-firstname1");
		retryingElement(input, 20, 3000).sendKeys("Nikhil");


	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static WebElement retryingElement(By locator, int timeOut, long pollingTime) {
		WebElement element = null;
		int attempts = 0;
		
		while (attempts<timeOut) {
			try {
			element = getElement(locator);
			break;
			}
			catch (NoSuchElementException e){
				System.out.println("element is not found in attempt " + attempts + ": " + locator);
				try {
					Thread.sleep(pollingTime);
				} catch(InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			attempts++;
		}
		
		if(element == null) {
			try {
				throw new Exception("ELEMENTNOTFOUNDEXCEPTION");
			}
			catch(Exception e) {
				System.out.println("element is not found exception.... tried for :" +timeOut+ "with the interval of : "+pollingTime);
			}
		}
		return element;
	}
	
	

}
