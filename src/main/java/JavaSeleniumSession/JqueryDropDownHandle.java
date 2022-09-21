package JavaSeleniumSession;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryDropDownHandle {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");

		Thread.sleep(5000);

		driver.findElement(By.id("justAnInputBox")).click();

//		List<WebElement> optionsList = driver.findElements(By.cssSelector("span.comboTreeItemTitle"));
//
//		for (WebElement e : optionsList) {
//			String text = e.getText();
//			System.out.println(text);
//			if (text.equals("choice 5")) {
//				e.click();
//			}
//		}

		By choices = By.cssSelector("span.comboTreeItemTitle");
		// selectChoice(choices, "choice 6 2 1");

//		selectChoice(choices, "choice 1", "choice 6 2 1", "choice 5");

		selectChoice(choices, "all");

	}

	public static void selectChoice(By locator, String... value) {
		List<WebElement> optionsList = driver.findElements(locator);

		if (!value[0].equalsIgnoreCase("all")) {

			for (WebElement e : optionsList) {
				String text = e.getText();
				System.out.println(text);

				for (int i = 0; i < value.length; i++) {
					if (text.equals(value[i])) {
						e.click();
						break;
					}
				}
//			if (text.equals(value)) {
//				e.click();
//			}
			}
		} else {
			try {
				for (WebElement e : optionsList) {
					e.click();
				}
			} catch (ElementNotInteractableException e) {
				System.out.println("all choices are over....");
			}
		}

	}
}
