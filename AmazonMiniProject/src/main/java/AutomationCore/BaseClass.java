package AutomationCore;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	
	public WebDriver driver;    
	
	public WebDriver browserinitailzation(String browserName) throws Exception 
	{
		if(browserName.equalsIgnoreCase("Chrome"))  
		{
			driver = new ChromeDriver();			
		}
		else if(browserName.equalsIgnoreCase("Firefox")) 
		{
			driver = new FirefoxDriver();			
		}
		else if(browserName.equalsIgnoreCase("Edge")) 
		{
			driver = new EdgeDriver();			
		}
		else 
		{
			throw new Exception("Invalid Browser Name Exception!!");
		}
							
		return driver;   	
	}
}
