package com.HospitalRun.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(xpath="//input[@id='identification']") WebElement txtusername;
	@FindBy(xpath="//input[@id='password']") WebElement txtpassword;
	@FindBy(xpath="//button[@type='submit']") WebElement btnsignin;
	
	public void setUserName(String uname) {
		txtusername.sendKeys(uname);
	}
	public void setPassword(String pwd) {
		txtpassword.sendKeys(pwd);
	}
	public void clickSignin() {
		btnsignin.click();
	}
}
