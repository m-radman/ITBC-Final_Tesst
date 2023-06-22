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

        getBookStoreRegisterPage().enterFirstName(getFaker().name().firstName());
        getBookStoreRegisterPage().enterLastName(getFaker().name().lastName());
        getBookStoreRegisterPage().enterUserName(getFaker().name().username());
        getBookStoreRegisterPage().enterPassword(getFaker().internet()
                .password(8, 12, true, true, true));

        getBookStoreRegisterPage().goToReCaptchaIFrame();
        getBookStoreRegisterPage().clickReCaptchaCheckBox();
        getBookStoreRegisterPage().switchToDefaultFrame();

        Thread.sleep(10000);
        getBookStoreRegisterPage().clickRegisterBtn();

        Thread.sleep(5000);
        getAlert().accept();
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

    @Test
    public void verifyUserCanDeleteBookFromCollection() {
        getBookStoreLoginPage().open();
        getBookStoreLoginPage().enterUserName("MR");
        getBookStoreLoginPage().enterPassword("Titikaka99!");
        getBookStoreLoginPage().clickLoginBtn();

        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

        getBookStoreProfilePage().getDeleteBookBtns().get(0).click();
        getBookStoreProfilePage().clickModalOkBtn();

        String alertText = getAlert().getText();
        Assert.assertTrue(alertText.contains("deleted"));
        getAlert().accept();
    }
}
