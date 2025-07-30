package StepDefination;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import config.ConfigReader;
import pages.SearchBook;
import io.cucumber.java.en.*;
import setup.DriverSetup;
import utils.ExcelReader;

public class SearchBookStepDef {

    WebDriver driver = DriverSetup.getDriver();
    SearchBook searchPage;
    Properties prop = ConfigReader.getProperties();
    
    @Given("user is on the search page")
    public void user_is_on_the_search_page() {
    	
    	String url = prop.getProperty("searchurl");
    	System.out.println(url);
        driver.get(url); 
        searchPage = new SearchBook(driver);
    }

    @When("user leaves all fields empty and clicks search")
    public void user_leaves_all_fields_empty_and_clicks_search() {
        searchPage.clickSearch();
    }

    @Then("error messages should appear for all mandatory fields")
    public void error_messages_should_appear_for_all_mandatory_fields() {
        Assert.assertTrue(searchPage.isErrorVisible(searchPage.authorError), "Author error not shown");
        Assert.assertTrue(searchPage.isErrorVisible(searchPage.subjectError), "Subject error not shown");
        Assert.assertTrue(searchPage.isErrorVisible(searchPage.editionError), "Edition error not shown");
        Assert.assertTrue(searchPage.isErrorVisible(searchPage.formatError), "Format error not shown");
        Assert.assertTrue(searchPage.isErrorVisible(searchPage.ageError), "Age group error not shown");
    }

    @When("user performs book search for all Excel rows")
    public void user_performs_book_search_for_all_excel_rows() {
        String excelPath = "C:\\Users\\varsh\\Downloads\\SearchBook.xlsx";
        ExcelReader reader = new ExcelReader(excelPath, "SearchBook");

        int rowCount = reader.getRowCount();
        System.out.println("Total rows in Excel: " + rowCount);

        // Track failures
        StringBuilder failures = new StringBuilder();

        for (int i = 1; i < rowCount; i++) {
            System.out.println("\nProcessing row: " + i);

            String author = reader.getCellData(i, 0);
            String subject = reader.getCellData(i, 1);
            String edition = reader.getCellData(i, 2);
            String format = reader.getCellData(i, 3);
            String ageGroup = reader.getCellData(i, 4);

            searchPage.enterAuthor(author);
            searchPage.enterSubject(subject);

            try {
                searchPage.selectEdition(edition);
            } catch (Exception e) {
                System.out.println("Invalid edition: " + edition);
            }

            try {
                searchPage.selectFormat(format);
            } catch (Exception e) {
                System.out.println("Invalid format: " + format);
            }

            try {
                searchPage.selectAgeGroup(ageGroup);
            } catch (Exception e) {
                System.out.println("Invalid age group: " + ageGroup);
            }

            searchPage.clickSearch();

            List<WebElement> books = searchPage.getSearchResults();
            if (books.isEmpty()) {
                System.out.println("❌ No books found for row " + i);
                failures.append("Row ").append(i).append(" failed: No books found\n");
            } else {
                System.out.println("✅ Books found for row " + i);
                for (WebElement book : books) {
                    System.out.println(book.getText());
                }
            }

            // Reload the page for next input
            driver.get(prop.getProperty("searchurl"));
        }

        // Fail at the end if any failures
        if (failures.length() > 0) {
            throw new AssertionError("Some rows failed:\n" + failures.toString());
        }
    }

}
