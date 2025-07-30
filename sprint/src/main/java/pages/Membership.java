package pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Membership {
	WebDriver driver;
	Actions action;

    public Membership(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        action =new Actions(driver);
    }
    @FindBy(id="medium_email")
    private WebElement emailButton;
    
    @FindBy(id="drag1")
    WebElement source;
    
    @FindBy(id="div1")
    WebElement target;
    
    @FindBy(id="Platinum")
    WebElement platinumMembership;
    
    @FindBy(id="Gold")
    WebElement goldMembership;
    
    @FindBy(id="libcardNumberGold")
    WebElement cardNoForGold;
    
    
    @FindBy(id="libcardNumberPtm")
    WebElement cardNoForPtm;
    
    @FindBy(id="memberSubmit")
    WebElement submitButton;
    
    @FindBy(id="memberoutput")
    WebElement successMsg;
    
    @FindBy(id="members")
    List<WebElement> members;
    
    
    public void selectMembershipOption(String membership) {
    	if(membership.equals("Gold Membership"))
    	{
    		goldMembership.click();
    	}
    	else {
    		platinumMembership.click();
    	}
     }
    public void enterCardNo(String membership,String cardNo) {
    	if(membership.equals("Gold Membership"))
    	{
    		cardNoForGold.sendKeys(cardNo);
    	}
    	else {
    		cardNoForPtm.sendKeys(cardNo);
    	}
     }
    
    public void submitForm() {
        submitButton.click();
    }
    
    public String getSuccessMessage() {
    	return successMsg.getText();
    }
    
    public void memberSection() {
    	for (WebElement mem : members) {
            System.out.println(mem.getText().trim());
        }
    }
    public int getMemberCount() {
    	try {
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert detected: " + alert.getText());
            alert.dismiss(); // or alert.accept();
        } catch (NoAlertPresentException e) {
            // No alert to handle; continue
        }
    	return members.size();
    }
   
}
