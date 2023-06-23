package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookStoreRegisterPage extends BasePage {
    private WebElement firstNameField;
    private WebElement lastNameField;
    private WebElement userNameField;
    private WebElement passwordField;
    private WebElement registerBtn;
    private WebElement backToLoginBtn;
    private WebElement reCaptchaFrame;
    private WebElement reCaptchaCheckBox;

    public BookStoreRegisterPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getFirstNameField() {
        return getDriver().findElement(By.id("firstname"));
    }

    public WebElement getLastNameField() {
        return getDriver().findElement(By.id("lastname"));
    }

    public WebElement getUserNameField() {
        return getDriver().findElement(By.id("userName"));
    }

    public WebElement getPasswordField() {
        return getDriver().findElement(By.id("password"));
    }

    public WebElement getRegisterBtn() {
        return getDriver().findElement(By.id("register"));
    }

    public WebElement getBackToLoginBtn() {
        return getDriver().findElement(By.id("gotologin"));
    }

    public WebElement getReCaptchaFrame() {
        return getDriver().findElement(By.xpath("//iframe[@title='reCAPTCHA']"));
    }

    public WebElement getReCaptchaCheckBox() {
        getWait().until(ExpectedConditions.presenceOfElementLocated(By.id("recaptcha-anchor")));
        return getWait().until(ExpectedConditions.elementToBeClickable(By.id("recaptcha-anchor")));
    }

    public void enterFirstName(String firstname) {
        getFirstNameField().sendKeys(firstname);
    }

    public void enterLastName(String lastname) {
        getLastNameField().sendKeys(lastname);
    }

    public void enterUserName(String username) {
        getUserNameField().sendKeys(username);
    }

    public void enterPassword(String password) {
        getPasswordField().sendKeys(password);
    }

    public void clickRegisterBtn() {
        getRegisterBtn().click();
    }

    public void clickBackToLoginBtn() {
        getBackToLoginBtn().click();
    }

    public void goToReCaptchaIFrame() {
        getWait().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(getReCaptchaFrame()));
    }

    public void switchToDefaultFrame() {
        getDriver().switchTo().defaultContent();
    }

    public void clickReCaptchaCheckBox() {
        getReCaptchaCheckBox().click();
    }

    public void open() {
        getDriver().get("https://demoqa.com/register");
    }
}
