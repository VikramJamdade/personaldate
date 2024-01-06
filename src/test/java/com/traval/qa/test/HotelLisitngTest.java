package com.traval.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.traval.qa.base.TestBaseGD;
import com.traval.qa.pages.Hotellisting;
import com.traval.qa.pages.SearchHotels;
import com.traval.qa.pages.SelectHotel;

public class HotelLisitngTest extends TestBaseGD 
{
	Hotellisting hotellisting;
	SearchHotels searchhotels;
	SelectHotel selecthotel;
	
	public HotelLisitngTest() 
	{
		super();
		//The 'super' keyword allows referencing the parent class or superclass of a subclass in Java.i.e TestBaseGD
	}
	
	@BeforeMethod
	public void setup() throws Exception 
	{
		initialization1();
		searchhotels = new SearchHotels();
		searchhotels.AddingRequirment(("Paris, France"));
		implicitewait(); 
	}
	@Test(priority=3)
	public void ValidateHomePageTitle() throws Exception 
	{
		String Title=searchhotels.ValidateHomeTitle();
		Assert.assertEquals(Title,"Disneyland Paris -Marne La Val, FR - GoDo Travel");
		implicitewait();
		 
		//Assertions state confidently that application behavior is working as expected.
	}
	
	@Test(priority=4)
	public SelectHotel selecthoteltest() throws Exception 
	{
		hotellisting = new Hotellisting();
		selecthotel= hotellisting.ClickonHotel();
		return new SelectHotel();
		
		
	}
	
	@AfterMethod
	public void tearDown() 
	{
		driver.quit();
	}
	
}
