package tests;

import org.openqa.selenium.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InteractionsTests extends BaseTest {
    @Test
    public void verifyDragAndDropWorks() {
        getDroppablePage().open();

        getActions().dragAndDrop(getDroppablePage().getDragMeBlock(), getDroppablePage().getDropHereBox()).perform();

        Assert.assertEquals(getDroppablePage().getDropHereBox().getText(), "Dropped!");
    }

    @Test
    public void verifyRevertableElement() throws InterruptedException {
        getDroppablePage().open();
        getDroppablePage().clickRevertLink();

        Point location = getDroppablePage().getRevertableBlock().getLocation();

        getActions().dragAndDrop(getDroppablePage().getRevertableBlock(), getDroppablePage().getDropBoxRevertable()).perform();

        Thread.sleep(2000);

        Assert.assertEquals(getDroppablePage().getDropBoxRevertable().getText(), "Dropped!");
        Assert.assertEquals(getDroppablePage().getRevertableBlock().getLocation(), location);
    }

    @Test
    public void verifyResizableElement() {
        getResizablePage().open();

        resizeElement(getResizablePage().getResizeHandle(), 100, 100);

        Assert.assertEquals(getResizablePage().getResizableBox().getRect().getWidth(), 300);
        Assert.assertEquals(getResizablePage().getResizableBox().getRect().getHeight(), 300);
    }
}
