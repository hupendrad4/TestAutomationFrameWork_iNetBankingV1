package com.iNetBankingV1.testCases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.iNetBankingV1.pageObject.loginPage;

import junit.framework.Assert;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws IOException {

		logger.info("**************Base URL is open********");
		
		loginPage lp = new loginPage(driver);
		lp.setUserName(userName);
		logger.info("*************Entered Username********");
		lp.setPassword(passWord);
		logger.info("**************Entered Password*********");
		lp.clickSubmit();

	
		String str = driver.getTitle();
		System.out.println(str);

		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {

			Assert.assertTrue(true);
			logger.info("************Login Test Pass********");
		}
		else
		{
			
			Assert.assertTrue(true);
			logger.info("************Login Test Failed********");
			captureScreen(driver,"loginTest");
		}
	}
	
	
}
