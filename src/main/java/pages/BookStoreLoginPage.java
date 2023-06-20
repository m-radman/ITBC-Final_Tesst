package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookStoreLoginPage extends BasePage {
    private WebElement userNameField;
    private WebElement passwordField;
    private WebElement loginBtn;
    private WebElement newUserBtn;

    public BookStoreLoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getUserNameField() {
        return getDriver().findElement(By.id("userName"));
    }

    public  WebElement getPasswordField() {
        return getDriver().findElement(By.id("password"));
    }

    public WebElement getLoginBtn() {
        return getDriver().findElement(By.id("login"));
    }

    public WebElement getNewUserBtn() {
        return getDriver().findElement(By.id("newUser"));
    }

    public void enterUserName(String username) {
        getUserNameField().sendKeys(username);
    }

    public void enterPassword(String password) {
        getPasswordField().sendKeys(password);
    }

    public void clickLoginBtn() {
        getLoginBtn().click();
    }

    public void clickNewUserBtn() {
        getNewUserBtn().click();
    }

    public void open() {
        getDriver().get("https://demoqa.com/login");
    }
}
