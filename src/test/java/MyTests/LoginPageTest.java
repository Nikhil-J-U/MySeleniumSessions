package MyTests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPageTest {
	
//	@BeforeSuite
//	public void dbConnection()
//	{
//		System.out.println("Before Suite - BS - executing..");
//	}
//	
//	@BeforeTest
//	public void loginPage() {
//		System.out.println("Before Test - BT - executing..");
//	}
//	
//	@BeforeClass
//	public void userInput() {
//		System.out.println("Before Class - BC - executing..");
//	}
//	
//	@BeforeMethod
//	public void userProfile() {
//		System.out.println("Before Method - BM - executing..");
//	}
	
	@Test(priority = 0)
	public void clear() {
		System.out.println("Test - T - executing.. priority 0");
	}
	
	@Test(priority = 1)
	public void performTransaction() {
		System.out.println("Test - T - executing.. prioirty -1");
	}
	@Test(priority = 2)
	public void clear1() {
		System.out.println("Test - T - executing.. priority -2");
	}
	
	@Test
	public void performTransaction1() {
		System.out.println("Test - T - executing.. no priority method 1");
	}
	@Test
	public void performTransaction2() {
		System.out.println("Test - T - executing.. no priority method 2");
	}
	
	
//	@AfterMethod
//	public void submitProfile() {
//		System.out.println("After Method - AM - executing..");
//	}
//	
//	@AfterClass
//	public void submitInput() {
//		System.out.println("After Class - AC - executing..");
//	}
//	
//	@AfterTest
//	public void logout() {
//		System.out.println("After Test - AT - executing..");
//	}
//	
//	@AfterSuite
//	public void dbConnectionEnd() {
//		System.out.println("After Suite - AS - executing..");
//	}

}
