package StepDefination;

import config.ConfigReader;
import io.cucumber.java.en.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import pages.ChatSupport;
import pages.EmailSupport;
import setup.DriverSetup;

import java.util.List;
import java.util.Properties;

public class ChatSupportStepDef {

	WebDriver driver = DriverSetup.getDriver();
    ChatSupport chatPage = new ChatSupport(driver);
    Properties prop = ConfigReader.getProperties();
    

    @Given("user is on the Chat form")
    public void user_is_on_the_chat_form() {
    	String url = prop.getProperty("serviceurl");
        driver.get(url);
        chatPage.selectChatOption();
    }

    @When("user submits the form with empty values")
    public void user_submits_the_form_with_empty_values() {
        chatPage.submitForm();
    }

    @Then("error messages should appear for all required fields in chat form")
    public void error_messages_should_appear_for_all_required_fields_in_chatForm() {
    	String nameError = chatPage.getNameError();
    	String phoneError = chatPage.getPhoneError();
	    String queryError = chatPage.getQueryError();

	    Assert.assertTrue(nameError != null && !nameError.trim().isEmpty(), "From Email Error is missing!");
	    Assert.assertTrue(phoneError != null && !phoneError.trim().isEmpty(), "From Email Error is missing!");
	    Assert.assertTrue(queryError != null && !queryError.trim().isEmpty(), "Query Error is missing!");
    }

    @When("user enters phone number {string}")
    public void user_enters_phone_number(String phone) {
        chatPage.fillForm("John", phone, "Hello");
        chatPage.submitForm();
    }

    @Then("error message for phone should be shown as {string}")
    public void error_message_for_phone_should_be_shown_as(String expectedMsg) {
    	Assert.assertEquals(expectedMsg, chatPage.getPhoneError());
    }

    @When("user fills all required fields correctly")
    public void user_fills_all_required_fields_correctly() {
        chatPage.fillForm("John", "9876543210", "Hello Chat");
        chatPage.submitForm();
    }

    @Then("success {string} message should be shown")
    public void success_message_should_be_shown(String expectedMsg) {
        String actualMsg = chatPage.getSuccessMessage();
        Assert.assertEquals(expectedMsg, actualMsg);
    }
}
