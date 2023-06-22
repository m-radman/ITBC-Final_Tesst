package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RadioButtonPage extends BasePage {
    private WebElement yesRadioLabel;
    private WebElement impressiveRadioLabel;
    private WebElement noRadioLabel;
    private WebElement yesRadioBtn;
    private WebElement impressiveRadioBtn;
    private WebElement noRadioBtn;
    private  WebElement successMsg;

    public RadioButtonPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getYesRadioLabel() {
        return getDriver().findElement(By.xpath("//label[contains(text(), 'Yes')]"));
    }

    public WebElement getImpressiveRadioLabel() {
        return getDriver().findElement(By.xpath("//label[contains(text(), 'Impressive')]"));
    }

    public WebElement getNoRadioLabel() {
        return getDriver().findElement(By.xpath("//label[contains(text(), 'No')]"));
    }

    public WebElement getYesRadioBtn() {
        return getDriver().findElement(By.id("yesRadio"));
    }

    public WebElement getImpressiveRadioBtn() {
        return getDriver().findElement(By.id("impressiveRadio"));
    }

    public WebElement getNoRadioBtn() {
        return getDriver().findElement(By.id("noRadio"));
    }

    public WebElement getSuccessMsg() {
        return getWait().until(ExpectedConditions.visibilityOf(getDriver().findElement(By.cssSelector("span.text-success"))));
    }

    public void clickYesRadioLabel() {
        getYesRadioLabel().click();
    }

    public void clickImpressiveRadioLabel() {
        getImpressiveRadioLabel().click();
    }

    public void open() {
        getDriver().get("https://demoqa.com/radio-button");
    }
}
