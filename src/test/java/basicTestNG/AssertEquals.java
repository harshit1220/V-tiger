package basicTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AssertEquals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ajio.com/");
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		String expectedTitle = "Online Shopping for Women, Men, Kids – Clothing, Footwear | AJIO";
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("Jai shri krishna");
		
		
	}

}
