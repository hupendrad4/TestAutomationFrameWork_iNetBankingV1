package com.iNetBankingV1.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	public  ReadConfig() {
		
		File src=new File("./Configurations/config.properties");
		
		try {
			FileInputStream fis=new FileInputStream(src);
			
			pro=new Properties();
			pro.load(fis);
			}
		catch (IOException e) 
		{
			System.out.println("The Exception is" +e.getMessage());
		}
	}

	
	
	public String getApplicationUrl(){
		String AppUrl=pro.getProperty("baseUrl");
		return AppUrl;	
	}
	
	public String getUserName(){
		String Uname=pro.getProperty("userName");
		return Uname;	
	}
	
	
	public String getPassword(){
		String Pwd=pro.getProperty("passWord");
		return Pwd;	
	}
	
	public String getChromePath() {
		String ChromPath=pro.getProperty("chromepath");
		return ChromPath;	
	}
	
	
	public String getIEPath() {
		String IEPath=pro.getProperty("iepath");
		return IEPath;	
	}
	
	public String getFirefoxPath() {
		String FirefoxPath=pro.getProperty("firefoxpath");
		return FirefoxPath;	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
