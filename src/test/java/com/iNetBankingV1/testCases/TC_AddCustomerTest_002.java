package com.iNetBankingV1.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.iNetBankingV1.pageObject.AddCustomerPage;
import com.iNetBankingV1.pageObject.loginPage;

import junit.framework.Assert;

public class TC_AddCustomerTest_002 extends BaseClass {

	@Test
	public void addNewCustomer() throws InterruptedException, IOException {

		loginPage lp = new loginPage(driver);
		lp.setUserName(userName);
		logger.info(" ******User Name is provided ****** ");
		lp.setPassword(passWord);
		logger.info(" ******Password is provided ****** ");
		lp.clickSubmit();

		Thread.sleep(3000);

		AddCustomerPage addCust = new AddCustomerPage(driver);
		logger.info(" ******Feeding Customer Data ****** ");
		addCust.clickAddNewCustomer();
		addCust.custName("Hupen");

		addCust.custgender("Male");

		addCust.custdob("11", "21", "1996");

		Thread.sleep(3000);
		addCust.custaddress("16, new state WC");

		addCust.custcity("Bombay");

		addCust.custstate("MH");

		addCust.custpinno("436554");

		addCust.custtelephoneno("3226111616");

		String email = randomString()+"@gmail.com";
		addCust.custemailid(email);

		addCust.custpassword("abcdef");

		addCust.custsubmit();

		Thread.sleep(3000);
		
		logger.info("******validation started*******");

		boolean result = driver.getPageSource().contains("Customer Registered Successfully!!!");
      
        
		if (result==true) 
		{
			logger.info(" ******The Customer Added Successfully ****** ");
			Assert.assertTrue(true);
			
		} 
		else
		{
			
			logger.info(" ******Obsersed Issue while Adding new Customer  ****** ");
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
		
		}

	}

}
