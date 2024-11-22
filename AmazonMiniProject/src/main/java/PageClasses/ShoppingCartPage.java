package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//span[@id='nav-cart-count']")
	WebElement shoppingcartpagecartbuttoncount; 
		
	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement shoppingCartPagecartBtnCount() {
		return shoppingcartpagecartbuttoncount;
	}	
}
