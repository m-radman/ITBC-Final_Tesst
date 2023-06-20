package tests;

import net.sourceforge.tess4j.TesseractException;
import org.testng.annotations.Test;

import java.io.IOException;

public class SeleniumTrainingTests extends BaseTest{
    @Test
    public void verifyUserCanEnrollForTraining() throws IOException, TesseractException {
        getSeleniumTrainingPage().open();
        getSeleniumTrainingPage().clickRegFormBtn();
        getScreenshotOfElement(getSeleniumTrainingPage().getCaptchaCodeImg());

        getSeleniumTrainingPage().enterFirstName("Milos");
        getSeleniumTrainingPage().enterLastName("Radman");
        getSeleniumTrainingPage().enterEmail("mr@email.com");
        getSeleniumTrainingPage().enterMobileNumber("2223335");
        getSeleniumTrainingPage().selectCountry("Serbia");
        getSeleniumTrainingPage().enterCity("Novi Sad");
        getSeleniumTrainingPage().enterMessage("Hello.");

        String code = fetchTextFromImg(
                "C:\\Users\\milra\\IdeaProjects\\ITBC_project_MilosRadman\\src\\screenshots\\captchaScreenshot.png");

        getSeleniumTrainingPage().enterCode(code);
        getSeleniumTrainingPage().clickSendFormBtn();
    }
}
