package com.HospitaRun.testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.HospitalRun.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	@Test
	public void loginTest() throws IOException {
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
	}

}
