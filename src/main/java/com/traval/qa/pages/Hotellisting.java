package com.traval.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.traval.qa.base.TestBaseGD;

public class Hotellisting extends TestBaseGD 
{
	
	 //To Wait top listing hotel
		@FindBy(xpath=("//*[@data-rank=\\\"0\\"))
		WebElement BookFirstHotel;
		
		public Hotellisting() 
		{
			
			PageFactory.initElements(driver, this);	
			//he this keyword can be used to refer current class instance variable.
			//Page Factory optimizes test instances created using the page object model (POM).
		}
		
		//Action of page
		
		public String ValidateHomeTitle() 
		{
				return driver.getTitle();
		}
		public SelectHotel ClickonHotel() 
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		    By elementLocator = By.xpath("BookFirstHotel");
		    WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
		    element.click();
		    
			return new SelectHotel();
		}
		
		

}
