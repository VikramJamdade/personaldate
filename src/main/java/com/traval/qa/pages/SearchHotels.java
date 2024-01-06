package com.traval.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.traval.qa.base.TestBaseGD;

public class SearchHotels extends TestBaseGD
{
    //To Enter Address
	@FindBy(xpath=("//input[@id='cityTypeAhead']"))
	WebElement EnterAddress;
	
	//To Enter searched result address
	@FindBy(xpath=("//div[@id='suggestResult1']"))
	WebElement EntersearchedAddress;
	
	//To open the date calendar
	@FindBy(id=("checkinForm"))
	WebElement EnterDate;
	
	//To Enter first date
	@FindBy(xpath=("//td[@class='available'][normalize-space()='17']"))
	WebElement EnterFirstDate;
	
	//To Enter first date
	@FindBy(xpath=("//td[@class='available'][normalize-space()='18']"))
	WebElement EnterSecondDate;
	
	//To increase first count
	@FindBy(xpath=("//div[@id='numAdultsPlus']//i[@role='presentation']"))
	WebElement PlusChildcount;
	
	//Click on search
	@FindBy(xpath=("//span[@id='searchButtonText']"))
	WebElement SearchBtn;
	
	
	public SearchHotels() 
	{
		
		PageFactory.initElements(driver, this);	
		//he this keyword can be used to refer current class instance variable.
		//Page Factory optimizes test instances created using the page object model (POM).
	}
	
	//Actions on page
	public String ValidateHomeTitle() 
	{
			return driver.getTitle();
	}
	public Hotellisting AddingRequirment(String ad) throws Exception 
	{
		EnterAddress.sendKeys(ad);
		Thread.sleep(2000);
		EntersearchedAddress.click();
		
		String Enteredtitle= driver.findElement(By.xpath("//input[@id='cityTypeAhead']")).getAttribute("value");
		 System.out.println("Entered Location" +"="+ Enteredtitle);
		EnterDate.click();
		Thread.sleep(2000);
		EnterFirstDate.click();
		EnterSecondDate.click();
		Thread.sleep(1000);
		
		String EnteredDate= driver.findElement(By.xpath("//input[@id='checkinForm']")).getAttribute("value");
		 System.out.println("Entered Date" +"="+ EnteredDate);
		
		 
		 PlusChildcount.click();
		 Thread.sleep(1000);
		 WebElement textElementadult = driver.findElement(By.xpath("//div[@id='numAdultsDisplay']"));
	     String textOnFirstPageAdult =	textElementadult.getText();
	     System.out.println("Adults count "+"="+ textOnFirstPageAdult);
		 
		SearchBtn.click();
		
		
		return new Hotellisting();
	}
	
		
	}
		
		
	

