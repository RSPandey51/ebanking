package com.ebanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class EditCoustumer {
	
	WebDriver driver;
	
	public EditCoustumer(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//ul[@class='menusubnav']/li/a[text()='Edit Customer']")
	WebElement clickEditCoust;
	

	@FindBy(name="cusid")
	WebElement coustID;
	

	@FindBy(name="AccSubmit")
	WebElement clickSubmitButton;
	

	@FindBy(xpath="//input[@name='city']")
	WebElement coustCity;
	

	
	

	@FindBy(name="sub")
	WebElement submitClick;
	
	public void clickEditCoustumer(){
		
		clickEditCoust.click();
	}

	public void coustumerID(){
		
		coustID.sendKeys("25550");
	}
	
	public void clickSubmitButton(){
		
		clickSubmitButton.click();
	}
	public void editCoustumerCity(String city){
		
		coustCity.clear();
		coustCity.sendKeys(city);	
	}
	
	public void getClickSubmit(){
		
		submitClick.click();
		
	}
	
}
