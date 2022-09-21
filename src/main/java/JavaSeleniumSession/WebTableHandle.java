package JavaSeleniumSession;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableHandle {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://classic.crmpro.com/index.html");
		
		driver.findElement(By.name("username")).sendKeys("TestNJ");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Thread.sleep(5000);
		
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.linkText("CONTACTS")).click();
		
		Thread.sleep(5000);
		
		String xpath = "//a[text()='Harindra Test']/parent::td/preceding-sibling::td/input";
		driver.findElement(By.xpath(xpath)).click();
		
		selectContact("Deepti Gupta");
		System.out.println(getCompanyName("Deepti Gupta"));
		
		System.out.println(getPhoneNumberList("Deepti Gupta"));
		
		System.out.println(getEmailId("Deepti Gupta"));
		

	}
	
	public static void selectContact(String contactName) {
		String xpath = "//a[text()='"+contactName+"']/parent::td/preceding-sibling::td/input";
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public static String getCompanyName(String contactName) {
		String xpath = "//a[text()='"+contactName+"']//parent::td//following-sibling::td/a[@context='company']";
		return driver.findElement(By.xpath(xpath)).getText();
	}
	
	public static List<String> getPhoneNumberList(String contactName) {
		String xpath = "//a[text()='"+contactName+"']//parent::td//following-sibling::td/span[@context='phone']";
		List<WebElement>phList = driver.findElements(By.xpath(xpath));
		List<String> textList = new ArrayList<String>();
		String text;
		for (WebElement e:phList) {
			text = e.getText();
			textList.add(text);
		}
		return textList;
	}
	
	public static String getEmailId(String contactName) {
		String xpath = "//a[text()='"+contactName+"']//parent::td//following-sibling::td/a[starts-with(@href,'mailto')]";
		String emailId = driver.findElement(By.xpath(xpath)).getText();
		return emailId;
	}

}
