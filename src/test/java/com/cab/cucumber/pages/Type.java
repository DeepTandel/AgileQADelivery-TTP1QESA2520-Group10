package com.cab.cucumber.pages;

import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.cab.cucumber.utils.Reports;

public class Type extends BasePage{
	public Type(WebDriver driver, ExtentTest test){
		super(driver, test);
	}
	private static final Logger logger = LogManager.getLogger(Type.class);
	@FindBy(xpath="//h1[normalize-space() = 'Mini Cars']") WebElement mini;
	@FindBy(xpath="//h1[normalize-space() = 'Micro Cars']") WebElement micro;
	@FindBy(xpath="//h1[normalize-space()='Suv Cars']") WebElement sUV;
	@FindBy(xpath="//h1[normalize-space()='Sedan Cars']") WebElement sedan;
	public boolean typeDetails(String type, String data) {
		try {
			String originalTab = driver.getWindowHandle();
			Set<String> allTabs = driver.getWindowHandles();
			for (String tab : allTabs) {
				if (!tab.equals(originalTab)) {
					driver.switchTo().window(tab);
					break;
				}
			}
			if(type.equals("mini")){
				if(data.equals(mini.getText())) {
					Reports.generateReport(driver, test, Status.PASS, "Mini details are verified" );
					logger.info("Mini details are verified");
					return true;
				} else {
					Reports.generateReport(driver, test, Status.FAIL, "Mini details are wrong" );
					logger.error("Mini details are wrong");
					return false;
				}
			} else if(type.equals("micro")) {
				if(data.equals(micro.getText())) {
					Reports.generateReport(driver, test, Status.PASS, "Micro details are verified" );
					logger.info("Micro details are verified");
					return true;
				} else {
					Reports.generateReport(driver, test, Status.FAIL, "Micro details are wrong" );
					logger.error("Micro details are wrong");
					return false;
				}
			} else if(type.equals("sUV")) {
				if(data.equals(sUV.getText())) {
					Reports.generateReport(driver, test, Status.PASS, "SUV details are verified" );
					logger.info("SUV details are verified");
					return true;
				} else {
					Reports.generateReport(driver, test, Status.FAIL, "SUV details are wrong" );
					logger.error("SUV details are wrong");
					return false;
				}
			} else if(type.equals("sedan")) {
				if(data.equals(sedan.getText())) {
					Reports.generateReport(driver, test, Status.PASS, "Sedan details are verified" );
					logger.info("Sedan details are verified");
					return true;
				} else {
					Reports.generateReport(driver, test, Status.FAIL, "Sedan details are wrong" );
					logger.error("Sedan details are wrong");
					return false;
				}
			} else {
				Reports.generateReport(driver, test, Status.FAIL, "Element not found" );
			}
		} catch(Exception e) {
			Reports.generateReport(driver, test, Status.FAIL, "Details element is not present" );
		}
		return false;
	}
}
