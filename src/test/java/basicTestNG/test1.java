package basicTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class test1 {

	@Test(priority=0)
	public void flipkart() {
		WebDriver driver =  new ChromeDriver();
		driver.get("https://www.flipkart.com/");
	}
	
	@Test(priority=1, invocationCount=2)
	
	public void amazon() {
		WebDriver driver =  new EdgeDriver();
		driver.get("https://www.amazon.com/");
	}

}
