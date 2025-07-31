package com.iween.pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class searchFlightPage1 extends BasePage
{
	public searchFlightPage1(WebDriver driver) 
	{
		super(driver);

	}
	@FindBy(xpath="//input[@id='react-select-3-input']")
	WebElement departFrom;
	@FindBy(xpath="//input[@id='react-select-4-input']")
	WebElement arrivalTo;
	@FindBy(xpath = "//div[@id='react-select-3-listbox']//div[@class='airport-city-details']")
	List<WebElement> getAllDepartFrom;
	@FindBy(xpath = "//div[@id='react-select-4-listbox']//div[@class='airport-city-details']")
	List<WebElement> getAllArrivalTo;
	@FindBy(xpath="//div[@class='airport-focused airport-option']//span[text()='BLR']")
	WebElement selectDepart;
	@FindBy(xpath="//div[@class='airport-focused airport-option']/parent::div//span[text()='DEL']")
	WebElement selectArrival;

	@FindBy(xpath="//span[text()='Adults(12y+)']/parent::div//li[text()='2']")
	WebElement adultCount;
	@FindBy(xpath="//span[text()='Children(2y-12y)']/parent::div//li[text()='5']")
	WebElement childCount;
	@FindBy(xpath="//span[text()='Infants(<2y)']/parent::div//li[text()='1']")
	WebElement infantCount;

	@FindBy(xpath="//span[@class='travellers-class_text']")
	WebElement clickOnClassPassangerDropdown;
	@FindBy(id="prefclass")
	WebElement classDropdown;
	@FindBy(xpath="//button[text()='Done']")
	WebElement doneButton;
	@FindBy(xpath="//button[text()='Search Flights']")
	WebElement searchFlight;
	@FindBy(xpath = "(//div[@class='react-datepicker__input-container'])[1]")
	WebElement datePickerInput;

	@FindBy(xpath = "(//div[@class='react-datepicker__current-month'])[1]")
	WebElement date;

	@FindBy(xpath = "//button[@aria-label='Next Month']")
	WebElement nextMonth;


	@FindBy(xpath = "(//div[@class='react-datepicker__header ']/child::div)[1]")
	WebElement MonthYear;
	public void departFrom() throws InterruptedException
	{
		departFrom.sendKeys("BLR");
		
	   WebElement getFirstIndex = getAllDepartFrom.get(0);
	   
	   getFirstIndex.click();
	}
	

	public void ArrivalTo() throws InterruptedException
	{
		arrivalTo.sendKeys("DEL");
		WebElement getFirstIndex = getAllArrivalTo.get(0);
		getFirstIndex.click();
	}
	public void selectPaxAndClass()
	{


		clickOnClassPassangerDropdown.click();
		adultCount.click();  	
		childCount.click();
		infantCount.click();
		classDropdown.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		Select select = new Select(classDropdown);

		select.selectByVisibleText("Business");
		doneButton.click();


	}
	public void clickOnSearchFlight()
	{
		searchFlight.click();
	}
	public void selectDate(String day, String MonthandYear) throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Method A: Using zoom
		js.executeScript("document.body.style.zoom='80%'");

		datePickerInput.click();
		String Date = date.getText();
		//	String Date=driver.findElement(By.xpath("(//h2[@class='react-datepicker__current-month'])[1]")).getText();
		if(Date.contentEquals(MonthandYear))
		{
			Thread.sleep(4000);
			driver.findElement(By.xpath("(//div[@class='react-datepicker__month-container'])[1]//div[text()='"+day+"' and @aria-disabled='false']")).click();
			Thread.sleep(4000);
		}else {
			while(!Date.contentEquals(MonthandYear))
			{
				Thread.sleep(500);
				nextMonth.click();
				if(MonthYear.getText().contentEquals(MonthandYear))
				{
					driver.findElement(By.xpath("(//div[@class='react-datepicker__month-container'])[1]//div[text()='"+day+"' and @aria-disabled='false']")).click();
					break;
				}

			}
		}
	}
}
