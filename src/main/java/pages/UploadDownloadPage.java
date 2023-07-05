package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UploadDownloadPage extends BasePage {
    private WebElement uploadBtn;
    private WebElement uploadedFilePath;
    private WebElement downloadBtn;

    public UploadDownloadPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getUploadBtn() {
        return getDriver().findElement(By.id("uploadFile"));
    }

    public WebElement getUploadedFilePath() {
        return getWait().until(ExpectedConditions.presenceOfElementLocated(By.id("uploadedFilePath")));
    }

    public WebElement getDownloadBtn() {
        return getDriver().findElement(By.xpath("//a[text()='Download']"));
    }

    public void uploadFile(String path) {
        getUploadBtn().sendKeys(path);
    }

    public void clickDownloadBtn() {
        getDownloadBtn().click();
    }

    public void open() {
        getDriver().get("https://demoqa.com/upload-download");
    }
}
