package com.traval.qa.test;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.traval.qa.base.TestBaseGD;
import com.traval.qa.pages.Hotellisting;
import com.traval.qa.pages.SearchHotels;


public class SearchHotelTest extends TestBaseGD
{
	SearchHotels searchhotels;
	Hotellisting hotellisting;
	
	public SearchHotelTest() 
	{
		super();
		//The 'super' keyword allows referencing the parent class or superclass of a subclass in Java.i.e TestBaseGD
	}
	//To open the browser and URL
	@BeforeMethod
	public void setup() throws Exception 
	{
		initialization1();
		searchhotels = new SearchHotels();
		implicitewait(); 
	}
	//To validate page title
	@Test(priority=1)
	public void ValidateHomePageTitle() throws Exception 
	{
		String Title=searchhotels.ValidateHomeTitle();
		Assert.assertEquals(Title,"GoDo Travel - Get up to 30% cash back after you check out");
		implicitewait();
		 
		//Assertions state confidently that application behavior is working as expected.
	}
	@Test(priority=2)
	public void ValidatabyAddingRequirment() throws Exception 
	{
		hotellisting=searchhotels.AddingRequirment("Paris, France");
		implicitewait();
	}
	
	
	
	@AfterMethod
	public void tearDown() 
	{
		driver.quit();
	}
	
	
	
}
