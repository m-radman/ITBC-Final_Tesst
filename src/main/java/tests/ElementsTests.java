package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

public class ElementsTests extends BaseTest {
    @Test
    public void verifyDoubleClickBtn() {
        getButtonsPage().open();
        getActions().doubleClick(getButtonsPage().getDoubleClickBtn()).perform();

        Assert.assertTrue(getButtonsPage().getDoubleClickMsg().isDisplayed());
    }

    @Test
    public void verifyRightClickBtn() {
        getButtonsPage().open();
        getActions().contextClick(getButtonsPage().getRightClickBtn()).perform();

        Assert.assertTrue(getButtonsPage().getRightClickMsg().isDisplayed());
    }

    @Test
    public void verifyDynamicClick() {
        getButtonsPage().open();
        getButtonsPage().clickDynamicClickBtn();

        Assert.assertTrue(getButtonsPage().getClickMsg().isDisplayed());
    }

    @Test
    public void verifyRadioButtonsWorkCorrectly() {
        getRadioButtonPage().open();
        getRadioButtonPage().clickImpressiveRadioLabel();
        getRadioButtonPage().clickYesRadioLabel();

        Assert.assertFalse(getRadioButtonPage().getImpressiveRadioBtn().isSelected());
        Assert.assertTrue(getRadioButtonPage().getYesRadioBtn().isSelected());
        Assert.assertEquals("Yes", getRadioButtonPage().getSuccessMsg().getText());
    }

    @Test
    public void verifyNoBtnIsDisabled() {
        getRadioButtonPage().open();

        Assert.assertFalse(getRadioButtonPage().getNoRadioBtn().isEnabled());
    }

    @Test
    public void verifyHomeCheckboxIsChecked() {
        getCheckboxPage().open();

        getCheckboxPage().clickHomeCheckboxLabel();

        Assert.assertTrue(getCheckboxPage().getHomeCheckbox().isSelected());
    }

    @Test
    public void verifyAllNodesAreChecked() {
        getCheckboxPage().open();

        getCheckboxPage().clickHomeCheckboxLabel();
        getCheckboxPage().clickExpandBtn();
        getWait().withTimeout(Duration.ofSeconds(5));

        ArrayList<WebElement> nodes = getCheckboxPage().getTreeNodes();

        Assert.assertEquals(nodes.size(), 17);

        for (WebElement node : nodes) {
            Assert.assertTrue(node.isSelected());
        }
    }

    @Test
    public void verifyNewTabIsOpened() {
        getLinksPage().open();

        getLinksPage().clickHomeLink();

        ArrayList<String> browserTabs = new ArrayList<String>(getDriver().getWindowHandles());

        getDriver().switchTo().window(browserTabs.get(1));

        Assert.assertEquals(getDriver().getCurrentUrl(), "https://demoqa.com/");
    }

    @Test
    public void verifyLinkIsBroken() {
        getBrokenLinksPage().open();

        int response;

        try {
            response = getBrokenLinksPage().getLinkResponseCode(getBrokenLinksPage().getBrokenLink());
            System.out.println(response);
            Assert.assertNotEquals(response, 200);
        } catch (IOException exception){
            System.out.println(exception);
        }
    }

    @Test
    public void verifyImageIsBroken() {
        getBrokenLinksPage().open();

        Assert.assertEquals(getBrokenLinksPage().getBrokenImgLink().getAttribute("naturalWidth"), "0");
    }

    @Test
    public void verifyUploadWorks() {
        getUploadDownloadPage().open();

        getUploadDownloadPage().uploadFile(img.getAbsolutePath());

        Assert.assertTrue(getUploadDownloadPage().getUploadedFilePath().getText().contains("captchaScreenshot"));
    }

    @Test
    public void verifyDownloadWorks() throws InterruptedException {
        getUploadDownloadPage().open();

        getUploadDownloadPage().clickDownloadBtn();
        Thread.sleep(3000);

        Assert.assertTrue(checkFilePresence());
    }
}
