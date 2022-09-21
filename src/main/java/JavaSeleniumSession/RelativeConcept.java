package JavaSeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeConcept {
	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.aqi.in/dashboard/canada");
		
		WebElement ele = driver.findElement(By.linkText("Chatham, Canada"));
		
		String right = driver.findElement(with(By.tagName("p")).toRightOf(ele)).getText();
		System.out.println(right);
		
		String left = driver.findElement(with(By.tagName("p")).toLeftOf(ele)).getText();
		System.out.println(left);
		
		String below = driver.findElement(with(By.tagName("a")).below(ele)).getText();
		System.out.println(below);
		

	}

}
