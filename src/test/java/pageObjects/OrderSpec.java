package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import abstractComponents.AbstractComp;

public class OrderSpec extends AbstractComp
{
	WebDriver driver;
	
	
	public OrderSpec(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//select[@name='quantity']")
	WebElement QuantityDropdown;
	
	@FindBy(id="add-to-cart-button")
	WebElement AddToCartButton;
	
	By AlertOverlay = By.id("attachSiNoCoverage-announce");
	
	By ProceedButtonVisiblity = By.xpath("//input[@name='proceedToRetailCheckout']");
	
	
	@FindBy(xpath="//input[@name='proceedToRetailCheckout']")
	WebElement CartButton;

	//Creds Data:
	@FindBy(xpath="//input[@type='email']")
	WebElement userEmail;
	
	@FindBy(id="continue")
	WebElement continueButton;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement userPass;
	
	@FindBy(id="signInSubmit")
	WebElement signInButton;
	
	
	public void QuantitySelect(String two)
	{
		WebElement quantity = QuantityDropdown;
		Select q = new Select(quantity);
		q.selectByVisibleText(two);
	}
	
	public void Carts(String email, String password) 
	{
		AddToCartButton.click();
		waitForElementToAppear(AlertOverlay);
		
		Actions actions = new Actions(driver);
		WebElement element = driver.findElement(AlertOverlay);
	    actions.moveToElement(element).click().build().perform();
	    waitForElementToAppear(ProceedButtonVisiblity);   
		CartButton.click();
		
		//Creds ActionItems:
		
		userEmail.sendKeys(email);
		continueButton.click();
		userPass.sendKeys(password);
		signInButton.click();
		
	}
	
		
		
	
			
	
}
