package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.TestContextSetup;

import java.io.File;
import java.io.IOException;

public class hooks {
    public WebDriver driver;
    TestContextSetup testContextSetup;
    public hooks(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }
    @After
    public void closeBrowser() throws IOException {
        testContextSetup.testBase.WebDriverManager().quit();
    }

    @AfterStep
    public void AddScreenshot(Scenario scenario) throws IOException {
        driver=testContextSetup.testBase.WebDriverManager();
        if (scenario.isFailed()) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            byte[] file=FileUtils.readFileToByteArray(screenshot);
            scenario.attach(file, "image/png", "screenshot");
        }
    }
}
