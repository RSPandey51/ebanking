package com.ebanking.pageObject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCostumer {

	WebDriver driver;
	
	public NewCostumer(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//ul[@class='menusubnav']/li/a[text()='New Customer']")
	WebElement newCoustumer;
	
	@FindBy(xpath="//table/tbody/tr/td/input[@name='name']")
	WebElement coustumerName;
	
	@FindBy(name="rad1")
	WebElement gender;
	
	@FindBy(name="dob")
	WebElement dob;
	
	@FindBy(name="addr")
	WebElement address;
	
	@FindBy(name="city")
	WebElement city;
	
	@FindBy(name="state")
	WebElement state;
	
	@FindBy(name="pinno")
	WebElement pinCode;
	
	@FindBy(name="telephoneno")
	WebElement mobileNo;
	
	@FindBy(name="emailid")
	WebElement emailId;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="sub")
	WebElement submit;
	
	@FindBy(name="res")
	WebElement reset;
	

      public void newCoustumerLink(){
    	  newCoustumer.click();
      }
      public void newCoustumerName(String coustName){

	coustumerName.sendKeys(coustName);
}	
      public void gender(){
	gender.isSelected();
}
public void dateOfBirth(String mmddyyyy){
	dob.sendKeys(mmddyyyy);
}
public void costumeraddress(String cousaddress){
	address.sendKeys(cousaddress);
}
public void coustumerCity(String cousCity){
	city.sendKeys(cousCity);
}
public void coustumerState(String cousState){
	state.sendKeys(cousState);
}
public void coustumerPinCode(String cousPinCode){
	pinCode.sendKeys(cousPinCode);
}
	public void coustumerMobileNo(String cousMobileNo){
		mobileNo.sendKeys(cousMobileNo);
	}
	
	public void coustumerEmailId(String cousEmailId){
		emailId.sendKeys(cousEmailId);
	}
	
	public void coustumerPassword(String pwd){
		password.sendKeys(pwd);
	}
	
	public void clickSubmit(){
		submit.click();
	}
	public void alertPopup(){
		
		Alert alert= driver.switchTo().alert();
		String alertmessage=alert.getText();
		System.out.println(alertmessage);
		
		alert.accept();
	}
	
	public void clickReset(){
		reset.click();
	}
	
	
	

}
