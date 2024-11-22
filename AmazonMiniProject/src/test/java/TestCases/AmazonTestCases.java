package TestCases;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import AutomationCore.BaseClass;
import PageClasses.AmazonHomePage;
import PageClasses.AmazonProductDetailPage;
import PageClasses.AmazonProductListingPage;
import PageClasses.ShoppingCartPage;

public class AmazonTestCases extends BaseClass{
	
	WebDriver driver;   
	
	AmazonHomePage homepage;                       //outside class obj declaration
	AmazonProductListingPage productslistingpage;
	AmazonProductDetailPage productdetailpage;
	ShoppingCartPage shoppingcartpage;
		
	@BeforeMethod      	
	@Parameters({"browser"})
	public void initialization(String browsername) throws Exception 
	{
		driver = browserinitailzation(browsername);    	
		
		homepage = new AmazonHomePage(driver);		             // obj initailization only after driver initailization
		productslistingpage = new AmazonProductListingPage(driver);	
		productdetailpage = new AmazonProductDetailPage(driver);
		shoppingcartpage =  new ShoppingCartPage(driver);
		
		driver.get("https://www.amazon.in/");        	
		driver.manage().window().maximize();         	
		System.out.println("BeforeMethod");
	}
	
	@Test
	public void tc01() {	
		homepage.AmazonHomePageSearchBox().sendKeys("iphone");
		homepage.ClickOn_AmazonHomePageSearchButton();
		int productCount = productslistingpage.productFinder().size();     //finding product size
		Assert.assertEquals(productCount, 18);                           //verification
	}
	
	
	// test case for add to cart using page object modal
	
	@Test
	public void tc02() {	
		homepage.AmazonHomePageSearchBox().sendKeys("iphone");
		homepage.ClickOn_AmazonHomePageSearchButton();
		productslistingpage.clickOn_firstProduct();
		  		
		//tab switching
		String parentWindow = driver.getWindowHandle();       
		Set<String> childWindow = driver.getWindowHandles();  
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));      // webDriverWait class obj
		for(String actual:childWindow) {                      
			if(!actual.equalsIgnoreCase(parentWindow)) {    
				driver.switchTo().window(actual);				
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,250)");                                       // scroll page												
				wait.until(ExpectedConditions.visibilityOf(productdetailpage.AddToCartButton())); // wait after cart clk 						
				js.executeScript("arguments[0].click()",productdetailpage.AddToCartButton());     // js element cart click 								
			}
		}
		driver.switchTo().window(parentWindow);              
		driver.navigate().refresh(); 
		
		wait.until(ExpectedConditions.visibilityOf(productslistingpage.cartBtnCount()));   //wait for cart btn visibility in product listing page
		productslistingpage.cartBtnCount().click();   // clck cart count to open shopping cart page 
			
		String cartCount = shoppingcartpage.shoppingCartPagecartBtnCount().getText();     // finding cart count in shopping cart page 
		Assert.assertEquals(cartCount, 1);                
	}
		
	@AfterMethod
	public void tearDown() {
		driver.quit();
		System.out.println("AfterMethod");
	}

}
