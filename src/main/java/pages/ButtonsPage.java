package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ButtonsPage extends BasePage {
    private WebElement doubleClickBtn;
    private WebElement rightClickBtn;
    private WebElement clickBtn;
    private WebElement doubleClickMsg;
    private WebElement rightClickMsg;
    private WebElement clickMsg;

    public ButtonsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getDoubleClickBtn() {
        return getWait().until(ExpectedConditions.elementToBeClickable(getDriver().findElement(By.id("doubleClickBtn"))));
    }

    public WebElement getRightClickBtn() {
        return getWait().until(ExpectedConditions.elementToBeClickable(getDriver().findElement(By.id("rightClickBtn"))));
    }

    public WebElement getClickBtn() {
        return getWait().until(ExpectedConditions.elementToBeClickable(getDriver().findElement(By.xpath("//button[text()='Click Me']"))));
    }

    public WebElement getDoubleClickMsg() {
        return getWait().until(ExpectedConditions.visibilityOf(getDriver().findElement(By.id("doubleClickMessage"))));
    }

    public WebElement getRightClickMsg() {
        return getWait().until(ExpectedConditions.visibilityOf(getDriver().findElement(By.id("rightClickMessage"))));
    }

    public WebElement getClickMsg() {
        return getWait().until(ExpectedConditions.visibilityOf(getDriver().findElement(By.id("dynamicClickMessage"))));
    }

    public void clickDynamicClickBtn() {
        getClickBtn().click();
    }

    public void open() {
        getDriver().get("https://demoqa.com/buttons");
    }
}
