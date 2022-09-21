package JavaSeleniumSession;

import org.openqa.selenium.WebDriver;

public class RegPageTest1 {

	public static void main(String[] args) throws InterruptedException {
		
		BrowserUtil br = new BrowserUtil();
		WebDriver driver = br.launchBrowser("chrome");
		br.enterUrl("https://demo.opencart.com/index.php?route=account/register&language=en-gb");
		String title = br.getPageTitle();
		System.out.println("title of the page is: "+title);
		
		ElementUtil eu = new ElementUtil(driver);
		String firstName = "input-firstname";
		String lastName = "input-lastname";
		String email = "input-email";
		String pwd = "input-password";
		eu.doSendKeys("id", firstName, "Nikhil");
		eu.doSendKeys("id", lastName, "Jyothi");
		eu.doSendKeys("id", email, "niki.uj@gmail.com");
		eu.doSendKeys("id", pwd, "nikh123");
		
		Thread.sleep(5000);
		
		br.closeBrowser();
	}

}
