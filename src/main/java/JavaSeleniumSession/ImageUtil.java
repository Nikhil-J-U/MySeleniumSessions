package JavaSeleniumSession;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImageUtil {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.amazon.com/");

		By images = By.tagName("img");
		By links = By.tagName("a");
		System.out.println(getElementsCount(images));
		List<String> imageList = getAttributesList(images, "alt");
		printElementList(imageList);
		printElementList(getAttributesList(images, "src"));
		printElementList(getAttributesList(images, "href"));

	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public static void printElementList(List<String> eleList) {
		for (String e : eleList) {
			System.out.println(e);
		}
	}
	
	
	public static int getElementsCount(By locator) {
		return getElements(locator).size();
	}

	public static List<String> getAttributesList(By locator, String value) {
		List<WebElement> imgList = getElements(locator);
		String attrValue;
		List<String> attrList = new ArrayList<String>();
		for (WebElement e : imgList) {
			attrValue = e.getAttribute(value);
			attrList.add(attrValue);

		}

		return attrList;
	}

}
