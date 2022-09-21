package JavaSeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticWebTable {
	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		String beforeXpath = "//table[@id='customers']/tbody/tr[";
		String afterXpath = "]/td[";
//		
//		int rowCount = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr")).size();
//		int colCount = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/th")).size();
//		
//		for (int i=2;i<=rowCount;i++) {
//			String compXpath = beforeXpath+i+afterXpath;
//			String text = driver.findElement(By.xpath(compXpath)).getText();
//			System.out.println(text);
//		}
		
		By row = By.xpath("//table[@id='customers']/tbody/tr");
		By col = By.xpath("//table[@id='customers']/tbody/tr/th");
		printTable(row, col, beforeXpath, afterXpath);
	}
	
	public static void printTable(By rowLocator, By colLocator, String beforeXpath, String afterXpath) {
		int rowCount = driver.findElements(rowLocator).size();
		int colCount = driver.findElements(colLocator).size();
		for (int row=2;row<=rowCount;row++) {
			for (int col=1;col<=colCount;col++) {
				String xpath = beforeXpath+row+afterXpath+col+"]";
				String text = driver.findElement(By.xpath(xpath)).getText();
				System.out.print(text+"           |        ");
			}
			System.out.println();
		}
		
	}

}
