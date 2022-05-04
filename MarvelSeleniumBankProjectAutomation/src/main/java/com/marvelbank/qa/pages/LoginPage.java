package com.marvelbank.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.marvelbank.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Object Repository
	@FindBy(xpath="//input[@name='uid']")
	WebElement userId;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@name='btnLogin']")
	WebElement loginBtn;
	
	@FindBy(xpath="//h2[text()='Guru99 Bank']")
	WebElement logo;
	
	//initializing the page factory
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//actions method
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateLoginPageLogo() {
		return logo.isDisplayed();
	}

	public HomePage login(String un, String pwd) {
		
		userId.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();
	}
}
