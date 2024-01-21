package com.traval.qa.test;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import org.testng.annotations.Test;
import com.traval.qa.base.TestBaseGD;
import com.traval.qa.confiq.ConfigureProperties;
import com.traval.qa.confiq.Convertersfiles;
import com.traval.qa.pages.SearchHotels;

public class SearchHotelTest extends TestBaseGD {
	public SearchHotels searchhotels;
	

	public SearchHotelTest() 
	{
		super();
       // The 'super' keyword allows referencing the parent class or superclass of a
	}

//To open the browser and URL
	@BeforeClass
	public void setup() throws Exception {
		initialization1();
		searchhotels = new SearchHotels();
		implicitewait();
	}

//To verify the Title and Accept Policy
	@Test(priority = 1)
	public void Validate_HomePage_Title() throws Exception 
	{
		String Title = searchhotels.ValidateHomeTitle();
		Assert.assertEquals(Title, "GoDo Travel - Get up to 30% cash back after you check out");
		searchhotels.acceptpolicy();
		searchhotels.policybuttonclick();
		System.out.println(Title);
	}

//To validate by adding requirement and store the entered details
	@Test(priority = 2)
	public void ValidataBy_AddingRequirment_InHomePage() throws Exception
	{
        searchhotels.AddingRequirment(ConfigureProperties.Location);
        implicitewait();
        
        
        searchhotels.HomePageserchClick();
        
		implicitewait();
	}

//This is created to load listing page
	//This is to verify the HomePage Details and Search Page Details
	@Test(priority = 3)
	public void Validateby_Requirments_Matchingin_ListingPage_FromHomePage() throws Exception
	{
		implicitewait();
		searchhotels.ListingPagesDetails();
		//Matching Location,Date,Adult and Child
	    //Assert.assertSame(searchhotels.HomePageLocation, searchhotels.SearchpageLocation,"Location not  Match");
		Assert.assertEquals(searchhotels.HomePageDate, searchhotels.SearchpageDate,"Date are not match");
		Assert.assertEquals(searchhotels.HomePageAdultcount, searchhotels.SearchpageAdults,"Adult count are not match");
		Assert.assertEquals(searchhotels.HomePageChildcount, searchhotels.SearchpageChild,"Child count are not match");
		//After verify then click on hotel
		searchhotels.Clickhotel();
	}
//To verify and Edit the details in Listing Page
	@Test(priority = 4)
	public void Edit_Requirments_InListingPage() throws Exception
	{
		implicitewait();
		searchhotels.ListingPagesDetails();
		//Matching Location,Date,Adult and Child
	    //Assert.assertSame(searchhotels.HomePageLocation, searchhotels.SearchpageLocation,"Location not  Match");
		Assert.assertEquals(searchhotels.HomePageDate, searchhotels.SearchpageDate,"Date are not match");
		searchhotels.EditListingPagesDate();
		
		Assert.assertEquals(searchhotels.HomePageAdultcount, searchhotels.SearchpageAdults,"Adult count are not match");
		searchhotels.EditListingPagesAdult();
		
		Assert.assertEquals(searchhotels.HomePageChildcount, searchhotels.SearchpageChild,"Child count are not match");
		searchhotels.EditListingPagesChild();
		
		//After Edit and click on search
		searchhotels.ClickOnSearchListingpage();
		implicitewait();
		
		//After verify then click on hotel
		searchhotels.Clickhotel();
	}
		

//This is to verify the details Match with Home Page and Hotel Page
	 @Test(priority = 5)
		public void Validate_Hotelpage_bycheckingrequirment_FromHomePage() throws Exception
	 {
		implicitewait();
		searchhotels.checkrequirmentmatchinhotelPage();
		Assert.assertEquals(searchhotels.HomePageDate, searchhotels.HotelpageDatedate,"Date are not match");
		Assert.assertEquals(searchhotels.HomePageAdultcount, searchhotels.HotelPageadult,"Adult count are not match");
		Assert.assertEquals(searchhotels.HomePageChildcount, searchhotels.HotelPagechild,"Child count are not match");
		
	   //After verify then click on booking
	    searchhotels.Bookhotel();
	 }
	
	
// This is to verify requirement match SearchPage Details and Hotel Page Details or not in book page
    @Test(priority = 6)
	public void Validate_Hotelpage_bycheckingrequirment_FromListingPage() throws Exception {
		implicitewait();
		
        searchhotels.checkrequirmentmatchinhotelPage();
        Assert.assertEquals(searchhotels.SearchpageDate, searchhotels.HotelpageDatedate,"Date are not match");
		Assert.assertEquals(searchhotels.SearchpageChild, searchhotels.HotelPagechild,"Child count are not match");
		Assert.assertEquals(searchhotels.SearchpageAdults, searchhotels.HotelPageadult,"Adult count are not match");
        Assert.assertEquals(searchhotels.SelectedHotelNameInSearchPage, searchhotels.SelectedHotelNameHotelPage,"Hotel Names are not match");
		//After verify then click on booking
        searchhotels.Bookhotel();
       
	}
 // This is to verify requirement match Edited SearchPage Details and Hotel Page Details or not in book page
    @Test(priority = 7)
	public void Validate_Hotelpageby_checkingrequirment_From_EditedListingPage() throws Exception {
		implicitewait();
		
        searchhotels.checkrequirmentmatchinhotelPage();
        Assert.assertEquals(searchhotels.EditSearchpageDate, searchhotels.HotelpageDatedate,"Date are not match");
		Assert.assertEquals(searchhotels.EditSearchpageChild, searchhotels.HotelPagechild,"Child count are not match");
		Assert.assertEquals(searchhotels.EditSearchpageAdults, searchhotels.HotelPageadult,"Adult count are not match");
        Assert.assertEquals(searchhotels.SelectedHotelNameInSearchPage, searchhotels.SelectedHotelNameHotelPage,"Hotel Names are not match");
		//After verify then click on booking
        searchhotels.Bookhotel();
       
	}
       
    
// This is to verify by adding personal details and check the requirement in checkout Page
   @Test(priority = 8)
	public void Byadding_Detailsand_ItineraryPageandConfirm() throws Exception {
		implicitewait();
		searchhotels.FinaliBookingAddingDetails();
		searchhotels.FinalBookingClick();
	}
 //This is to verify the successful Massage
   @Test(priority = 9)
   public void SucessFul_MassageConfirmation() 
   {
	   
	   searchhotels.SucessMassageTitle();
	   Assert.assertEquals(searchhotels.SuceesMassage, "Success! Booking has been completed");
   }
   @AfterClass
   public void Teardown() 
   {
	   driver.quit();
	   
   }

}
