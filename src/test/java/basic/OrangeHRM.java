package basic;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRM {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver =  new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		//driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys("Admin");
		//driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("admin123");
		//driver.findElement(By.xpath("//button[text()=' Login ']")).click();
		
		//i)	Create an object of FileInputStream Class and in field input pass the path of external file
		FileInputStream file = new FileInputStream("src\\test\\resources\\data.properties");
		//ii)	Create an object of properties class
		Properties p = new Properties();
		//iii)	Call load(input stream) method to reach the location of your property file 
		p.load(file);
		//iv)	Call a method getPropery(String key)and store in a variable 
		String username = p.getProperty("Username");
		String password = p.getProperty("Password");
		
		driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys(username);
		driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys(password);
	}

}
