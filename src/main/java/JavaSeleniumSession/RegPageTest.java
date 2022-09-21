package JavaSeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegPageTest {

	public static void main(String[] args) throws InterruptedException {
		
		BrowserUtil br = new BrowserUtil();
		WebDriver driver = br.launchBrowser("chrome");
		br.enterUrl("https://demo.opencart.com/index.php?route=account/register&language=en-gb");
		String title = br.getPageTitle();
		System.out.println("title is: "+title);
		
		By firstName = By.id("input-firstname");
		By lastName = By.id("input-lastname");
		By email = By.id("input-email");
		
		ElementUtil ele = new ElementUtil(driver);
		ele.doSendKeys(firstName, "Nikhil");
		ele.doSendKeys(lastName, "Jyothi");
		ele.doSendKeys(email,"niki.uj@gmail.com");
		
		Thread.sleep(5000);
		
		br.closeBrowser();

	}

}
