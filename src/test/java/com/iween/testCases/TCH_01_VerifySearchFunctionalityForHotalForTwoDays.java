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
import com.iween.pageObjects.loginPage1;
import com.iween.testBase.baseClass;
import com.iween.utilities.DataProviders;
import com.iween.utilities.ExtentManager;
import com.iween.utilities.Iween_FutureDates;
import com.iween.utilities.Retry;


public class TCH_01_VerifySearchFunctionalityForHotalForTwoDays extends baseClass {
	@Test(dataProvider = "excelData", dataProviderClass = DataProviders.class, retryAnalyzer = Retry.class)

	    public void myTest(Map<String, String> excelTestData) throws Exception {
	        System.out.println("Running test with: " + excelTestData);
    	try {
        logger.info("******** Starting TestCase1: testLogin ********");
        ExtentTest test = ExtentManager.getTest(); // ✅ Fix: get current test instance from thread
        String city = excelTestData.get("City");
		int Index = Integer.parseInt(excelTestData.get("index"));

		int roomcount = Integer.parseInt(excelTestData.get("roomCount"));
		int adultcount = Integer.parseInt(excelTestData.get("adultCount"));
		int childcount = Integer.parseInt(excelTestData.get("childCount"));
		int childAge = Integer.parseInt(excelTestData.get("ChildAge"));
        
		test.log(Status.INFO, "City: " + city);
        test.log(Status.INFO, "Rooms: " + roomcount + ", Adults: " + adultcount + ", Children: " + childcount);
	
        Map<String, Iween_FutureDates.DateResult> dateResults = futureDates.furtherDate();
		Iween_FutureDates.DateResult date2 = dateResults.get("datePlus2");
		String fromMonthYear = date2.month + " " + date2.year;
		Iween_FutureDates.DateResult date5 = dateResults.get("datePlus5");
		String returnMonthYear = date5.month + " " + date5.year;
		
		 
		
		 
		
        
        loginPage1 loginPage = new loginPage1(driver);

        logger.info("Entering Username");
        loginPage.enterUserName(p.getProperty("username"));

        logger.info("Entering Password");
        loginPage.enterPasswordName(p.getProperty("password"));

        logger.info("Clicking Login Button");
        loginPage.clickButton();

        loginPage.hotelClick();
        Thread.sleep(3000);
    
       // // Now directly use log and test without re-declaring
//        loginPage.validateHomePageIsDisplayed(log, test);
//        
//        loginPage.enterCityOrHotelName(city);
//        
//        loginPage.selectDate(date2.day, fromMonthYear);
//    
//        loginPage.selectReturnDate(date5.day,returnMonthYear);
//        loginPage.clickOnSearch();

//        loginPage.addRoom(roomcount,adultcount,childcount,childAge);
//        long startTime = System.currentTimeMillis();
//        loginPage.clickOnSearch();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[@title]")));
//        long endTime = System.currentTimeMillis();
//		long loadTimeInSeconds = (endTime - startTime) / 1000;
//		test.log(Status.INFO, "Hotel search results loaded in " + loadTimeInSeconds + " seconds");
//		//loginPage.validateResultScreen(log, test);
        
        logger.info("******** Finished TestCase1: testLogin ********");
        
       
        logger.info("Verifying login success...");
    	}
    	catch(Exception e)
    	{
    		logger.debug("Debug log", e);
    		logger.error("Test failed due to exception: " + e.getMessage());
    		Assert.fail("Test failed due to exception: " + e.getMessage());

    	}
        
    }
}
