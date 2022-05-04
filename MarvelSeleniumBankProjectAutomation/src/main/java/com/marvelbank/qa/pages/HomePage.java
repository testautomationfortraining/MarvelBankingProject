package com.marvelbank.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.marvelbank.qa.base.TestBase;

public class HomePage extends TestBase {
	
	//Object Repository
	@FindBy(xpath="//a[text()='Delete Customer']")
	WebElement deleteCustomerBtn;
	
	@FindBy(xpath="//h2[text()='Guru99 Bank']")
	WebElement logo;
	
	
	//initialize the OB
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//actions
	public String validateHomePageTitle() {
		return driver.getTitle();
	}

	public boolean validateLogo() {
		return logo.isDisplayed();
	}
	
	public DeleteCustomerPage navigateToDeleteCustomerPage() {
		deleteCustomerBtn.click();
		return new DeleteCustomerPage();
	}
}
