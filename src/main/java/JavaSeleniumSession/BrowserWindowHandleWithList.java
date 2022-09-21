package JavaSeleniumSession;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowHandleWithList {

	static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://selectorshub.com/xpath-practice-page/");
		
		Set<String> handles = driver.getWindowHandles();
		List<String> listHandles = new ArrayList<String>(handles);
		String parentWindowID = listHandles.get(0);
		String childWindorId = listHandles.get(1);
		
		driver.switchTo().window(childWindorId);
		driver.close();
		
		driver.switchTo().window(parentWindowID);
		driver.close();
	}

}
