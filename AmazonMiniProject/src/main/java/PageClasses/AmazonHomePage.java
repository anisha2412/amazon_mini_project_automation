package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage {
	WebDriver driver;                             // driver obj initalization
	
	@FindBy(id = "twotabsearchtextbox")           // @FindBy() annotation for finding web element instead of findElement
	WebElement AmazonHomePage_SearchBox;          // find and store to a variable
	
	@FindBy(id = "nav-search-submit-button")
	WebElement AmazonHomePage_SearchButton;
				
	public AmazonHomePage(WebDriver driver) {         // parameterized const.
		this.driver = driver;                         // assign webdriver obj  value with value comes from testcase 
		PageFactory.initElements(driver, this);       // mandatory line in page factory
	}

	public WebElement AmazonHomePageSearchBox() {     // method of search box web element to return var.
		return AmazonHomePage_SearchBox;
	}
	
	public void ClickOn_AmazonHomePageSearchButton() {	
		AmazonHomePage_SearchButton.click();           // instead of retrning elmnts, we can also perform actions here.
	}

}
