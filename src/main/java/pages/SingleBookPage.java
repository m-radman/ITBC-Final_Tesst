package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SingleBookPage extends BasePage {
    private WebElement addBookBtn;
    private WebElement profileWrapper;

    public SingleBookPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getAddBookBtn() {
        return getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(), 'Collection')]")));
    }

    public WebElement getProfileWrapper() {
        return getWait().until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.profile-wrapper")));
    }

    public void clickAddBookBtn() {
        getAddBookBtn().click();
    }
}
