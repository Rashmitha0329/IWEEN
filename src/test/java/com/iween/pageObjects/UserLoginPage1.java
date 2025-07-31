package com.iween.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.iween.testBase.baseClass;

public class UserLoginPage1 extends BasePage
{
	public UserLoginPage1(WebDriver driver) 
	{
		super(driver);

	}
	@FindBy(id="agent_userid")
	WebElement userName;


	@FindBy(id="agent_password")
	WebElement password;

	@FindBy(xpath="//button[@type='submit']")
	WebElement submit;

	public void UserLogin(String uName, String pwd) throws InterruptedException
	{
		try
		{
		System.out.println(uName);
		System.out.println(pwd);
		Thread.sleep(2000);
		userName.sendKeys(uName); 
		password.sendKeys(pwd);
		Thread.sleep(1000);
		submit.click();
		}
		catch(Exception e)
		{
		  e.printStackTrace();
		}

	}
	
}
