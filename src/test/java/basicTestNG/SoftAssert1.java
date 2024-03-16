package basicTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssert1 {
	@Test
	public void Ajio(){
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ajio.com/");
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		String expectedTitle = "Online Shopping for Women, Men, Kids – Clothing, Footwear | AJIO";
		
		SoftAssert s = new SoftAssert();
		s.assertEquals(actualTitle, expectedTitle);
		System.out.println("Jai shri krishna");
		
		
		
		
	}
	
}
