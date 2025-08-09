package com.cab.cucumber.definitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.cab.cucumber.hooks.Hook;
import com.cab.cucumber.pages.BookingPage;
import com.cab.cucumber.pages.HomePage;
import com.cab.cucumber.utils.ExcelReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Booking {
	public WebDriver driver = Hook.driver;
	HomePage obj;
	BookingPage bookObj;
	ExtentTest test = Hook.test;
	String[] data = new String[10];
	
	@Given("Navigate to Booking page")
	public void navigate_to_booking_page() {
	    obj = new HomePage(driver, test);
	    Assert.assertTrue(obj.clickBooking());
	}

	@When("Enter All field valid data for full name, phone, email, trip type, car type, date, number of passenger, trip time {string}")
	public void enter_all_field_valid_data(String noOfData) throws Exception {
		bookObj = new BookingPage(driver, test);
		data = ExcelReader.excelReader(".\\src\\test\\java\\com\\cab\\cucumber\\configs\\BookingData.xlsx","sheet1",noOfData);
		Assert.assertTrue(bookObj.enterName(data[0]));
		Assert.assertTrue(bookObj.enterPhone(data[1]));
		Assert.assertTrue(bookObj.enterEmail(data[2]));
		Assert.assertTrue(bookObj.enterTrip(data[3]));
		Assert.assertTrue(bookObj.enterCabSelect(data[4]));
		Assert.assertTrue(bookObj.enterCabType(data[5]));
		Assert.assertTrue(bookObj.enterdate(data[6]));
		Assert.assertTrue(bookObj.enterePickUpTime(data[7]));
		Assert.assertTrue(bookObj.enterNumberOfPassengers(data[8]));
		Assert.assertTrue(bookObj.enterTripType(data[9]));
	}

	@And("Click Book Now button")
	public void click_book_now_button() {
		Assert.assertTrue(bookObj.enterBookNow());
	}
	
	@Then("Verify the valid data")
	public void verify_the_data() {
		Assert.assertTrue(bookObj.checkAns());
	}
	
	@When("Enter All field Invalid data for full name, phone, email, trip type, car type, date, number of passenger, trip time {string}")
	public void enter_all_field_invalid_data(String string) throws Exception {
		bookObj = new BookingPage(driver, test);
		data = ExcelReader.excelReader(".\\src\\test\\java\\com\\cab\\cucumber\\configs\\BookingData.xlsx","sheet2",string);
		Assert.assertTrue(bookObj.enterName(data[0]));
		Assert.assertTrue(bookObj.enterPhone(data[1]));
		Assert.assertTrue(bookObj.enterEmail(data[2]));
		Assert.assertTrue(bookObj.enterTrip(data[3]));
		Assert.assertTrue(bookObj.enterCabSelect(data[4]));
		Assert.assertTrue(bookObj.enterCabType(data[5]));
		Assert.assertTrue(bookObj.enterdate(data[6]));
		Assert.assertTrue(bookObj.enterePickUpTime(data[7]));
		Assert.assertTrue(bookObj.enterNumberOfPassengers(data[8]));
		Assert.assertTrue(bookObj.enterTripType(data[9]));
	}
	
	@When("Click Book Now button with no data")
	public void click_book_now_button_with_no_data() {
		bookObj = new BookingPage(driver, test);
		Assert.assertTrue(bookObj.enterBookNow());
	}
	
	@Then("Verify the InValid data")
	public void verify_the_InValid_data() {
		Assert.assertTrue(bookObj.checkAnsInvalid());
	}

	@Then("Verify with No data")
	public void verify_with_no_data() {
		Assert.assertTrue(bookObj.checkAnsNoData());
	}
}
