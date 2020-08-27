package com.ebanking.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ebanking.baseClass.BaseClass;
import com.ebanking.pageObject.EditCoustumer;
import com.ebanking.pageObject.LoginPage;

public class TC_EditCoustumer_004 extends BaseClass{
	
	//LoginPage lp;
	EditCoustumer ec;
	@Test
	public void editCoustumer() throws InterruptedException{
		
//		lp=new LoginPage(driver);
//		
//		lp.setUserName(username);
//		lp.setPasswod(password);
//		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		ec=new EditCoustumer(driver);
		ec.clickEditCoustumer();
		ec.coustumerID();
		ec.clickSubmitButton();	
      
		 driver.findElement(By.xpath("//input[@name='city']")).sendKeys("shahdol222");
		 driver.findElement(By.name("sub")).click();
	    if(isAlertPresent()==true){
	    	driver.switchTo().alert().accept();
	    }
	    else{
	    	System.out.println("This will go to the  next page");
	    	
	    	
	    }
	}

        public boolean isAlertPresent(){
        	try{
        	driver.switchTo().alert();
        	return true;
        	}catch(NoAlertPresentException e){
        		//e.printStackTrace();
        	}
        	return false;
        }

}







