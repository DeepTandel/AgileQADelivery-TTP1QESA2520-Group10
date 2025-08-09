package com.cab.cucumber.definitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.cab.cucumber.hooks.Hook;
import com.cab.cucumber.pages.HomePage;
import com.cab.cucumber.pages.ServicesPage;
import com.cab.cucumber.pages.Type;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Services {
	public WebDriver driver = Hook.driver;
	HomePage obj;
	ServicesPage serviceObj;
	Type typeObj;
	ExtentTest test = Hook.test;

	@Given("Navigate to Service page")
	public void NavigateToServicePage() {
		obj = new HomePage(driver, test);
		Assert.assertTrue(obj.clickService());
	}

	@When("Click on {string} car service link")
	public void clickOnMiniServiceLink(String type) {
		serviceObj = new ServicesPage(driver, test);
		serviceObj.click(type);
	}

	@Then("Verify image and details of {string} is {string}")
	public void VerifyMiniDetails(String type, String verify) {
		typeObj = new Type(driver, test);
		Assert.assertTrue(typeObj.typeDetails(type, verify));
	}
}
