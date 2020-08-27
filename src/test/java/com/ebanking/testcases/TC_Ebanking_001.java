package com.ebanking.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ebanking.baseClass.BaseClass;
import com.ebanking.pageObject.LoginPage;

public class TC_Ebanking_001 extends BaseClass{

	@Test
	public void loginTest() throws InterruptedException{
		
//		//logger.info("Open the url");
//		LoginPage lp = new LoginPage(driver);
//		lp.setUserName(username);
//		//logger.info("entered the username");
//		lp.setPasswod(password);
//		//logger.info("entered the password");
//		
//		lp.clickSubmit();
		Thread.sleep(5000);
		System.out.println(driver.getTitle());
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")){
			
			Assert.assertTrue(true);
			//logger.info("Test case is passed");
			
		}
		else{
			Assert.assertTrue(false);
			//logger.info("Test case is Failed");
		}
	}
	
	
}
