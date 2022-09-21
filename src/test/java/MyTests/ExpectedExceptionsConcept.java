package MyTests;

import org.testng.annotations.Test;

public class ExpectedExceptionsConcept {
		String name = "null";
		@Test(expectedExceptions = {ArithmeticException.class, NullPointerException.class})
		public void loginTests() {
			System.out.println("login..");
//			int a = 9/0;
			
			ExpectedExceptionsConcept e = new ExpectedExceptionsConcept();
			e = null;
			System.out.println(e.name);
		}


}
