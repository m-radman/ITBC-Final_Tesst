package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class BookStoreProfilePage extends BasePage {
    private ArrayList<WebElement> deleteBookBtns;
    private WebElement modalOkBtn;
    private WebElement gotoStoreBtn;

    public BookStoreProfilePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public ArrayList<WebElement> getDeleteBookBtns() {
        return (ArrayList<WebElement>) getWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("delete-record-undefined")));
    }

    public WebElement getModalOkBtn() {
        return getWait().until(ExpectedConditions.elementToBeClickable(getDriver().findElement(By.id("closeSmallModal-ok"))));
    }

    public WebElement getGotoStoreBtn() {
        return getDriver().findElement(By.id("gotoStore"));
    }

    public void clickModalOkBtn() {
        getModalOkBtn().click();
    }

    public void open() {
        getDriver().get("https://demoqa.com/profile");
    }
}
