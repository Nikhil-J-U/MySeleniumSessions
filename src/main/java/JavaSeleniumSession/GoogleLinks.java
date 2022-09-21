package JavaSeleniumSession;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleLinks {
	static WebDriver driver;
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.google.co.in");
		
		By lang = By.xpath("//div[@id='SIvCob']/a");
		
//		List<WebElement> optionsList = driver.findElements(By.xpath("//div[@id='SIvCob']/a"));
//		System.out.println(optionsList.size());
//		String text;
//		for(WebElement e:optionsList) {
//			text = e.getText();
//			System.out.println(text);
//		}
		List<String> actualLink = getLinksTextList(lang);
		if(actualLink.contains("ಕನ್ನಡ")) {
			System.out.println("ಕನ್ನಡ is present on the page");
		}
		clickOnElement(lang, "ಕನ್ನಡ");

	}
	
	public static List<String> getLinksTextList(By locator) {
		List<WebElement> linksList = driver.findElements(locator);
		List<String> linkTextList = new ArrayList<String>();
		String text;
		for(WebElement e:linksList) {
			text = e.getText();
			linkTextList.add(text);
		}
		return linkTextList;
	}
	
	public static void clickOnElement(By locator, String linkText) {
		List<WebElement> optionsList = driver.findElements(locator);
		System.out.println(optionsList.size());
		String text;
		for(WebElement e:optionsList) {
			text = e.getText().trim();
			System.out.println(text);
			if(text.equals(linkText)) {
				e.click();
				break;
			}
		}
	}

}
