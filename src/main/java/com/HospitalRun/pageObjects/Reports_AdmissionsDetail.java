package com.HospitalRun.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Reports_AdmissionsDetail {
	WebDriver ldriver;
	@FindBy(xpath="//a[contains(@href,'reports')]") WebElement linkReports;
	@FindBy(xpath="//select[@id='report-type']") WebElement dropdownReporttype;
	@FindBy(xpath="//input[contains(@id,'display_startDate')]") WebElement txtStartDate;
	@FindBy(xpath="//input[contains(@id,'display_endDate')]") WebElement txtEndDate;
	@FindBy(xpath="//button[contains(text(),'Generate Report')]") WebElement clickGenerateReport;
	public Reports_AdmissionsDetail(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	public void clickReports() {
		linkReports.click();
	}
	public void clickReportType(String option) {
		Select s = new Select(dropdownReporttype);
		s.selectByVisibleText(option);
	}
	public void enterStartDate(String startDate) {
		txtStartDate.sendKeys(startDate);
	}
	public void enterEnddate(String endDate) {
		txtEndDate.sendKeys(endDate);
	}
	public void clickGenerateReport() {
		clickGenerateReport.click();
	}
	

}
