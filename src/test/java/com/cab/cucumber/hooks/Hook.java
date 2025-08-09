package com.cab.cucumber.hooks;

import org.apache.logging.log4j.core.config.Configurator;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.cab.cucumber.utils.LaunchBrowser;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;

public class Hook extends LaunchBrowser{
	public static ExtentSparkReporter spark;
	public static ExtentReports extReports;
	public static ExtentTest test;
	
	@BeforeAll
	public static void log2j() {
		Configurator.initialize(null, "src\\test\\java\\com\\cab\\cucumber\\configs\\log4j2.xml");
	}
	
	@BeforeAll()
	public static void beforeAll() {
		spark = new ExtentSparkReporter(".\\reports\\ExtentReport.html");
		extReports = new ExtentReports();
		extReports.attachReporter(spark);
	}

	@AfterAll()
	public static void afterAll() {
		extReports.flush();
	}
	
	@Before
	public void before() {
		test = extReports.createTest("Call Taxi Service");
		launchBrowser();
	}
	
	@After
	public void quit() {
		driver.quit();
	}
}
