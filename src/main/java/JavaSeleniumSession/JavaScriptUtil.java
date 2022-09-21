package JavaSeleniumSession;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptUtil {
	private WebDriver driver;
	public JavaScriptUtil(WebDriver driver) {
		this.driver = driver;
	}
	public void waitForPageLoaded() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String loadingStatus = js.executeScript("return document.readyState;").toString();
		
		if(loadingStatus.equals("complete")) {
			System.out.println("page is fully loaded");
		}
		else {
			for (int i=1; i<=20;i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				loadingStatus = js.executeScript("return document.readyState;").toString();
				System.out.println("current page loading status: "+loadingStatus);
				if(loadingStatus.equals("complete")) {
					break;
				}
			}
		}
	}

}
