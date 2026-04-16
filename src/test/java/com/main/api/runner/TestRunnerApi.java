package com.main.api.runner;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;

@CucumberOptions(
        features = "src/test/resources/features/api",
        glue = "com.main.api.step",
        plugin = {"pretty", "json:src/test/java/com/reports/api/cucumber.json", "html:src/test/java/com/reports/api/cucumber-api.html"}
)
public class TestRunnerApi extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @Override
    @Test(groups = "cucumber", description = "Runs Cucumber Scenarios API", dataProvider = "scenarios", suiteName = "API")
    public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
        super.runScenario(pickleWrapper, featureWrapper);
    }

    @Override
    @org.testng.annotations.AfterClass(alwaysRun = true)
    public void tearDownClass() {
        super.tearDownClass();
        java.io.File report = new java.io.File("src/test/java/com/reports/api/cucumber-api.html");
        if (report.exists()) {
            String timestamp = new java.text.SimpleDateFormat("dd-MM-yyyy_HH_mm_ss").format(new java.util.Date());
            report.renameTo(new java.io.File("src/test/java/com/reports/api/TestRunnerApi_" + timestamp + ".html"));
        }
    }
}
