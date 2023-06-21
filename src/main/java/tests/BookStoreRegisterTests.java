package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class BookStoreRegisterTests extends BaseTest {
    @Test
    public void verifyUserCanRegister() throws InterruptedException {
        getBookStoreLoginPage().open();
        getBookStoreLoginPage().clickNewUserBtn();

        getJs().executeScript("scroll(0, 200)");

        getBookStoreRegisterPage().enterFirstName(getFaker().name().firstName());
        getBookStoreRegisterPage().enterLastName(getFaker().name().lastName());
        getBookStoreRegisterPage().enterUserName(getFaker().name().username());
        getBookStoreRegisterPage().enterPassword(getFaker().internet()
                .password(10, 15, true, true));

        getBookStoreRegisterPage().goToReCaptchaIFrame();
        getBookStoreRegisterPage().clickReCaptchaCheckBox();
        getBookStoreRegisterPage().switchToDefaultFrame();

        Thread.sleep(10000);
        getBookStoreRegisterPage().clickRegisterBtn();

        String alertText = getBookStoreRegisterPage().getAlert().getText();

        Assert.assertTrue(alertText.contains("Successfully"));
    }
}
