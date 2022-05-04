package com.marvelbank.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.marvelbank.qa.base.TestBase;

public class DeleteCustomerPage extends TestBase {
	
	//OR
	@FindBy(xpath="//input[@name='cusid']")
	WebElement customerIdTextBox;

	@FindBy(xpath="//input[@name='AccSubmit']")
	WebElement submitBtn;
	
	//initialize the OR
	public DeleteCustomerPage() {
		PageFactory.initElements(driver, this);
	}
	
	//actions
	public String validateDeleteCustomerTitle() {
		return driver.getTitle();
	}
	
	public void deleteCustomer(String customerId) {
		customerIdTextBox.sendKeys(customerId);
		submitBtn.click();
		driver.switchTo().alert().accept();
		driver.switchTo().alert().accept();
	}
}
