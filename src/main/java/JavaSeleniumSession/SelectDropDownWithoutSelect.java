package JavaSeleniumSession;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropDownWithoutSelect {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/?");

		By country = By.xpath("//select[@id='Form_getForm_Country']/option");
		doSelectDropDownValueWithoutSelect(country, "India");
		

	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public static void doSelectDropDownValueWithoutSelect(By locator, String value) {
		List<WebElement> countryList = getElements(locator);
		System.out.println(countryList.size());
		String text;
		for (WebElement e : countryList) {
			text = e.getText();
			if (text.equals(value)) {
				e.click();
				break;
			}
		}
	}

}
