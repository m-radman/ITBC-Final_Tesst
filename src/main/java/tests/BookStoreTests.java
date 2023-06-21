package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class BookStoreTests extends BaseTest {
    @Test(enabled = false)
    public void verifyUserCanRegister() throws InterruptedException {
        getBookStoreLoginPage().open();
        getBookStoreLoginPage().clickNewUserBtn();

        getJs().executeScript("scroll(0, 200)");

        getDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(5));
        getBookStoreRegisterPage().enterFirstName(getFaker().name().firstName());
        getDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(5));
        getBookStoreRegisterPage().enterLastName(getFaker().name().lastName());
        getDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(5));
        getBookStoreRegisterPage().enterUserName(getFaker().name().username());
        getDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(5));
        getBookStoreRegisterPage().enterPassword(getFaker().internet()
                .password(10, 15, true, true));

        getBookStoreRegisterPage().goToReCaptchaIFrame();
        getBookStoreRegisterPage().clickReCaptchaCheckBox();
        getBookStoreRegisterPage().switchToDefaultFrame();

        Thread.sleep(10000);
        getBookStoreRegisterPage().clickRegisterBtn();

        getDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(5));
        String alertText = getBookStoreRegisterPage().getAlert().getText();

        Assert.assertTrue(alertText.contains("Successfully"));
    }

    @Test
    public void verifyUserCanLogIn() {
        getBookStoreLoginPage().open();
        getBookStoreLoginPage().enterUserName("MR");
        getBookStoreLoginPage().enterPassword("Titikaka99!");
        getBookStoreLoginPage().clickLoginBtn();

        getWait().until(ExpectedConditions.urlToBe("https://demoqa.com/profile"));
        Assert.assertTrue(getDriver().getCurrentUrl().contains("/profile"));
    }
}
