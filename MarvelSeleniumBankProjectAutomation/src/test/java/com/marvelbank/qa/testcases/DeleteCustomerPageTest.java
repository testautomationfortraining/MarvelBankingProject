package com.marvelbank.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.marvelbank.qa.base.TestBase;
import com.marvelbank.qa.pages.DeleteCustomerPage;
import com.marvelbank.qa.pages.HomePage;
import com.marvelbank.qa.pages.LoginPage;

public class DeleteCustomerPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	DeleteCustomerPage deleteCustomerPage;
	
	public DeleteCustomerPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		deleteCustomerPage=homePage.navigateToDeleteCustomerPage();
	}
	
	@Test(priority=0)
	public void validateDeleteCustomerPageTitle() {
		Assert.assertEquals(deleteCustomerPage.validateDeleteCustomerTitle(), "Guru99 Bank Delete Customer Page");
	}
	
	@Test(priority=1)
	public void deleteTheCustomer() {
		deleteCustomerPage.deleteCustomer(prop.getProperty("customerId"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
