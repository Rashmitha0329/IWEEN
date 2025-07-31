package com.iween.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.iween.utilities.ScreenshotUtil;

public class resultPage extends BasePage{

	 public resultPage(WebDriver driver) {
	        super(driver);// calls BasePage constructor
	    }
	    
	 @FindBy(xpath="//*[contains(@class,'one-way-new-result-card')]")
	 WebElement resultFlightCard;
	 @FindBy(xpath="//*[@name='carrier']")
	 List<WebElement> flightNames;
	
	 public void validateResultPageIsDisplayed(ExtentTest test)
	 {
		 if(resultFlightCard.isDisplayed())
			{
				 System.out.println("Search page is getting displayed successfully.");
				  test.log(Status.PASS, "Search page is getting displayed successfully.");
	        } else {
	            System.out.println("Failed to load the Search Page: Element found but not visible.");
	            test.log(Status.FAIL, "Failed to load the Search Page: Element not visible.");
	           ScreenshotUtil.captureAndAttachScreenshot1(driver, test, Status.FAIL, "Search page element not visible", "SearchPageNotVisible");
	         //   test.log(Status.INFO, "Home page element not visible ,HomePageNotVisible");
	            Assert.fail();
			} 
	 }
	 
	 
}
