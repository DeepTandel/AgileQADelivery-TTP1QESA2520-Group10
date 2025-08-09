package com.cab.cucumber.utils;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class LaunchBrowser {
	public static WebDriver driver;
	Properties properties = PropertyReader.readProperty();
	private static final Logger logger = LogManager.getLogger(LaunchBrowser.class);
	public void launchBrowser() {
		if(properties.getProperty("Browser").equals("chrome")) {
			driver = new ChromeDriver();
		} else if(properties.getProperty("Browser").equals("firefox")) {
			driver = new FirefoxDriver();
		} else if(properties.getProperty("Browser").equals("edge")) {
			driver = new EdgeDriver();
		} else {
			System.out.print("Please select correct browser");
			return;
		}
		
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(properties.getProperty("baseUrl"));
		logger.info("HomePage Url lanuch");
	}
}
