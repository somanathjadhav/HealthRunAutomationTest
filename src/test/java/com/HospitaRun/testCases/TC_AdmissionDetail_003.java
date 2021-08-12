package com.HospitaRun.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.HospitalRun.pageObjects.LoginPage;
import com.HospitalRun.pageObjects.Patients;
import com.HospitalRun.pageObjects.Reports_AdmissionsDetail;
import com.HospitalRun.utilities.TestUtils;

public class TC_AdmissionDetail_003 extends BaseClass {
	String genReportTxt="Generating Report";

	@Test
	public void Admissions_Detail_Report() throws IOException {
		logger.info("URL is Opened");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered username");
		lp.setPassword(password);
		logger.info("Entered password");

		lp.clickSignin();
		if (driver.getTitle().equals("HospitalRun")) {
			Assert.assertTrue(true);
			logger.info("Log In Test Passed");

		} else {
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Log In Test Failed");

		}
		Patients addnewpatient= new Patients(driver);
		addnewpatient.clickPatients();
		logger.info("clicked on Patients Link");
		Reports_AdmissionsDetail reportaddmissiondetail= new Reports_AdmissionsDetail(driver);
		reportaddmissiondetail.clickReports();
		logger.info("clicked on Reports link");
		reportaddmissiondetail.clickReportType("Admissions Detail");
		logger.info("selected Report Type");
		reportaddmissiondetail.enterStartDate("08/01/2021");
		logger.info("entered start date");
		reportaddmissiondetail.enterEnddate("08/01/2021");
		logger.info("entered end date");
		reportaddmissiondetail.clickGenerateReport();
		logger.info("clicked on generate report button");
		TestUtils tutils= new TestUtils();
		tutils.waituntilReportLoad(driver);
		WebElement element=driver.findElement(By.xpath("//h4[@class='modal-title']"));
		WebDriverWait wait= new WebDriverWait(driver,20);
		String actualGenReporttxtx=wait.until(ExpectedConditions.visibilityOf(element)).getText();
		Assert.assertEquals(actualGenReporttxtx, genReportTxt);
		//String generatingreptext=driver.findElement(By.xpath("//h4[@class='modal-title']")).getText();
	}
	
}
