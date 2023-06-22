package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class BookStorePage extends BasePage {
    private ArrayList<WebElement> booksList;

    public BookStorePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public ArrayList<WebElement> getBooksList() {
        return (ArrayList<WebElement>) getWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("span.mr-2")));
    }

    public void open() {
        getDriver().get("https://demoqa.com/books");
    }
}
