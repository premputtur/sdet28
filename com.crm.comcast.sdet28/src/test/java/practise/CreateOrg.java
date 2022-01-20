package practise;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateOrg {
	@BeforeClass
	public void bc() {
		System.out.println("launch the browser");
	}
	@AfterClass
	public void ac() {
		System.out.println("quit the browser");
	}

	@AfterMethod
	public void bm() {
		System.out.println("logout the application");
	}
	@Test(priority=1)
	public void org() {
		System.out.println("Navigate to orgaiztion");
		System.out.println("create organization");
		System.out.println("verify organization");
	}
	@Test(priority=2)
	public void contact() {
		System.out.println("Navigate to contact");
		System.out.println("create contact");
		System.out.println("verify contact");
	}
	@Test(priority=3)
	public void product() {
		System.out.println("Navigate to product");
		System.out.println("create product");
		System.out.println("verify product");
	}
}
