package com.ebanking.testcases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ebanking.baseClass.BaseClass;
import com.ebanking.pageObject.LoginPage;
import com.ebanking.utility.XLUtility;

public class TC_loginDDT_003 extends BaseClass {
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd){
		
		LoginPage lp=new LoginPage(driver);
		
		lp.setUserName(user);
		lp.setPasswod(pwd);
		lp.clickSubmit();
		
		if(isAlertPresent()==true){
			
			driver.switchTo().alert().accept();//close alert if we are entering wrong user name and user password
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		}
		else{
			Assert.assertTrue(true);
			lp.clickLogout();
			driver.switchTo().alert().accept();//close logout alert if we go successful login 
			driver.switchTo().defaultContent();
		}
		
	}
	
	public boolean isAlertPresent(){//user defined method created to check alert is present or not
		
		try{
		driver.switchTo().alert();
		return true;
		}
		
		catch(NoAlertPresentException e){
			
			return false;
		}
		
	}
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException{
		
		String path="C:/Users/Phurkan/workspace/ebanking/src/test/java/com/ebanking/testdata/ebankingData.xlsx";
		int rownum=XLUtility.getRowCount(path, "Sheet2");
		int colcount=XLUtility.getCellCount(path, "Sheet2", 1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++){
			
			for(int j=0;j<colcount;j++){
				
				logindata[i-1][j]=XLUtility.getCellData(path, "Sheet2", i, j);
				
			}
		}
		return logindata;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}




