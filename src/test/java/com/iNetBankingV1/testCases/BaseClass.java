package com.iNetBankingV1.testCases;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Level;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.iNetBankingV1.utilities.ReadConfig;

public class BaseClass {

	// Fetchi all the variable paramters from config.properties file

	ReadConfig readConfig = new ReadConfig();

	public String baseUrl = readConfig.getApplicationUrl();
	public String userName = readConfig.getUserName();
	public String passWord = readConfig.getPassword();

	public static WebDriver driver;
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void SetUp(String br) {

		// added logger
		logger = Logger.getLogger("R");
		PropertyConfigurator.configure("Log4j.properties");
		// logger.setLevel(level.);

		// System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
		// + "//Drivers//chromedriver.exe");

		// invoking driver through the config.properties file
		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
			driver = new ChromeDriver();
		}

		else if (br.equals("ie")) {
			System.setProperty("webdriver.ie.driver", readConfig.getIEPath());
			driver = new InternetExplorerDriver();
		} else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readConfig.getFirefoxPath());
			driver = new FirefoxDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
		driver.manage().window().maximize();

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}

	public static String randomString() {

		String getRandomstring = RandomStringUtils.randomAlphabetic(5);
		return (getRandomstring);
	}

	public static String randomNumber() {

		String getRandomNumber = RandomStringUtils.randomNumeric(4);
		return (getRandomNumber);
	}

}
