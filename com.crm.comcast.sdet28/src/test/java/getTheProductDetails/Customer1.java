package getTheProductDetails;

import org.testng.annotations.Test;

public class Customer1 {
	@Test(groups={"smoketest"})
	public void customerTest1() {
		System.out.println("This is smoke");
	}
	@Test(groups= {"smoketest"})
	public void customerTest2() {
		System.out.println("This is smoke");
	}
	@Test(groups= {"regrrssiontest"})
	public void customerTest3() {
		System.out.println("This is Regression");
}
	@Test()
	public void customerTest4() {
		System.out.println("This is Regression");
	}
	
}
