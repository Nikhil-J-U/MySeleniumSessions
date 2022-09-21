package JavaSeleniumSession;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CrossBrowserTest {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		String browser = "chrome";
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nikhil JU\\Downloads\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\Nikhil JU\\Downloads\\edgedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Nikhil JU\\Downloads\\geckoriver.exe");
			driver = new ChromeDriver();
		}
		else {
			System.out.println("please pass the right browser.."+browser);
		}
		
		driver.get("https://www.google.com");
		String title = driver.getTitle();
		System.out.println("title is: "+title);
		
		if(title.equals("Google")) {
			System.out.println("pass");
		}
		else {
			System.out.println("fail");
		}
		
		System.out.println(driver.getCurrentUrl());
		driver.quit();
		

	}

}
