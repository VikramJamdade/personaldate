package com.traval.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.traval.qa.base.TestBaseGD;

public class SelectHotel extends TestBaseGD
{

	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    By elementLocator = By.id("bookButton1");
    WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
   
}
