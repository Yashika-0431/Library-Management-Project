package StepDefination;


import io.cucumber.java.en.*;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import config.ConfigReader;
import pages.LibraryCard;
import setup.DriverSetup;

public class LibraryCardStepDef {

    WebDriver driver = DriverSetup.getDriver();
    LibraryCard cardPage = new LibraryCard(driver);
    Properties prop = ConfigReader.getProperties();

    @Given("user is on the Library Card page")
    public void user_is_on_the_library_card_page() {
    	String url = prop.getProperty("libraryurl");
        driver.get(url);
    }

    @When("user submits the form without entering any data")
    public void user_submits_form_without_data() {
        cardPage.clickSubmit();
    }

    @Then("error messages should appear for all required fields")
    public void error_messages_should_appear_for_all_required_fields() {
        Assert.assertTrue(cardPage.isErrorVisible(cardPage.firstNameError));
        Assert.assertTrue(cardPage.isErrorVisible(cardPage.lastNameError));
        Assert.assertTrue(cardPage.isErrorVisible(cardPage.ageError));
        Assert.assertTrue(cardPage.isErrorVisible(cardPage.emailError));
        Assert.assertTrue(cardPage.isErrorVisible(cardPage.phoneError));
        Assert.assertTrue(cardPage.isErrorVisible(cardPage.workError));
        Assert.assertTrue(cardPage.isErrorVisible(cardPage.cardError));
    }

    @When("user enters email {string} and submits the form")
    public void user_enters_invalid_email_and_submits(String email) {
        cardPage.enterEmail(email);
        cardPage.clickSubmit();
    }

    @Then("error message {string} should be shown")
    public void error_message_should_be_shown(String expectedError) {
        Assert.assertTrue(cardPage.isErrorVisible(cardPage.emailError));
        Assert.assertEquals(cardPage.emailError.getText().trim(), expectedError);
    }
    
    @When("user enters phone number {string} on Library Card page")
    public void user_enters_phone_number_on_library_card_page(String phone) {
        // Write code here that turns the phrase above into concrete actions
        cardPage.enterPhone(phone);
        cardPage.clickSubmit();
    }
    
    @Then("error message for phone should be shown as {string} on Library Card page")
    public void error_message_for_phone_should_be_shown_as_on_library_card_page(String expectedError) {
        // Write code here that turns the phrase above into concrete actions
    	 Assert.assertTrue(cardPage.isErrorVisible(cardPage.emailError));
         Assert.assertEquals(cardPage.emailError.getText().trim(), expectedError);
    }

    @When("user selects {string} as Work Type")
    public void user_selects_work_type(String type) {
        if (type.equalsIgnoreCase("Student")) {
            cardPage.selectStudent();
        } else if (type.equalsIgnoreCase("Employee")) {
            cardPage.selectEmployee();
        }
    }

    @Then("School Name field should be displayed")
    public void school_name_field_should_be_displayed() {
        Assert.assertTrue(cardPage.isSchoolInputVisible());
    }

    @Then("Company Name field should be displayed")
    public void company_name_field_should_be_displayed() {
        Assert.assertTrue(cardPage.isCompanyInputVisible());
    }

    @When("user fills all fields with valid data and submits")
    public void user_fills_valid_data_and_submits() {
        cardPage.enterFirstName("Ritu");
        cardPage.enterLastName("Das");
        cardPage.enterAge("25");
        cardPage.enterEmail("ritu@example.com");
        cardPage.enterPhone("9876543210");
        cardPage.selectStudent();
        cardPage.enterSchoolName("Modern School");
        cardPage.selectAction("Apply New Card");
        cardPage.clickSubmit();
    }

    @Then("user record should appear in the library card list")
    public void user_record_should_appear_in_list() {
        Assert.assertTrue(driver.findElement(By.id("idcard")).getText().contains("Ritu"));
    }
}
