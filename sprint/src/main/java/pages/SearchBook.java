package pages;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchBook {

    WebDriver driver;

    public SearchBook(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Author Name input
    @FindBy(id = "authorName")
    private WebElement authorInput;

    // Subject input
    @FindBy(id = "subject")
    private WebElement subjectInput;

    // Edition dropdown
    @FindBy(id = "edition")
    private WebElement editionDropdown;

    // Format dropdown
    @FindBy(id = "format")
    private WebElement formatDropdown;

    // Age group radio buttons
    @FindBy(id = "ageGroup_kids")
    private WebElement kidsRadio;

    @FindBy(id = "ageGroup_teen")
    private WebElement teenRadio;

    @FindBy(id = "ageGroup_adult")
    private WebElement adultRadio;

    // Submit/Search button
    @FindBy(id = "searchSubmit")
    private WebElement searchButton;

    // Error labels
    @FindBy(id = "authorNameError")
    public WebElement authorError;

    @FindBy(id = "subjectError")
    public WebElement subjectError;

    @FindBy(id = "editionError")
    public WebElement editionError;

    @FindBy(id = "formatError")
    public WebElement formatError;

    @FindBy(id = "ageGroupError")
    public WebElement ageError;

    @FindBy(className = "bookscontainer")
    private List<WebElement> bookResults;
    // --- Action methods ---

    public void enterAuthor(String author) {
        authorInput.clear();
        authorInput.sendKeys(author);
    }

    public void enterSubject(String subject) {
        subjectInput.clear();
        subjectInput.sendKeys(subject);
    }

    public void selectEdition(String editionValue) {
        Select select = new Select(editionDropdown);
        select.selectByVisibleText(editionValue);
    }

    public void selectFormat(String formatValue) {
        Select select = new Select(formatDropdown);
        select.selectByVisibleText(formatValue);
    }

    public void selectAgeGroup(String ageGroup) {
        switch (ageGroup.toLowerCase()) {
            case "kids":
                kidsRadio.click();
                break;
            case "teen":
                teenRadio.click();
                break;
            case "adult":
                adultRadio.click();
                break;
        }
    }

    public void clickSearch() {
        searchButton.click();
    }

    public boolean isErrorVisible(WebElement errorElement) {
        return errorElement.isDisplayed() && !errorElement.getText().isEmpty();
    }
    
    public List<WebElement> getSearchResults() {
        return bookResults;
    }
}
