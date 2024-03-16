package basicTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestAnotation {
	@Test
	public void vTiger() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://localhost:8888/");
	}
	@BeforeSuite
	public void BS() {
		System.out.println("Before Suit");
	}
	@AfterSuite
	public void AS() {
		System.out.println("After Suit");
	}
	@BeforeClass
	public void BC() {
		System.out.println("Before CLass");
	}
	@AfterClass
	public void AC() {
		System.out.println("After CLass");
	}
	@BeforeMethod
	public void BM() {
		System.out.println("Before Method");
	}
	@AfterClass
	public void AM() {
		System.out.println("Before Method");
	}
	
	
}
