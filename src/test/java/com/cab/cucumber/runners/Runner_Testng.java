package com.cab.cucumber.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/java/com/cab/cucumber/features",
    glue = {"com.cab.cucumber.definitions", "com.cab.cucumber.hooks"},
    plugin = {"pretty", "junit:target/cucumber-reports/Cucumber.xml"},
    tags = "@Services or @Booking"
)
public class Runner_Testng extends AbstractTestNGCucumberTests {
    // No implementation needed here
}
