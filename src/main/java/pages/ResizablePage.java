package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResizablePage extends BasePage {
    private WebElement resizableBox;
    private WebElement resizeHandle;

    public ResizablePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getResizableBox() {
        return getDriver().findElement(By.id("resizableBoxWithRestriction"));
    }
    public WebElement getResizeHandle() {
        return getDriver().findElement(By.cssSelector("#resizableBoxWithRestriction>span"));
    }

    public void open() {
        getDriver().get("https://demoqa.com/resizable");
    }
}
