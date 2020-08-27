package com.ebanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
WebDriver driver;

 public LoginPage(WebDriver driver){
	
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
@FindBy(name="uid")
WebElement username;

@FindBy(name="password")
WebElement password;

@FindBy(name="btnLogin")
WebElement btnLogin;

@FindBy(xpath="//a[contains(text(),'Log out')]/parent::li/a")
WebElement logout;

public void setUserName(String uname){
	username.sendKeys(uname);
}
public void setPasswod(String pwd){
	password.sendKeys(pwd);
}
public void clickSubmit(){
	btnLogin.click();
}
public void clickLogout(){
	logout.click();
}
}
