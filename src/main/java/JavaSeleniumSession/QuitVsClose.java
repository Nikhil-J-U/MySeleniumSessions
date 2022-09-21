package JavaSeleniumSession;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitVsClose {

	public static void main(String[] args) {
		
		//session id case 1: invalid session id (sessionid doesnt become null 
//		after closing yet cant access and msg)
		
//		System.setProperty("webdriver.chrome.driver","C:\\Users\\Nikhil JU\\Downloads\\chromedriver.exe");
//		
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://www.google.com");
//		//ChromeDriver: chrome on WINDOWS (0ea23320a38c8e4ba54220b5f1e3db5d)
//		String title = driver.getTitle();
//		System.out.println(title);
//		
//		driver.close();
//		
//		System.out.println(driver.getTitle());
		
		
		// case 2: in case of quit - session id is null 
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Nikhil JU\\Downloads\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		String title = driver.getTitle();
		System.out.println(title);
		
		driver.quit();
		
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		
		System.out.println(driver.getTitle());
		

	}

}
