package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ChatSupport {
    WebDriver driver;

    @FindBy(css = "#chatname")
    WebElement nameField;

    @FindBy(xpath = "//input[@id='yourphone']")
    WebElement phoneField;

    @FindBy(xpath ="//input[@id='yourphone']/following::textarea")
    WebElement queryField;

    @FindBy(id = "QuerySubmit")
    WebElement submitBtn;
    
    @FindBy(id ="chatnameError")
    WebElement nameError;

    @FindBy(id ="yourphoneError")
    WebElement phoneError;
    
    @FindBy(id ="querychatError")
    WebElement queryError;
   

    @FindBy(id = "mediumchatoutput")
    WebElement successMessage;
    
    @FindBy(id ="medium_chat")
    WebElement chatButton;

    public ChatSupport(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void selectChatOption() {
        chatButton.click();
     }

    public void fillForm(String name, String phone, String message) {
        nameField.clear();
        nameField.sendKeys(name);

        phoneField.clear();
        phoneField.sendKeys(phone);

        queryField.clear();
        queryField.sendKeys(message);
    }

    public void submitForm() {
        submitBtn.click();
    }

    public String getNameError() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(nameError));
    	return nameError.getText();
    }
    public String getPhoneError() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(phoneError));
    	return phoneError.getText();
    }


    public String getQueryError() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(queryError));
        return queryError.getText();
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }
}

