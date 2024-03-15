package vTigerCRM;

import java.io.IOException;
import java.util.Set;

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

public class Contacts {
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
		
//		//To read data from excel file
//		String nameTitle = eutil.getDataFromExcelFile("Contacts", 1, 1);
			String firstName = eutil.getDataFromExcelFile("Contacts", 1, 1);
				String lastName = eutil.getDataFromExcelFile("Contacts", 2, 1);
				String assigned = eutil.getDataFromExcelFile("Contacts", 3, 1);
//				String org = eutil.getDataFromExcelFile("Contacts", 5, 1);
		
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
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.cssSelector("img[alt='Create Contact...']")).click();
		
		//Select title dropdown
		WebElement title = driver.findElement(By.name("salutationtype"));
//		wutil.handleDropdown(title, nameTitle);
		
		Select s = new Select(title);
		s.selectByValue("Mr.");
		
		//Enter the first name from excel
		driver.findElement(By.name("firstname")).sendKeys(firstName+jUtil.getRandomNumber());
		
		//Enter the last name from excel
		driver.findElement(By.name("lastname")).sendKeys(lastName+jUtil.getRandomNumber());
		
		//click on radio button
		driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		
		//To click on dropdown
		WebElement dropdown = driver.findElement(By.name("assigned_group_id"));
		wutil.handleDropdown(dropdown, assigned);
		
		//Click on + in organization name
		driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
		
		//TO pass the control to child window
		wutil.switchWindow(driver,"http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=");
			
		//Click on search tf and entering the organization name
		driver.findElement(By.name("search_text")).sendKeys("Accenture");
		//Click on search button
		driver.findElement(By.name("search")).click();
		//Click on organization name
		driver.findElement(By.id("1")).click();
		
		wutil.switchWindow(driver, "http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing");
		
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();

		//TO PERFORM LOGOUT
		Thread.sleep(2000);
		WebElement account = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		//Perform actions mouseHover
		wutil.mouseHover(driver, account);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}

}
