package com.cab.cucumber.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.cab.cucumber.utils.Reports;

public class BookingPage extends BasePage{

	private static final Logger logger = LogManager.getLogger(HomePage.class);
	@FindBy(xpath="//input[@id='fullname']") WebElement fullName;
	@FindBy(xpath="//input[@id='phonenumber']") WebElement phoneNumber;
	@FindBy(xpath="//input[@id='email']") WebElement email;
	@FindBy(xpath="//input[@id='long']") WebElement longTrip;
	@FindBy(xpath="//input[@id='local']") WebElement localTrip;
	@FindBy(xpath="//select[@id='cabselect']") WebElement cabSelect;
	@FindBy(xpath="//select[@id='cabType']") WebElement carType;
	@FindBy(xpath="//input[@id='pickupdate']") WebElement date;
	@FindBy(xpath="//input[@id='pickuptime']") WebElement pickUpTime;
	@FindBy(xpath="//select[@id='passenger']") WebElement noOfPassenger;
	@FindBy(xpath="//input[@id='oneway']") WebElement oneWay;
	@FindBy(xpath="//input[@id='roundtrip']") WebElement roundTrip;
	@FindBy(xpath="//button[@id='submitted']") WebElement bookNow;
	@FindBy(xpath="//table[@id = 'display']//tr[1]") WebElement checkAns;
	
	public BookingPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
	}
	
	public boolean enterName(String name) {
		try {
			fullName.sendKeys(name);
			Reports.generateReport(driver, test, Status.PASS, "FullName: "+name+" enter sucessfully entered" );
			logger.info("FullName: "+name+" enter sucessfully entered");
			return true;
		} catch(Exception e) {
			Reports.generateReport(driver, test, Status.FAIL, "Data could not be send" );
			logger.error("Data could not be send");
			return false;
		}
	}
	
	public boolean enterEmail(String email1) {
		try {
			email.sendKeys(email1);
			Reports.generateReport(driver, test, Status.PASS, "Email: "+email1+" enter sucessfully entered" );
			logger.info("Email: "+email1+" enter sucessfully entered");
			return true;
		} catch(Exception e) {
			Reports.generateReport(driver, test, Status.FAIL, "Data could not be send" );
			logger.error("Data could not be send");
			return false;
		}
	}
	
	public boolean enterPhone(String phone) {
		try {
			phoneNumber.sendKeys(phone);
			Reports.generateReport(driver, test, Status.PASS, "Phone: "+phone+" enter sucessfully entered" );
			logger.info("Phone: "+phone+" enter sucessfully entered");
			return true;
		} catch(Exception e) {
			Reports.generateReport(driver, test, Status.FAIL, "Data could not be send" );
			logger.error("Data could not be send");
			return false;
		}
	}
	
	public boolean enterTrip(String trip) {
		try {
			if(trip.equals("longtrip")) {
				longTrip.click();
				Reports.generateReport(driver, test, Status.PASS, "Trip: "+trip+" enter sucessfully entered" );
				logger.info("Trip: "+trip+" enter sucessfully entered");
			} else if(trip.equals("localtrip")) {
				localTrip.click();
				Reports.generateReport(driver, test, Status.PASS, "Trip: "+trip+" enter sucessfully entered" );
				logger.info("Trip: "+trip+" enter sucessfully entered");
			}
			return true;
		} catch(Exception e) {
			Reports.generateReport(driver, test, Status.FAIL, "Data could not be send" );
			logger.error("Data could not be send");
			return false;
		}
	}
	
	public boolean enterCabSelect(String cabSel) {
		try {
			Select select = new Select(cabSelect);
			select.selectByVisibleText(cabSel);
			Reports.generateReport(driver, test, Status.PASS, "CarSelect: "+cabSel+" enter sucessfully entered" );
			logger.info("CarSelect: "+cabSel+" enter sucessfully entered");
			return true;
		} catch(Exception e) {
			Reports.generateReport(driver, test, Status.FAIL, "Data could not be send" );
			logger.error("Data could not be send");
			return false;
		}
	}
	
	public boolean enterCabType(String cabType) {
		try {
			Select select = new Select(carType);
			select.selectByVisibleText(cabType);
			Reports.generateReport(driver, test, Status.PASS, "CarType: "+cabType+" enter sucessfully entered" );
			logger.info("CarType: "+cabType+" enter sucessfully entered");
			return true;
		} catch(Exception e) {
			Reports.generateReport(driver, test, Status.FAIL, "Data could not be send" );
			logger.error("Data could not be send");
			return false;
		}
	}
	
	public boolean enterdate(String datee) {
		try {
			date.sendKeys(datee);
			Reports.generateReport(driver, test, Status.PASS, "Date: "+datee+" enter sucessfully entered" );
			logger.info("Date: "+datee+" enter sucessfully entered");
			return true;
		} catch(Exception e) {
			Reports.generateReport(driver, test, Status.FAIL, "Data could not be send" );
			logger.error("Data could not be send");
			return false;
		}
	}
	
	public boolean enterePickUpTime(String pickuptime) {
		try {
			pickUpTime.sendKeys(pickuptime);
			Reports.generateReport(driver, test, Status.PASS, "Pick Up Time: "+pickuptime+" enter sucessfully entered" );
			logger.info("Pick Up Time: "+pickuptime+" enter sucessfully entered");
			return true;
		} catch(Exception e) {
			Reports.generateReport(driver, test, Status.FAIL, "Data could not be send" );
			logger.error("Data could not be send");
			return false;
		}
	}
	
	public boolean enterNumberOfPassengers(String NOP) {
		try {
			Select select = new Select(noOfPassenger);
			select.selectByVisibleText(NOP);
			Reports.generateReport(driver, test, Status.PASS, "Number Of Passengers: "+NOP+" enter sucessfully entered" );
			logger.info("Number Of Passengers: "+NOP+" enter sucessfully entered");
			return true;
		} catch(Exception e) {
			Reports.generateReport(driver, test, Status.FAIL, "Data could not be send" );
			logger.error("Data could not be send");
			return false;
		}
	}
	
	public boolean enterTripType(String tripT) {
		try {
			if(tripT.equals("oneWay")) {
				oneWay.click();
				Reports.generateReport(driver, test, Status.PASS, "Trip Type: "+tripT+" enter sucessfully entered" );
				logger.info("Trip Type: "+tripT+" enter sucessfully entered");
			} else if(tripT.equals("roundTrip")) {
				roundTrip.click();
				Reports.generateReport(driver, test, Status.PASS, "Trip Type: "+tripT+" enter sucessfully entered" );
				logger.info("Trip Type: "+tripT+" enter sucessfully entered");
			}
			return true;
		} catch(Exception e) {
			Reports.generateReport(driver, test, Status.FAIL, "Data could not be send" );
			logger.error("Data could not be send");
			return false;
		}
	}
	
	public boolean enterBookNow() {
		try {
			bookNow.click();
			Reports.generateReport(driver, test, Status.PASS, "All Data enter sucessfully entered" );
			logger.info("All Data enter sucessfully entered");
			return true;
		} catch(Exception e) {
			Reports.generateReport(driver, test, Status.FAIL, "Data Not entered" );
			logger.error("Data Not entered");
			return false;
		}
	}
	
	public boolean checkAns() {
		try {
			if(checkAns.isDisplayed()) {
				Reports.generateReport(driver, test, Status.PASS, "All Data enter sucessfully displayed" );
				logger.info("All Data enter sucessfully entered");
				return true;
			} else {
				Reports.generateReport(driver, test, Status.FAIL, "Data not displayed" );
				logger.error("Data not displayed");
				return false;
			}
		} catch(Exception e) {
			Reports.generateReport(driver, test, Status.FAIL, "Data not displayed" );
			logger.error("Data not displayed");
			return false;
		}
	}
	
	public boolean checkAnsInvalid() {
		try {
			if(checkAns.isDisplayed()) {
				Reports.generateReport(driver, test, Status.FAIL, "Data is displayed" );
				logger.info("Data is displayed");
				return false;
			}
		} catch(Exception e) {
			Reports.generateReport(driver, test, Status.FAIL, "Data is displayed" );
			logger.error("Data not displayed");
			return false;	
		}
		return true;
	}
	
	public boolean checkAnsNoData() {
		try {
			if(checkAns.isDisplayed() == false) {
				Reports.generateReport(driver, test, Status.PASS, "Enter Data message" );
				logger.info("Enter Data message");
				return true;
			} else {
				Reports.generateReport(driver, test, Status.FAIL, "Data is not displayed" );
				logger.info("Data is not displayed");
				return false;
			}
		} catch(Exception e) {
			Reports.generateReport(driver, test, Status.PASS, "Enter Data message" );
			logger.info("Enter Data message");
			return true;
		}
	}
}
