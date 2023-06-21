package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTrainingPage extends BasePage{
    private WebElement goToRegFormBtn;
    private WebElement firstNameField;
    private WebElement lastNameField;
    private WebElement emailField;
    private  WebElement mobileField;
    private WebElement countrySelect;
    private WebElement cityField;
    private WebElement messageTextArea;
    private  WebElement codeField;
    private WebElement captchaCodeImg;
    private WebElement sendFormBtn;
    private WebElement successMsg;

    public SeleniumTrainingPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getRegFormBtn() {
        return getDriver().findElement(By.xpath("//a[contains(text(), 'Registration')]"));
    }

    public WebElement getFirstNameField() {
        return getDriver().findElement(By.id("first-name"));
    }

    public WebElement getLastNameField() {
        return getDriver().findElement(By.id("last-name"));
    }

    public WebElement getEmailField() {
        return  getDriver().findElement(By.id("email"));
    }

    public WebElement getMobileField() {
        return getDriver().findElement(By.id("mobile"));
    }

    public WebElement getCountrySelect() {
        return getDriver().findElement(By.id("country"));
    }

    public WebElement getCityField() {
        return getDriver().findElement(By.id("city"));
    }

    public WebElement getMessageTextArea() {
        return getDriver().findElement(By.id("message"));
    }

    public WebElement getCodeField() {
        return getDriver().findElement(By.id("code"));
    }

    public WebElement getSendFormBtn() {
        return getDriver().findElement(By.xpath("//button[contains(text(), 'Send')]"));
    }

    public WebElement getCaptchaCodeImg() {
        return getWait().until(ExpectedConditions.visibilityOf(
                getDriver().findElement(By.xpath("//img[@src='/captcha']"))));
    }

    public WebElement getSuccessMsg() {
        return getWait().until(ExpectedConditions.visibilityOf(
                getDriver().findElement(By.xpath("//div[contains(text(), 'get in touch')]"))));
    }

    public void clickRegFormBtn() {
        getWait().until(ExpectedConditions.elementToBeClickable(getRegFormBtn())).click();
    }

    public void enterFirstName(String firstName) {
        getFirstNameField().sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        getLastNameField().sendKeys(lastName);
    }

    public void enterEmail(String email) {
        getEmailField().sendKeys(email);
    }

    public void enterMobileNumber(String mobileNumber) {
        getMobileField().sendKeys(mobileNumber);
    }

    public void selectCountry(String country) {
        Select select = getSelect();
        select = new Select(getCountrySelect());
        select.selectByVisibleText(country);
    }

    public void enterCity(String city) {
        getCityField().sendKeys(city);
    }

    public void enterMessage(String message) {
        getMessageTextArea().sendKeys(message);
    }

    public void enterCode(String code) {
        getCodeField().sendKeys(code);
    }

    public void clickSendFormBtn() {
        getSendFormBtn().click();
    }

    public void open() {
        getDriver().get("https://www.toolsqa.com/selenium-training/");
    }
}
