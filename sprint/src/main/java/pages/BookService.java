package pages;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class BookService {

    WebDriver driver;

    public BookService(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "bookscontainer")
    private List<WebElement> books;


    @FindBy(id = "searchbox")
    private WebElement searchInput;

    public int getBooksCount() {
        return books.size();
    }

    public void printAllBooks() {
        for (WebElement book : books) {
            System.out.println(book.getText().trim());
        }
    }

    public void searchBooks(String keyword) {
        searchInput.clear();
        searchInput.sendKeys(keyword);
        //searchInput.sendKeys(Keys.ENTER); 
    }
}
