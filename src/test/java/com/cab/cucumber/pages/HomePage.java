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

public class HomePage extends BasePage {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	private static final Logger logger = LogManager.getLogger(HomePage.class);
	
	@FindBy(xpath = "//a[text() = 'Home']") WebElement home;
	@FindBy(xpath = "//a[text()='About']") WebElement about;
	@FindBy(xpath = "//a[text()='Services']") WebElement service;
	@FindBy(xpath = "//a[text()='Booking']") WebElement booking;
	@FindBy(xpath = "//a[text()='Contact']") WebElement contact;

	public HomePage(WebDriver driver, ExtentTest test) {
		super(driver, test);
	}

	public boolean clickService() {
		try {
			WebElement a = wait.until(ExpectedConditions.elementToBeClickable(service));
			a.click();
			logger.info("Service link clicked");
			Reports.generateReport(driver, test, Status.PASS, "Service link clicked successfully" );
		} catch (Exception e) {
			Reports.generateReport(driver, test, Status.FAIL, "Service link Not Open" );
			logger.error("Service link Not Open");	
			return false;
		}
		return true;
	}

	public boolean clickBooking() {
		try {
			WebElement a = wait.until(ExpectedConditions.elementToBeClickable(booking));
			a.click();
			logger.info("Booking link clicked");
			Reports.generateReport(driver, test, Status.PASS, "Booking link clicked successfully" );
		} catch (Exception e) {
			Reports.generateReport(driver, test, Status.FAIL, "Booking link Not Open" );
			logger.error("Booking link Not Open");	
			return false;
		}
		return true;
	}
}