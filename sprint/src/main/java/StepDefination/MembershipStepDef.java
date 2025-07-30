package StepDefination;

import java.util.Properties;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import config.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Membership;
import setup.DriverSetup;

import java.time.Duration;

public class MembershipStepDef {
    WebDriver driver = DriverSetup.getDriver();
    Membership member = new Membership(driver);
    Properties prop = ConfigReader.getProperties();
    Actions action=new Actions(driver);
    

    @Given("user is on the Membership form")
    public void user_is_on_the_membership_form() {
        String url = prop.getProperty("membershipurl");
        driver.get(url);
        
        WebElement source = driver.findElement(By.id("drag1"));
        WebElement target = driver.findElement(By.id("div1"));

        // Scroll target into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", target);

        // Perform JavaScript-based drag and drop
        String jsDragAndDrop =
            "function createEvent(typeOfEvent) {" +
            "  var event = document.createEvent(\"CustomEvent\");" +
            "  event.initCustomEvent(typeOfEvent, true, true, null);" +
            "  event.dataTransfer = {" +
            "    data: {}," +
            "    setData: function(key, value) {" +
            "      this.data[key] = value;" +
            "    }," +
            "    getData: function(key) {" +
            "      return this.data[key];" +
            "    }" +
            "  };" +
            "  return event;" +
            "}" +
            "function dispatchEvent(element, event, transferData) {" +
            "  if (transferData !== undefined) {" +
            "    event.dataTransfer = transferData;" +
            "  }" +
            "  if (element.dispatchEvent) {" +
            "    element.dispatchEvent(event);" +
            "  } else if (element.fireEvent) {" +
            "    element.fireEvent(\"on\" + event.type, event);" +
            "  }" +
            "}" +
            "function simulateHTML5DragAndDrop(element, destination) {" +
            "  var dragStartEvent = createEvent('dragstart');" +
            "  dispatchEvent(element, dragStartEvent);" +
            "  var dropEvent = createEvent('drop');" +
            "  dispatchEvent(destination, dropEvent, dragStartEvent.dataTransfer);" +
            "  var dragEndEvent = createEvent('dragend');" +
            "  dispatchEvent(element, dragEndEvent, dropEvent.dataTransfer);" +
            "}" +
            "simulateHTML5DragAndDrop(arguments[0], arguments[1]);";

        ((JavascriptExecutor) driver).executeScript(jsDragAndDrop, source, target);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @When("user clicks on type of membership {string} and enters card number {string}")
    public void user_clicks_on_type_of_membership_and_enters_card_number(String membership, String cardno) {
        //explicit wait until div id membership form opens
    	WebElement radioBtn=driver.findElement(By.id("Platinum"));
    	JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",radioBtn );
    	member.selectMembershipOption(membership);
        member.enterCardNo(membership, cardno);
        member.submitForm();
    }

    @Then("message {string} should be shown")
    public void message_should_be_shown(String expectedMsg) {
        String success = member.getSuccessMessage();
        Assert.assertEquals(success, expectedMsg);
    }

    @Given("user is on the Member List page")
    public void user_is_on_the_member_list_page() {
        String url = prop.getProperty("memberurl");
        driver.get(url);
        
    }

    @Then("list of all members should be shown")
    public void list_of_all_members_should_be_shown() {
        int count = member.getMemberCount();
        Assert.assertTrue(count > 0, "No members are displayed in the section.");
        member.memberSection();
    }

}
