package JavaSeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OtherLocators {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		
		//2. name
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://demo.opencart.com/index.php?route=account/register&language=en-gb");
//		driver.get("https://classic.crmpro.com/index.html");
		
		
//		driver.findElement(By.name("username")).sendKeys("niki@crm.com");
//		driver.findElement(By.name("password")).sendKeys("nik123");
		
//		By emailid = By.name("username");
//		
		ElementUtil eu = new ElementUtil(driver);
//		eu.doSendKeys(emailid, "nikhil@gmail.com");
//		
		//3. className:
		
//		driver.findElement(By.className("form-control")).sendKeys("nikki");
//		
		//4. xpath:
		
		////*[@id="input-firstname"]
		///html/body/main/div[2]/div/div/form/fieldset[1]/div[2]/div/input
		
//		driver.findElement(By.xpath("//*[@id=\"input-firstname\"]")).sendKeys("nikhil");
//		driver.findElement(By.xpath("/html/body/main/div[2]/div/div/form/fieldset[1]/div[4]/div/input")).sendKeys("niki@gmail.com");
//		
//		By firstName = By.xpath("//*[@id=\"input-firstname\"]");
//		By email = By.xpath("/html/body/main/div[2]/div/div/form/fieldset[1]/div[4]/div/input");
//		
//		eu.doSendKeys(firstName, "nikki");
//		eu.doSendKeys(email, "niki@gmail.com");
		
		//5. cssSelector
//		
//		driver.findElement(By.cssSelector("#input-firstname")).sendKeys("nikhil");
//		
		//6. linktext
//		driver.findElement(By.linkText("Login")).click();
//		By link = By.linkText("Login");
//		doClick(link);
		
//		String link = "Login";
//		eu.doClick("linkText", link);
		
		//7. partialLinkText
//		
//		driver.findElement(By.partialLinkText("policy")).click();
//		
		//8. tagName
		
//		String header = driver.findElement(By.tagName("h1")).getText();
//		System.out.println(header);
//		
//		if(header.contains("Delight made easy")) {
//			System.out.println("h1 header is correct");
//		}
		By header = By.tagName("h1");
		if(doGetText(header).contains("Delight made easy")) {
			System.out.println("h1 header is correct");
		}

	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doClick(By locator) {
		getElement(locator).click();
	}
	
	public static String doGetText(By locator) {
		return getElement(locator).getText();
	}

}
