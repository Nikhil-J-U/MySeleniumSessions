package JavaSeleniumSession;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverCasting {

	public static void main(String[] args) {
		
		
		//1. WD - CD
		
		WebDriver dr = new ChromeDriver();
		
		//2. ChromeDriver driver = new ChromeDriver() - specific browser
		
		ChromeDriver cd = new ChromeDriver();
		
		//3. RD = CD
		
		RemoteWebDriver rw = new ChromeDriver();
//		rw = new FireFoxDriver();
		
		
		//4. WD - RWD - remote machine/server/vm/docker/cloud/cloud vendor
//		
//		WebDriver driver = new RemoteWebDriver();
//		new RemoteWebDriver(new URL("192.45.1.10:4444"), capabilities);
		//5. SC - CD:
//		SearchContext driver = new ChromeDriver();
//		driver.
		
		//6. SC - RWD
//		SearchContext driver = new RemoteWebDriver(new URL("192.45.1.10:4444"), capabilities);
//		

	}

}
