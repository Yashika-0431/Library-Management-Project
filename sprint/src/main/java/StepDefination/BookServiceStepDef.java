package StepDefination;

import io.cucumber.java.en.*;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import config.ConfigReader;
import pages.BookService;
import setup.DriverSetup;

public class BookServiceStepDef {

    WebDriver driver = DriverSetup.getDriver();
    BookService booksService = new BookService(driver);
    Properties prop = ConfigReader.getProperties();
    
    @Given("user is on the Book section")
    public void user_is_on_book_section() {
    	String url = prop.getProperty("bookurl");
        driver.get(url);
    }

    @Then("list of books should be displayed")
    public void list_of_books_should_be_displayed() {
        Assert.assertTrue(booksService.getBooksCount() > 0, "No books are displayed in the section.");
    }

    
    @When("user enters {string} as search keyword")
    public void user_enters_search_keyword(String keyword) {
        booksService.searchBooks(keyword);
    }

    @Then("relevant books should be displayed")
    public void relevant_books_should_be_displayed() {
        Assert.assertTrue(booksService.getBooksCount() > 0, "No relevant books displayed.");
        booksService.printAllBooks();
    }
}
