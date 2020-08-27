package com.ebanking.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.Test;

import com.ebanking.baseClass.BaseClass;

public class EditTest extends BaseClass {
	
	@Test 
	public void editCoustumer2(){
		
		driver.get("http://demo.guru99.com/V4/manager/EditCustomer.php");
		driver.findElement(By.name("cusid")).sendKeys("25550");
		driver.findElement(By.name("AccSubmit")).click();
		
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