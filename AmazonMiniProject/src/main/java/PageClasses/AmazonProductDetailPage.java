package PageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonProductDetailPage {
	WebDriver driver;
	
	By AddToCartButton = By.xpath("(//input[@id = 'add-to-cart-button'])[2]");   // page object model - web element finding
	
	public AmazonProductDetailPage(WebDriver driver) {
		this.driver = driver;    // no need of pagefactory.init code in page object model	
	}

	public WebElement AddToCartButton() {
		return(driver.findElement(AddToCartButton));         // return method
	}	
}
