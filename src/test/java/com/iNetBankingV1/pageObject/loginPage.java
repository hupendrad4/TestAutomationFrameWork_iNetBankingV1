package com.iNetBankingV1.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	
	WebDriver ldriver;

	
	
	 public loginPage(WebDriver rdriver) {
		
		PageFactory.initElements(rdriver, this);
		rdriver= this.ldriver;
	}
	 
	 @FindBy(name="uid")
	 WebElement txtUsername;
	 
	 @FindBy(name="password")
	 WebElement txtPassword;
	 
	 @FindBy(name="btnLogin")
	 WebElement txtSubmit;

	 @FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	 @CacheLookup
	 WebElement lnkLogout;
	 
	 
	 //Writting Action Methods
	 
	 public void setUserName(String userName) {
		 txtUsername.sendKeys(userName);
		 
	 }
	 
	 public void setPassword(String passWord) {
		 txtPassword.sendKeys(passWord);
		 
	 }
	 
	 public void clickSubmit() {
		 txtSubmit.click();
		 
	 }
	 
	 public void clickLogout()
		{
			lnkLogout.click();
		}

}
