package com.main.web.runner;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;

@CucumberOptions(
        features = "src/test/resources/features/web",
        glue = "com.main.web.steps",
        plugin = {"pretty", "json:src/test/java/com/reports/web/cucumber.json", "html:src/test/java/com/reports/web/cucumber-web.html"}
)
public class TestRunnerWeb extends AbstractTestNGCucumberTests {
    
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @Override
    @Test(groups = "cucumber", description = "Runs Cucumber Scenarios Web", dataProvider = "scenarios")
    public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
        super.runScenario(pickleWrapper, featureWrapper);
    }

    @Override
    @org.testng.annotations.AfterClass(alwaysRun = true)
    public void tearDownClass() {
        super.tearDownClass();
        java.io.File report = new java.io.File("src/test/java/com/reports/web/cucumber-web.html");
        if (report.exists()) {
            String timestamp = new java.text.SimpleDateFormat("dd-MM-yyyy_HH_mm_ss").format(new java.util.Date());
            report.renameTo(new java.io.File("src/test/java/com/reports/web/TestRunnerWeb_" + timestamp + ".html"));
        }
    }
}
