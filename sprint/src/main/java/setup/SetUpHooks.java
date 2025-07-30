package setup;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SetUpHooks {

    public static WebDriver driver;

    @Before
    public void setUp(Scenario scenario) {
        driver = DriverSetup.getDriver();
        System.out.println("----- Starting Scenario: " + scenario.getName() + " -----");
    }

    @After
    public void tearDown(Scenario scenario) {
        // Capture screenshot on failure
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String screenshotPath = System.getProperty("user.dir") + "/reports/screenshots/" + screenshotName + "_" + timestamp + ".png";

            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                Files.createDirectories(new File(screenshotPath).getParentFile().toPath());
                Files.copy(screenshot.toPath(), new File(screenshotPath).toPath());

                // Attach to Extent Report
             // Attach to Extent Report
                ExtentCucumberAdapter.addTestStepLog("Test failed. Screenshot saved at: " + screenshotPath);
                ExtentCucumberAdapter.addTestStepLog(
                    "<b>Screenshot:</b><br><img src='" + screenshotPath + "' height='400' width='400'/>"
                );


                // Attach to Cucumber HTML Report
                byte[] screenshotBytes = Files.readAllBytes(new File(screenshotPath).toPath());
                scenario.attach(screenshotBytes, "image/png", "Failed Screenshot");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

//        if (driver != null) {
//            driver.quit();
//            DriverSetup.webdriver = null;
//        }
        System.out.println("----- Ended Scenario: " + scenario.getName() + " -----");
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
