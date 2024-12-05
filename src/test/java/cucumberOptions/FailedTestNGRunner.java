package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "@target/failed_scenarios.txt",
glue = "stepDefinitions", monochrome = true,
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class FailedTestNGRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}

