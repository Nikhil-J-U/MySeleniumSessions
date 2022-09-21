package JavaSeleniumSession;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinkTextUtil {
	
	static WebDriver driver;
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.amazon.com/");
		
		By links = By.tagName("a");
		
		System.out.println("count: "+getElementsCount(links));
		List<String> linkText = getElementsTextList(links);
//		for(String e:linkText) {
//			System.out.println(e);
//		}
		
		if (getElementsTextList(links).contains("All")) {
			System.out.println("All link is present");
		}
		

	}
	
	public static List<String> getElementsTextList(By locator) {
		List<WebElement> eleList = getElements(locator);
		List<String> eleTextList = new ArrayList<String>();
		String text;
		for(WebElement e:eleList) {
			text = e.getText();
			if(!text.isEmpty()) {
				eleTextList.add(text);
			}
		}
		
		return eleTextList;
		
	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public static int getElementsCount(By locator) {
		return getElements(locator).size();
	}

}
