package basicTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AssertTrueAndFalse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ajio.com/");
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		WebElement searchtf = driver.findElement(By.name("searchVal"));
		
		//TrueCondition the output will pass-------searchtf is enabled
		//FalseCondition the output will fail------searhtf is selected
		Assert.assertTrue(searchtf.isEnabled());
		
		//Assert.assertTrue(searchtf.isSelected());	//FALSE CONDITION
		System.out.println("Good morning");
		
		//TrueCondition the output will fail-------searchtf is enabled
				//FalseCondition the output will pass	------searhtf is selected
		
		Assert.assertFalse(searchtf.isSelected());	//False CONDITION BUT IT WILL WORK COZ IT'S assertFalse
		System.out.println("GoodNight");
	}

}
