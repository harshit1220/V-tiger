package basicTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test2 {
@Test
public void Ajio() {
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.ajio.com/");
	String actualUrl = driver.getCurrentUrl();
	System.out.println(actualUrl);
	
	String expectedUrl = "https://www.ajio.com/";
	Assert.assertEquals(actualUrl, expectedUrl);
	System.out.println("Jai shri ram");
}
}
