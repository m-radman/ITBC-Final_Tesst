package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

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
}
