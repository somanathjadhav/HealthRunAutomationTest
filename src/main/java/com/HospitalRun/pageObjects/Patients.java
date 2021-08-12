package com.HospitalRun.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Patients {
	
	WebDriver ldriver;
	@FindBy(xpath="//a[text()='Patients']") WebElement linkPatients;
	@FindBy(xpath="//button[contains(text(),'new patient')]") WebElement btnNewPatient;
	@FindBy(xpath="//input[contains(@id,'firstName')]") WebElement txtFirstName;
	@FindBy(xpath="//input[contains(@id,'middleName')]") WebElement txtMiddleName;
	@FindBy(xpath="//input[contains(@id,'lastName')]") WebElement txtLastName;
	@FindBy(xpath="//button[contains(@class,'btn btn-primary on')]") WebElement btnAdd;
	
	public Patients(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	public void clickPatients() {
		linkPatients.click();
	}
	public void clickNewPatient() {
		btnNewPatient.click();
	}
	public void enterFirstName(String fname) {
		txtFirstName.sendKeys(fname);
	}
	public void enterMiddleName(String mname) {
		txtMiddleName.sendKeys(mname);
	}
	public void enterLastname(String lname) {
		txtLastName.sendKeys(lname);
	}
	public void clickAdd() {
		btnAdd.click();
	}
}

