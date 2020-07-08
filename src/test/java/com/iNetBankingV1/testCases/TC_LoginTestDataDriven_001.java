package com.iNetBankingV1.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.iNetBankingV1.pageObject.loginPage;
import com.iNetBankingV1.utilities.XLUtils;

import junit.framework.Assert;

public class TC_LoginTestDataDriven_001 extends BaseClass
{

	@Test(dataProvider="LoginData")
	public void LoginDDT(String user , String Pwd) throws InterruptedException, IOException{

		loginPage Lp=new loginPage(driver);
		Lp.setUserName(user);
		logger.info("Provided Username");
		Lp.setPassword(Pwd);
		logger.info("Provided Password");
		Lp.clickSubmit();
		logger.info("Submit login");
		
		if (isAlertPresent()==true) {
         
			driver.switchTo().alert().accept(); //close alert
			logger.info("The Login failed");
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.info("The Login failed");
			captureScreen(driver,"AlertPresent");
		}
		
		else {
			
			Assert.assertTrue(true);
			logger.info("The Login Passed");
			Lp.clickLogout();
			Thread.sleep(3000);
			logger.info("Logged Out From Application");
			driver.switchTo().alert().accept(); //close logout alert
			driver.switchTo().defaultContent();
			
		}
		
  
	}
 
 
	//user defined method created to check whether alert is present or not
	public boolean isAlertPresent() {
		try 
		{
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e){
             
			return false;
			
		}
		
	}
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException {
		
		String path=System.getProperty("user.dir")+"/src/test/java/com/iNetBankingV1/testData/LoginData.xlsx";
		
		int rowNum=XLUtils.getRowCount(path, "Sheet1");
		int colNum=XLUtils.getCellCount(path, "Sheet1",1);
		
		 String loginData[][]=new String[rowNum][colNum]; 
		 
		 for (int i=1;i<=rowNum;i++) {
			 
			 for (int j=0;j<colNum;j++) {
													 
				 
				 loginData[i-1][j]=XLUtils.getCellData(path, "Sheet1",i,j);
							  
 
			 }
				  
		 }
		return loginData;
		
	}
}
