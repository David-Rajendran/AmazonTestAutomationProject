package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import abstractComponents.AbstractComp;

public class ProductSearch extends AbstractComp {
	WebDriver driver;
	
	public ProductSearch(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="twotabsearchtextbox")
	WebElement SearchBox;
	
	By SuggestedOptions = By.xpath("//div[@class='s-suggestion-container']");
	
	@FindBy(xpath="//div[@class='s-suggestion-container']")
	List<WebElement> products;
	
	By AmazonsChoiceVisibility = By.xpath("//span[text()='Choice']");
	
	@FindBy(xpath="//span[text()='Choice']")
	WebElement AmazonsChoice;
	
	public void prodSearchBox(String Item) 
	{
		SearchBox.sendKeys(Item);
	}
	
	public void suggestionList(String prodName) 
	{
		waitForElementToAppear(SuggestedOptions);
		WebElement option = products.stream().filter(product->
		product.findElement(By.cssSelector("div")).getText().equals(prodName)).findFirst().orElse(null);
		option.click();	
		
	}
	
	public void ourPreference() 
	{
		
		waitForElementToAppear(AmazonsChoiceVisibility);
		AmazonsChoice.click();
	}

}