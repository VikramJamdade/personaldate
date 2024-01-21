package com.traval.qa.pages;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.traval.qa.base.TestBaseGD;
import com.traval.qa.confiq.ConfigureProperties;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
public class SearchHotels extends TestBaseGD 
{
	public String HomePageDate;
	public String HomePageLocation;
	public String HomePageAdultcount;
	public String HomePageChildcount;

	public String SearchpageChild;
	public String SearchpageDate;
	public String SearchpageAdults;
	public String SearchpageLocation;
	
	public String EditSearchpageChild;
	public String EditSearchpageDate;
	public String EditSearchpageAdults;
	public String EditSearchpageLocation;
	public String SelectedHotelNameInSearchPage;
	
	public String HotelPageadult;
	public String HotelPagechild;
	public String HotelpageDatedate;
	public String HotelpageLocation;
	public String SelectedHotelNameHotelPage;
	
	public String EditHotelPageadult;
	public String EditHotelPagechild;
	public String EditHotelpageDatedate;
	public String EditHotelpageLocation;
	public String EditChilpageAgeSecond;
	

	public String CheckoutPageadult;
	public String CheckoutPagechild;
	public String CheckoutpageDatedate;
	public String CheckoutpageLocation;
	
	public String SuceesMassage;

	@FindBy(xpath = ("//div[@class='cky-consent-bar']"))
	WebElement policy;

	@FindBy(xpath = ("//button[@data-cky-tag=\"accept-button\"]"))
	WebElement Acceptpolicybutton;

	// To Enter Address
	@FindBy(xpath = ("//input[@id='cityTypeAhead']"))
	
	WebElement EnterAddress;

//To Enter searched result address
	@FindBy(xpath = ("//div[@id='suggestResult1']"))
	WebElement EntersearcheResult;

//To open the date calendar
	@FindBy(id = ("checkinForm"))
	WebElement EnterDate;

//To Enter first date
	@FindBy(xpath = ("//td[@class='available'][normalize-space()='17']"))
	WebElement EnterFirstDate;

//To Enter first date
	@FindBy(xpath = ("//td[@class='available'][normalize-space()='18']"))
	WebElement EnterSecondDate;

//To increase Adult first count
	@FindBy(xpath = ("//div[@id='numAdultsPlus']//i[@role='presentation']"))
	WebElement PlusAdultcount;

//To increase Child count
	@FindBy(xpath = ("//div[@id='numChildrenPlus']//i[@role='presentation']"))
	WebElement PlusChildcount;

//Click on search in home page
	@FindBy(xpath = ("//span[@id='searchButtonText']"))
	WebElement SearchBtn;

//Click on search in listing page
	@FindBy(xpath=("//div[@id='searchButtonText']"))
	WebElement SearchBtninListing;
		
	
//Click book first hotel in searched
	@FindBy(xpath = ("//*[@data-rank=\"0\"]"))
    WebElement ClickFirstHotel;

//click on book
	@FindBy(xpath = ("//*[@id=\"bookButton1\"]"))
	WebElement BookFirstHotel;

//Personal Details fields
	@FindBy(xpath = ("//input[@id='firstName']"))
	WebElement FirstName;

	@FindBy(xpath = ("//input[@id='lastName']"))
	WebElement LastName;

	@FindBy(xpath = ("//input[@id='phoneNumber']"))
	WebElement PhoneNumber;

	@FindBy(xpath = ("//input[@id='emailAddress']"))
	WebElement EmailAddress;

//payment page details
	@FindBy(xpath = ("//input[@id='firstNamePayment']"))
	WebElement FirstNamePayment;

	@FindBy(xpath = ("//input[@id='creditCardNumber']"))
	WebElement CreditCardNumber;

	@FindBy(xpath = ("//input[@id='expirationMonth']"))
	WebElement ExpirationMonth;

	@FindBy(xpath = ("//input[@id='expirationYear']"))
	WebElement ExpirationYear;

	@FindBy(xpath = ("//input[@id='securityCode']"))
	WebElement SecurityCode;

//For  billing address details	
	@FindBy(id = ("countrySelect"))
	WebElement countrySelect;
//countrySelect countrySelectfromlist BillingAddress1	billingAddress2 billingCity provinceSelect provinceSelectfromlist PostalCode FinalBookingButton
	@FindBy(xpath = ("//*[@id=\"countrySelect\"]/option[2]"))
	WebElement countrySelectfromlist;

	@FindBy(id = ("billingAddress1"))
	WebElement BillingAddress1;

	@FindBy(id = ("billingAddress2"))
	WebElement billingAddress2;

	@FindBy(id = ("billingCity"))
	WebElement billingCity;

	@FindBy(id = ("provinceSelect"))
	WebElement provinceSelect;

	@FindBy(xpath = ("//*[@id=\"provinceSelect\"]/option[3]"))
	WebElement provinceSelectfromlist;

	@FindBy(id = ("postalCode"))
	WebElement PostalCode;

	@FindBy(xpath = ("//*[@id=\"bookbutton\"]"))
	WebElement FinalBookingButton;

	public SearchHotels() {

		PageFactory.initElements(driver, this);
		// he this keyword can be used to refer current class instance variable.
		
	}

	// Actions on page
	public String ValidateHomeTitle() throws Exception

	{

		return driver.getTitle();
	}

	public void acceptpolicy() 
	{
		// https://www.seleniumeasy.com/selenium-tutorials/waits-and-timeout-selenium-4
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait for an element to be present and visible
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='cky-consent-bar']")));
	}
	
	public void policybuttonclick()
	{
		Acceptpolicybutton.click();
	}


	public void AddingRequirment(String ad) throws Exception 
	{
		// Enter the address and store
		EnterAddress.sendKeys(ad);
		Thread.sleep(2000);
		EntersearcheResult.click();
		Thread.sleep(1000);
		//driver.navigate().refresh();

		HomePageLocation = EnterAddress.getAttribute("value");
		
 		System.out.println("Entered Location" + "=" + HomePageLocation);
		

		// Enter the date and store
		EnterDate.click();
		Thread.sleep(1000);
		EnterFirstDate.click();
		EnterSecondDate.click();
		Thread.sleep(1000);
		String HomepageCheckIn= driver.findElement(By.xpath("//input[@id='checkinForm2']")).getAttribute("value");
		System.out.println("Entered Date" + "=" + HomepageCheckIn);
		String HomepageCheckout = driver.findElement(By.xpath("//input[@id='checkoutForm2']")).getAttribute("value");
		System.out.println("Entered Date" + "=" + HomepageCheckout);
		
		 

		// Add the adult count and get text
		PlusAdultcount.click();
		Thread.sleep(500);
		WebElement textElementadult = driver.findElement(By.xpath("//div[@id='numAdultsDisplay']"));
		HomePageAdultcount = textElementadult.getText();
		System.out.println("Entered Adults count " + "=" + HomePageAdultcount);

		// Add the child count and get text
		PlusChildcount.click();
		Thread.sleep(500);
		WebElement textElementChild = driver.findElement(By.xpath("//div[@id='numChildrenDisplay']"));
		HomePageChildcount = textElementChild.getText();
		System.out.println("Entered Child count " + "=" + HomePageChildcount);
	}
	
	
     public void HomePageserchClick() 
     {
    	
		// After filling click on search
		SearchBtn.click();
	 }

// This is for listing page only
    public void ListingPagesDetails() throws Exception
                 
	{

		Thread.sleep(2000);
		// StoreLocation
		SearchpageLocation = driver.findElement(By.xpath("//input[@id='cityTypeAhead']")).getAttribute("value");
		System.out.println("Search Page location " +"="+ SearchpageLocation);
		Thread.sleep(500);
		// Storedate
		SearchpageDate = driver.findElement(By.xpath("(//input[@id='checkinInput'])[1]")).getAttribute("value");
		System.out.println("Search page date" +"="+SearchpageDate);
		Thread.sleep(500);
		// storeadult
		SearchpageAdults = driver.findElement(By.xpath("//div[@id='numAdultsDisplay']")).getText();
		System.out.println("Search page Adult" +"="+SearchpageAdults);
		Thread.sleep(500);
		// Storechild
		SearchpageChild = driver.findElement(By.xpath("//div[@id='numChildrenDisplay']")).getText();
		System.out.println("Search page Child" +"="+SearchpageChild);
	}
	
	public void EditListingPagesLocation() throws Exception
	{
		driver.findElement(By.xpath("//input[@id='cityTypeAhead']")).clear();
		driver.findElement(By.xpath("//input[@id='cityTypeAhead']")).sendKeys("Alaska");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='suggestResult2']")).click();
		EditSearchpageLocation= driver.findElement(By.xpath("//input[@id='cityTypeAhead']")).getAttribute("value");		
	}
	public void EditListingPagesDate() throws Exception
	{
		driver.findElement(By.id("checkinInput")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//td[@class='available'][normalize-space()='24']")).click();
		driver.findElement(By.xpath("//td[@class='available'][normalize-space()='25']")).click();
		Thread.sleep(1000);
		EditSearchpageDate= driver.findElement(By.id("checkinInput")).getAttribute("value");		
	}
	public void EditListingPagesAdult() throws Exception
	{
		driver.findElement(By.xpath("//div[@id='numAdultsMinus']//i[@class='bi bi-dash-square']")).click();
		Thread.sleep(1000);
		EditSearchpageAdults= driver.findElement(By.xpath("//div[@id='numAdultsDisplay']")).getText();		
	}
	public void EditListingPagesChild() throws Exception
	{
		driver.findElement(By.xpath("//div[@id='numChildrenPlus']//i[@class='bi bi-plus-square']")).click();
		Thread.sleep(1000);
		EditSearchpageChild= driver.findElement(By.xpath("//div[@id='numChildrenDisplay']")).getText();
		WebElement Age=driver.findElement(By.xpath("//select[@id='childAge2']"));
		Age.click();
		Age.sendKeys(Keys.ARROW_DOWN);
		Age.sendKeys(Keys.ENTER);
		EditChilpageAgeSecond= driver.findElement(By.xpath("//select[@id='childAge2']")).getAttribute("value");
		
	}
	//After Edit Click on the Search to refresh
	public void ClickOnSearchListingpage() 
	{
		SearchBtninListing.click();
	}
	
	//Click on First Search Hotel
	public void Clickhotel()
	{
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
		// Wait for an element to be present and invisible
		WebElement loadingImage = driver.findElement(By.xpath("(//img[@alt='loading image'])[1]"));
		wait1.until(ExpectedConditions.invisibilityOf(loadingImage));
		//Store Hotel Name-
		SelectedHotelNameInSearchPage=driver.findElement(By.className("srHotelName")).getText();
		System.out.println("Selected Hotel Is"+"="+SelectedHotelNameInSearchPage);
		
		ClickFirstHotel.click();
	}

// This is for Hotel page page only
	public void checkrequirmentmatchinhotelPage() throws Exception

	{
		/*
		 * public String HotelPageadult; public String HotelPagechild; public String
		 * HotelpageDatedate; public String HotelpageLocation; public String
		 * SelectedHotelNameHotelPage;
		 */
		implicitewait();
		WebDriverWait wait21 = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait21.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt=\"Primary image\"]")));
		Thread.sleep(500);
		Thread.sleep(500);
		// StoreDate
		HotelpageDatedate = driver.findElement(By.xpath("//*[@id=\"travelDates\"]")).getAttribute("value");
		System.out.println("Output Date on Hotel book page" + "=" + HotelpageDatedate);
		
		Thread.sleep(500);
		// StoreAdult
		HotelPageadult = driver.findElement(By.xpath("//div[@id='numAdultsDisplay']")).getText();
		System.out.println("Output Adult on Hotel book page" + "=" + HotelPageadult);
		Thread.sleep(500);
		// StoreChil HotelPagechild=
		HotelPagechild=driver.findElement(By.xpath("//div[@id='numChildrenDisplay']")).getText();
		System.out.println("Output page hotel count " + "=" + HotelPagechild);
		
		
		//To Store the Hotel Name-
		SelectedHotelNameHotelPage=driver.findElement(By.cssSelector("div[id='sticyHeaderHotelHeadline'] h1")).getText();
		System.out.println("Hotel Page Name is" +"="+SelectedHotelNameHotelPage );
		implicitewait();
		// Wait for an element to be present and visible
		
		Thread.sleep(500);
	}
		
//Click on Book Hotel		
	public void Bookhotel() 
	{
		BookFirstHotel.click();
	}
		
//To verify requirement Match or not in checkout page
	public void CheckingRequirmentInCheckoutPage() 
	{
		WebElement Check_In= driver.findElement(By.cssSelector(".float-left.bookingDetailData.mr-3"));
		Check_In.getText();
		
		
		
	}
	
		
		

//Fill the Details and Final Booking	
	public void FinaliBookingAddingDetails() throws Exception
	{
		Thread.sleep(1000);
		FirstName.sendKeys(ConfigureProperties.firstName1);
		LastName.sendKeys(ConfigureProperties.LastName1);
		PhoneNumber.sendKeys(ConfigureProperties.Phone_Number1);
		EmailAddress.sendKeys(ConfigureProperties.EmailID1);
		FirstNamePayment.sendKeys(ConfigureProperties.firstName1);
		CreditCardNumber.sendKeys(ConfigureProperties.Credit_Card_Number1);
		ExpirationMonth.sendKeys(ConfigureProperties.Month1);
		ExpirationYear.sendKeys(ConfigureProperties.Year1);
		SecurityCode.sendKeys(ConfigureProperties.Security_Code1);
		countrySelect.click();
		countrySelectfromlist.click();
		BillingAddress1.sendKeys(ConfigureProperties.Address_11);
		billingAddress2.sendKeys(ConfigureProperties.Address_22);
		billingCity.sendKeys(ConfigureProperties.City1);
		provinceSelect.click();
		provinceSelect.sendKeys(Keys.ARROW_DOWN);
		provinceSelect.sendKeys(Keys.ENTER);
		PostalCode.sendKeys(ConfigureProperties.Postal_Code1);
	}
	
		public void FinalBookingClick() {
		FinalBookingButton.click();

	}
		public void SucessMassageTitle() 
		{
			SuceesMassage=driver.findElement(By.cssSelector("div[class='alert alert-success m-0']")).getText();
			System.out.println(SuceesMassage);
			
		}

}
