package com.HospitalRun.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtils {
	public void waituntilReportLoad(WebDriver driver) {
		WebDriverWait wait= new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//h4[contains(text(),'Generating Report')]"))));
	}

}
