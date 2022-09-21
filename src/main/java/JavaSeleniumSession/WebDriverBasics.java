package JavaSeleniumSession;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasics {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nikhil JU\\Downloads\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		String title = driver.getTitle();
		System.out.println("page title is: "+title);
		
		//validation point/checkpoint
		
		if(title.equals("Google")) {
			System.out.println("PASS -- correct title");
		}
		else {
			System.out.println("FAIL -- incorrect title");
		}
		
		System.out.println(driver.getCurrentUrl());
		
		driver.quit(); // close browser
		//driver.close();

	}

}
