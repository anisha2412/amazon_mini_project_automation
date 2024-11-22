package PageClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonProductListingPage {
	WebDriver driver;
	
	@FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal']")         // elements locating
	List<WebElement>  products;        // convert to a list to store all elements in product list.
	
	@FindBy(xpath = "(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")
	WebElement firstProduct;              // firstProduct products finder
	
	@FindBy(xpath = "//span[@id='nav-cart-count']")
	WebElement cartbuttoncount;               // finding cartbtncount in detail page [for add to cart assertion]
	
	public AmazonProductListingPage(WebDriver driver) {          // const.
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> productFinder() {
		return products;
	}
	
	public void clickOn_firstProduct() {       // method to click on 1st prouct on product listing page
		firstProduct.click();
	}
	
	public WebElement cartBtnCount() {
		return cartbuttoncount;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
