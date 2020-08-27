package com.ebanking.baseClass;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.helpers.Loader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.ebanking.pageObject.LoginPage;
import com.ebanking.utility.ReadConfig;

public class BaseClass {

	ReadConfig readconfig=new ReadConfig();
			
	public String baseURL=readconfig.getApplication();
	public String username=readconfig.getUserName();
	public String password=readconfig.getPassword();
	
	public static WebDriver driver;
	public static Logger logger;
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br){
		
		logger=Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equals("chrome")){
		System.setProperty("webdriver.chrome.driver", readconfig.getChormePath());
		driver=new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get(baseURL);
		
		//logger.info("Open the url");
				LoginPage lp = new LoginPage(driver);
				lp.setUserName(username);
				//logger.info("entered the username");
				lp.setPasswod(password);
				//logger.info("entered the password");
				
				lp.clickSubmit();
				
		
		
		}
	
	@AfterClass
	public void tearDown(){
		//driver.quit();
	}
	
}
