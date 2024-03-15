package commonUtils;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtil {
	
	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void implicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	public void handleDropdown(WebElement targetedDropdown, String targetedOptions) {
		Select s = new Select(targetedDropdown);
		s.selectByVisibleText(targetedOptions);
	}
	
	public void mouseHover(WebDriver driver,WebElement targeted) {
		Actions a = new Actions(driver);
		a.moveToElement(targeted);
		a.perform();
	}
	
	public void switchWindow(WebDriver driver, String expectedUrl) {
		//check how many window are present
		Set<String> tabs = driver.getWindowHandles();
		
		
		//TO transfer the control from one window to another window
		for(String allWindows : tabs) {
			String pageTitle = driver.switchTo().window(allWindows).getCurrentUrl();
			if(tabs.contains(expectedUrl)) {
				break;
			}
		}
	}
	

}
