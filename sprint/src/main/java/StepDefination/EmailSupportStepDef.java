package StepDefination;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import config.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.Duration;
import pages.BookService;
import pages.EmailSupport;
import setup.DriverSetup;

public class EmailSupportStepDef {
	 WebDriver driver = DriverSetup.getDriver();
	    EmailSupport emailPage = new EmailSupport(driver);
	    Properties prop = ConfigReader.getProperties();
	    @Given("user is on the Email Support form")
	    public void user_is_on_email_support_form() {
	         
	        String url = prop.getProperty("serviceurl");// Replace with actual URL if dynamic
	        driver.get(url);
	        emailPage.selectEmailOption();
	    }

	    @When("user submits the form with empty mandatory fields")
	    public void submit_empty_email_form() {
	        emailPage.submitEmptyEmailForm();
	    }

	    @Then("error messages should be shown for required fields")
		public void validate_email_errors() {
		    String fromError = emailPage.getFromEmailError();
		    String queryError = emailPage.getQueryError();

		    Assert.assertTrue(fromError != null && !fromError.trim().isEmpty(), "From Email Error is missing!");
		    Assert.assertTrue(queryError != null && !queryError.trim().isEmpty(), "Query Error is missing!");
		}

	


	@When("user enters {string} as From email and submits")
	public void user_enters_as_from_email_and_submits(String email) {
	    // Write code here that turns the phrase above into concrete actions
		emailPage.enterFromEmail(email);
		emailPage.enterQuery("Test query");
		emailPage.submitEmptyEmailForm();
	}
	@Then("error message for email should be shown as {string}")
	public void error_message_for_email_should_be_shown_as(String message) {
        Assert.assertEquals(message,emailPage.getFromEmailError());
    }

	@When("user enters valid data and submits the form")
    public void user_enters_valid_data_and_submits() {
		emailPage.enterFromEmail("user@example.com");
		emailPage.enterQuery("This is a test query about library services.");
		emailPage.submitEmptyEmailForm();
    }

    @Then("success message {string} should be shown")
    public void success_message_should_be_shown_for_email(String expectedMsg) {
        String success = emailPage.getSuccessMessage();
        Assert.assertEquals(expectedMsg, success);
    }


}
