package pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailSupport {
	WebDriver driver;

    public EmailSupport(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
//    @FindBy(id="medium_email")
//    private WebElement emailButton;
//    
    @FindBy(id="fromEmail")
    private WebElement fromEmail;
  
    @FindBy(id="queryemail")
    private WebElement queryInput;
//    
//    @FindBy(id="fromemailError")
//    private WebElement emailErrorMsg;
//    
//    @FindBy(id="queryemailError")
//    private WebElement queryErrorMsg;
//
//    @FindBy(id="QuerySubmit")
//    private WebElement submitButton;
//    
    @FindBy(id="mediummailoutput")
    private WebElement successMessage;

    

    public void enterFromEmail(String email) {
        fromEmail.clear();
        fromEmail.sendKeys(email);
    }

    public void enterQuery(String query) {
        queryInput.clear();
        queryInput.sendKeys(query);
    }


    public String getSuccessMessage() {
        return successMessage.getText();
    }
   


    @FindBy(id = "medium_email")
    private WebElement emailRadioBtn;

    @FindBy(id = "QuerySubmit")
    private WebElement submitBtn;

    @FindBy(id = "fromemailError")
    private WebElement fromEmailError;

    @FindBy(id = "queryemailError")
    private WebElement queryError;


    public void selectEmailOption() {
        emailRadioBtn.click();
    }

    public void submitEmptyEmailForm() {
        submitBtn.click();
    }

    public String getFromEmailError() {
        return fromEmailError.getText();
    }

    public String getQueryError() {
        return queryError.getText();
    }

}
