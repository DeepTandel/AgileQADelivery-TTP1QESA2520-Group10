package com.cab.cucumber.pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.cab.cucumber.utils.Reports;

public class ServicesPage extends BasePage{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	private static final Logger logger = LogManager.getLogger(HomePage.class);
	
	@FindBy(xpath="//a[text()='Mini']") WebElement mini;
	@FindBy(xpath="//a[text()='Micro']") WebElement micro;
	@FindBy(xpath="//a[text()='Suv']") WebElement sUV;
	@FindBy(xpath="//a[text()='Sedan']") WebElement sedan;
	
	public ServicesPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
	}
	
	public boolean click(String type) {
		try {
			if(type.equals("mini")) {
				WebElement a = wait.until(ExpectedConditions.elementToBeClickable(mini));
				a.click();
				logger.info("Mini link clicked");
			} else if(type.equals("micro")) {
				WebElement a = wait.until(ExpectedConditions.elementToBeClickable(micro));
				a.click();
				logger.info("Micro link clicked");
			} else if(type.equals("sUV")) {
				WebElement a = wait.until(ExpectedConditions.elementToBeClickable(sUV));
				a.click();
				logger.info("Suv link clicked");
			} else if(type.equals("sedan")) {
				WebElement a = wait.until(ExpectedConditions.elementToBeClickable(sedan));
				a.click();
				logger.info("Sedan link clicked");
			}
			Reports.generateReport(driver, test, Status.PASS, type+" link clicked successfully" );
		} catch(Exception e) {
			Reports.generateReport(driver, test, Status.FAIL, type+" link Not Open" );
			logger.error(type+" link clicked");
			return false;
		}
		return true;
	}
	
//	public boolean clickMicro() {
//		try {
//			WebElement a = wait.until(ExpectedConditions.elementToBeClickable(micro));
//			a.click();
//			Reports.generateReport(driver, test, Status.PASS, "Micro link clicked successfully" );
//		} catch(Exception e) {
//			Reports.generateReport(driver, test, Status.FAIL, "Micro link Not Open" );
//			return false;
//		}
//		return true;
//	}
//	
//	public boolean clickSUV() {
//		try {
//			WebElement a = wait.until(ExpectedConditions.elementToBeClickable(sUV));
//			a.click();
//			Reports.generateReport(driver, test, Status.PASS, "SUV link clicked successfully" );
//		} catch(Exception e) {
//			Reports.generateReport(driver, test, Status.FAIL, "SUV link Not Open" );
//			return false;
//		}
//		return true;
//	}
//	
//	public boolean clickSedan() {
//		try {
//			WebElement a = wait.until(ExpectedConditions.elementToBeClickable(sedan));
//			a.click();
//			Reports.generateReport(driver, test, Status.PASS, "Sedan link clicked successfully" );
//		} catch(Exception e) {
//			Reports.generateReport(driver, test, Status.FAIL, "Sedan link Not Open" );
//			return false;
//		}
//		return true;
//	}
}
