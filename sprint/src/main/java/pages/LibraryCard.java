package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LibraryCard {

    WebDriver driver;

    public LibraryCard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // --- Name & Age Section ---
    @FindBy(id = "first")
    private WebElement firstNameInput;

    @FindBy(id = "last")
    private WebElement lastNameInput;

    @FindBy(id = "age")
    private WebElement ageInput;

    @FindBy(id = "firstnameError")
    public WebElement firstNameError;

    @FindBy(id = "lastnameError")
    public WebElement lastNameError;

    @FindBy(id = "ageError")
    public WebElement ageError;

    // --- Email & Phone Section ---
    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "phone")
    private WebElement phoneInput;

    @FindBy(id = "emailError")
    public WebElement emailError;

    @FindBy(id = "phoneError")
    public WebElement phoneError;

    // --- Work Section ---
    @FindBy(id = "work_0")
    private WebElement studentRadio;

    @FindBy(id = "work_1")
    private WebElement employeeRadio;

    @FindBy(id = "school")
    private WebElement schoolInput;

    @FindBy(id = "company")
    private WebElement companyInput;

    @FindBy(id = "schoolLabel")
    public WebElement schoolLabel;

    @FindBy(id = "companyLabel")
    public WebElement companyLabel;

    @FindBy(id = "workError")
    public WebElement workError;

    // --- Card Section ---
    @FindBy(id = "action")
    private WebElement actionDropdown;

    @FindBy(id = "amount")
    private WebElement amountInput;

    @FindBy(id = "cardError")
    public WebElement cardError;

    // --- Submit Button ---
    @FindBy(id = "libraryCardSubmit")
    private WebElement submitButton;

    // --- Action Methods ---

    public void enterFirstName(String firstName) {
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
    }

    public void enterAge(String age) {
        ageInput.clear();
        ageInput.sendKeys(age);
    }

    public void enterEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void enterPhone(String phone) {
        phoneInput.clear();
        phoneInput.sendKeys(phone);
    }

    public void selectStudent() {
        studentRadio.click();
    }

    public void selectEmployee() {
        employeeRadio.click();
    }

    public void enterSchoolName(String school) {
        schoolInput.clear();
        schoolInput.sendKeys(school);
    }

    public void enterCompanyName(String company) {
        companyInput.clear();
        companyInput.sendKeys(company);
    }

    public void selectAction(String actionValue) {
        Select select = new Select(actionDropdown);
        select.selectByVisibleText(actionValue);
    }

    public void enterAmount(String amount) {
        amountInput.clear();
        amountInput.sendKeys(amount);
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public boolean isErrorVisible(WebElement errorElement) {
        return errorElement.isDisplayed() && !errorElement.getText().isEmpty();
    }

    public boolean isSchoolInputVisible() {
        return schoolLabel.isDisplayed();
    }

    public boolean isCompanyInputVisible() {
        return companyLabel.isDisplayed();
    }
}
