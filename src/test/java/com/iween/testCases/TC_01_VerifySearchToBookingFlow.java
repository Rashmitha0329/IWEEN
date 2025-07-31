package com.iween.testCases;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.iween.pageObjects.loginPage;
import com.iween.pageObjects.loginPage1;
import com.iween.pageObjects.resultPage;
import com.iween.pageObjects.searchFlightPage;
import com.iween.pageObjects.searchFlightPage1;
import com.iween.testBase.baseClass;
import com.iween.utilities.DataProviders;
import com.iween.utilities.ExtentManager;
import com.iween.utilities.Iween_FutureDates;
import com.iween.utilities.Retry;


public class TC_01_VerifySearchToBookingFlow extends baseClass {
	@Test(dataProvider = "excelData", dataProviderClass = DataProviders.class, retryAnalyzer = Retry.class)

	    public void myTest(Map<String, String> excelTestData) throws Exception {
	        System.out.println("Running test with: " + excelTestData);
    	try {
       System.out.println("******** Starting TestCase1: testLogin ********");
        ExtentTest test = ExtentManager.getTest(); // ✅ Fix: get current test instance from thread
        
      //Method To Get Future Date
        Map<String, Iween_FutureDates.DateResult> dateResults = futureDates.furtherDate();
		Iween_FutureDates.DateResult date2 = dateResults.get("datePlus2");
		String fromMonthYear = date2.month + " " + date2.year;
		
		//Get The Data From Excel
        String departFrom = excelTestData.get("Depart From");
        String goingTo = excelTestData.get("Going To");
		String adultsCounts = excelTestData.get("AdultsCounts");
		String childCount = excelTestData.get("ChildrenCount");
		String infantsCount = excelTestData.get("InfantsCount");
		 String Class = excelTestData.get("Class");
	
        
		test.log(Status.INFO, "Depart From: " + departFrom +",Going To: "+ goingTo);
        test.log(Status.INFO, "AdultsCounts: " + adultsCounts + ", ChildrenCount: " + childCount + ", InfantsCount: " + infantsCount);
	
        //Creating Page objects
        loginPage loginPage = new loginPage(driver);
        searchFlightPage search = new searchFlightPage(driver);
        resultPage resultPage= new resultPage(driver);
        
        //Method to Enter Username and Password
        loginPage.UserLogin(p.getProperty("username"),p.getProperty("password"));
        
        search.verifyFlightSearchPageIsDisplayed(test);

        //Method to Search The Flight
        search.searchFightsOnHomePage(departFrom,goingTo,date2.day,fromMonthYear,adultsCounts,childCount,infantsCount);

     
        long startTime = System.currentTimeMillis();
        search.clickOnSearchFlight();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'one-way-new-result-card')]")));
//        long endTime = System.currentTimeMillis();
//		long loadTimeInSeconds = (endTime - startTime) / 1000;
//		test.log(Status.INFO, "Flight search results loaded in " + loadTimeInSeconds + " seconds");
//		
//		resultPage.validateResultPageIsDisplayed(test);
//        
//        System.out.println("******** Finished TestCase1: testLogin ********");
//        
       
       
    	}
    	catch(Exception e)
    	{
    		logger.debug("Debug log", e);
    		logger.error("Test failed due to exception: " + e.getMessage());
    		Assert.fail("Test failed due to exception: " + e.getMessage());

    	}
        
    }
}
