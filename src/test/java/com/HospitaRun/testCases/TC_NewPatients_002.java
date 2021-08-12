package com.HospitaRun.testCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.HospitalRun.pageObjects.LoginPage;
import com.HospitalRun.pageObjects.Patients;

public class TC_NewPatients_002 extends BaseClass {
	String firstname="Som ";
	String middlename="pra ";
	String lastname="Jad";
	String successmsg="The patient record for "+firstname+middlename+lastname+" has been saved.";
	@Test
	public void addNewPatient() throws IOException, InterruptedException {
		logger.info("URL is opened");
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
		addnewpatient.clickNewPatient();
		logger.info("clicked on New Patient button");
		addnewpatient.enterFirstName(firstname);
		logger.info("First Name entered");
		addnewpatient.enterMiddleName(middlename);
		logger.info("Middle Name entered");
		Thread.sleep(2000);
		addnewpatient.enterLastname(lastname);
		logger.info("Last Name entered");
		addnewpatient.clickAdd();
		logger.info("clicked on Add button");
		WebDriverWait wait= new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='alert alert-success message']"))));
		String sucesstext=driver.findElement(By.xpath("//div[@class='alert alert-success message']")).getText();
		Assert.assertEquals(sucesstext, successmsg);
		boolean patientid=driver.findElement(By.xpath("//div[@class='ps-info-group patient-id']")).isDisplayed();
		Assert.assertEquals(patientid, true);
		logger.info("New Patient Added Successfully");
	}

}
