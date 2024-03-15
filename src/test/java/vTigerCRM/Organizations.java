package vTigerCRM;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import commonUtils.ExcelUtil;
import commonUtils.JavaUtil;
import commonUtils.PropertyFileUtil;
import commonUtils.WebDriverUtil;

public class Organizations {
	
	public static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		PropertyFileUtil putil = new PropertyFileUtil();
		JavaUtil jUtil = new JavaUtil();
		ExcelUtil eutil = new ExcelUtil();
		WebDriverUtil wutil = new WebDriverUtil();
		
		//TO read data from property file
		String browser=putil.getDataFromPropertyFile("Browser");
		String url=putil.getDataFromPropertyFile("Url");
		String username=putil.getDataFromPropertyFile("Username");
		String password=putil.getDataFromPropertyFile("Password");
		
		//To read data from excel file
				String orgName = eutil.getDataFromExcelFile("Organizations", 1, 1);
				String group = eutil.getDataFromExcelFile("Organizations", 2, 1);
		
		//TO LAUNCH THE BROWSER
		if(browser.equals("Chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser.equals("Edge")) {
			driver = new EdgeDriver();
		}
		else {
			driver = new FirefoxDriver();
		}
		//TO maxamize
		wutil.maximize(driver);
		//To apply implicit wait
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wutil.implicitWait(driver);
		//To launch application
		driver.get(url);
		//Login to application
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		//TO click on organization
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();
		
		
		
		
		driver.findElement(By.name("accountname")).sendKeys(orgName+jUtil.getRandomNumber());
		driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
		driver.findElement(By.name("assigned_group_id")).click();
		
		//Select the dropdown
		
		WebElement dropdown = driver.findElement(By.name("assigned_group_id"));
//		Select s = new Select(dropdown);
//		s.selectByVisibleText(group);
		wutil.handleDropdown(dropdown, group);
		
		//driver.findElement(By.xpath("//option[text()='Support Group']")).click();
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		Thread.sleep(2000);
		
		WebElement account = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		//Perform actions mouseHover
		wutil.mouseHover(driver, account);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}

}
