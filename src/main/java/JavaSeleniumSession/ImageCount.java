package JavaSeleniumSession;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImageCount {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.amazon.com/");

		// List<WebElement> imgList = driver.findElements(By.tagName("img"));
		By images = By.tagName("img");
		List<WebElement> imgList = getElements(images);

		System.out.println(imgList.size());

		for (WebElement e : imgList) {
			String altValue = e.getAttribute("alt");
			String srcValue = e.getAttribute("src");

			System.out.println(altValue + "---->" + srcValue);
		}

	}


	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

}
