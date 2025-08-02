package testNg;

import org.testng.annotations.*;

public class testNg2 {

	@BeforeTest
	public void beforeTest() {
		System.out.println("Inside Before Test");
	}

	@AfterTest
	public void AfterTest() {
		System.out.println("Inside After Test");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("Inside Before Class");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("Inside After Class");
	}

	@Test
	public void test() {
		System.out.println("testcase1");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Inside Before Method");
	}

	@AfterMethod
	public void AfterMethod() {
		System.out.println("Inside After Method");
	}
	
}
