package com.ebanking.testcases;

import org.testng.annotations.Test;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ebanking.baseClass.BaseClass;
import com.ebanking.pageObject.LoginPage;
import com.ebanking.pageObject.NewCostumer;

public class TC_Ebanking_002 extends BaseClass {
	
	
	NewCostumer costumer;
	LoginPage lp;
	
		
	
	@Test
	public void addNewCostumer() throws InterruptedException{
            //driver.get(baseURL);
            logger.info("open the url");
            lp =new LoginPage(driver);
            
		lp.setUserName(username);
		lp.setPasswod(password);
		lp.clickSubmit();
		Thread.sleep(3000);
		
		
        costumer=new NewCostumer(driver);
        Thread.sleep(3000);
		costumer.newCoustumerLink();
		
		//WebElement element = driver.findElement(By.xpath("//ul[@class='menusubnav']/li/a[text()='New Customer']"));
		//JavascriptExecutor executor = (JavascriptExecutor)driver;
		//executor.executeScript(arguments[0].click();, element);
		
		
		
		costumer.newCoustumerName("RadheShyam");
		costumer.gender();
		costumer.dateOfBirth("06/23/1990");
		costumer.costumeraddress("Railway colony,Shahdol");
		costumer.coustumerCity("Shahdol");
		costumer.coustumerState("Madhya Pradesh");
		costumer.coustumerPinCode("484001");
		costumer.coustumerMobileNo("8770703904");
		
		String email=randomstring();
		costumer.coustumerEmailId(email+"@gmail.com");
		
		costumer.coustumerPassword("radhe@1234");
		
		costumer.clickSubmit();

		costumer.alertPopup();
		
		//costumer.clickReset();
	} 
	
	public String randomstring(){
		
		String genratedstring= RandomStringUtils.randomAlphabetic(8);
		return genratedstring;
	}
	
	
	
	

}
