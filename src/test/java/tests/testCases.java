package tests;
import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ProductSearch;

import pageObjects.OrderSpec;


public class testCases extends BaseClass
{
	
	ProductSearch ps;
	OrderSpec ps1;

	
	@Test
	public void goTo()
	{
		driver.get(baseURL);
		log.info("Successfully Browser Opened !");	
	}
	
	@Test
	public void searchProducts()
	{
		
		ps=new ProductSearch(driver);
		ps.prodSearchBox(searchItem);
		log.info("Successfully Inputted Search Keyword !");

	}
	
	@Test
	public void selectProduct()
	{
		ps=new ProductSearch(driver);
		ps.suggestionList(myItem);
		ps.ourPreference();
		log.info("Successfully Selected Expected Option !");
	}
	
	@Test
	public void selectQuantity()
	{
		ps1=new OrderSpec(driver);
		ps1.QuantitySelect("2");
		ps1.Carts(emailKey, passwordKey);
		log.info("Successfully Inputted Email & Password !");
	}
	
}

