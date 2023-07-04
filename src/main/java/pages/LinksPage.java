package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LinksPage extends BasePage {
    private WebElement homeLink;

    public LinksPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getHomeLink() {
        return getDriver().findElement(By.id("simpleLink"));
    }

    public void clickHomeLink() {
        getHomeLink().click();
    }

    public void open() {
        getDriver().get("https://demoqa.com/links");
    }
}
