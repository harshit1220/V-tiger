package basicTestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDependsMethod {
	@Test
	public void signUp() {
		System.out.println("SignUp");
	}
	@Test
	public void signIn() {
		System.out.println("signIn");
		Assert.assertEquals("Pune", "deccan");
	}
	@Test(dependsOnMethods = "signIn")
	public void signOut() {
		System.out.println("SignOut");
	}
}
