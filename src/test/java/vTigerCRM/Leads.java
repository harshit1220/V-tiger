package vTigerCRM;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import commonUtils.ExcelUtil;
import commonUtils.JavaUtil;
import commonUtils.PropertyFileUtil;
import commonUtils.WebDriverUtil;

public class Leads {
	
	public static WebDriver driver;
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		//IMPORTING THE PROPERTY FILES BY CREATING OBJECT
		PropertyFileUtil putil = new PropertyFileUtil();
		JavaUtil jUtil = new JavaUtil();
		WebDriverUtil wutil = new WebDriverUtil();
		ExcelUtil eUtil = new ExcelUtil();
		
		//TO READ DATA FROM PROPERTY FILE
		String browser = putil.getDataFromPropertyFile("Browser");
		String url = putil.getDataFromPropertyFile("Url");
		String username = putil.getDataFromPropertyFile("Username");
		String password = putil.getDataFromPropertyFile("Password");
		
		//TO OPEN THE BROWSER
		if(browser.equals("Chrome")) {
			driver =new ChromeDriver();
		}
		else if(browser.equals("Edge")) {
			driver= new EdgeDriver();
		}
		else {
			driver = new FirefoxDriver();
		}
		//TO MAXIMIZE WINDOW
		wutil.maximize(driver);
		//TO APPLY IMPLICIT WAIT
		wutil.implicitWait(driver);
		//TO OPEN A WEBSITE
		driver.get(url);
		//TO ENTER USERNAME AND PASSWORD AND CLICK SUBMIT BUTTON
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.cssSelector("img[alt='Create Lead...']")).click();
		
		driver.findElement(By.name("firstname")).sendKeys("Aryan");
		driver.findElement(By.name("lastname")).sendKeys("Pidiha");
		driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		WebElement dropdown = driver.findElement(By.name("assigned_group_id"));
		Select sc = new Select(dropdown);
		sc.selectByVisibleText("Team Selling");
		driver.findElement(By.name("company")).sendKeys("Accenture");
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		Thread.sleep(2000);
		WebElement account = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		//Perform actions mouseHover
		wutil.mouseHover(driver, account);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		
		
	}

}
