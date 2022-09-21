package JavaSeleniumSession;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerTest {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
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
		
	}

}
