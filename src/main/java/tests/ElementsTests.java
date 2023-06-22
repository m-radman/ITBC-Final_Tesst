package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

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
}
