package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/main/java/features", 
    glue = {"StepDefination","setup"},             
    plugin = {
        "pretty",
        "html:target/cucumber-reports/cucumber-html-report.html",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
    },
    
    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
