package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DroppablePage extends BasePage {
    private WebElement dragMeBlock;
    private WebElement dropHereBox;
    private WebElement revertLink;
    private WebElement dropBoxRevertable;
    private WebElement revertableBlock;

    public DroppablePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getDragMeBlock() {
        return getDriver().findElement(By.id("draggable"));
    }

    public WebElement getDropHereBox() {
        return getDriver().findElement(By.cssSelector("#simpleDropContainer>#droppable"));
    }

    public WebElement getDropBoxRevertable() {
        return getWait().until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#revertableDropContainer>#droppable")));
    }

    public WebElement getRevertableBlock() {
        return getWait().until(ExpectedConditions.presenceOfElementLocated(By.id("revertable")));
    }

    public void clickRevertLink() {
        getDriver().findElement(By.id("droppableExample-tab-revertable")).click();
    }

    public void open() {
        getDriver().get("https://demoqa.com/droppable");
    }
}
