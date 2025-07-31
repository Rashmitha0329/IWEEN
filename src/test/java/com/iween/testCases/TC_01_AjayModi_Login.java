package com.iween.testCases;

import java.util.Map;

import org.testng.annotations.Test;

import com.iween.pageObjects.UserLoginPage1;
import com.iween.pageObjects.searchFlightPage1;
import com.iween.testBase.baseClass;
import com.iween.utilities.Iween_FutureDates;

public class TC_01_AjayModi_Login extends baseClass{
	@Test
	public void bookingProcess() throws InterruptedException 
	{
		Map<String, Iween_FutureDates.DateResult> dateResults = futureDates.furtherDate();
		Iween_FutureDates.DateResult date2 = dateResults.get("datePlus2");
		String fromMonthYear = date2.month + " " + date2.year; 
		
		UserLoginPage1 login= new UserLoginPage1(driver);
		searchFlightPage1 search = new searchFlightPage1(driver);
		String userName =p.getProperty("username");
		String password = p.getProperty("password");
		System.out.println(userName);
		System.out.println(password);
        logger.info("user name and password entering");
		login.UserLogin(userName,password);
        logger.info("user name password entering");

//		Thread.sleep(1000);
//		search.departFrom();
//		search.ArrivalTo();
//		search.selectDate(date2.day, fromMonthYear);
//	
//		search.selectPaxAndClass();
//		search.clickOnSearchFlight();
		
		
		


	}

}
