package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class CheckboxPage extends BasePage {
    private ArrayList<WebElement> toggleBtns;
    private WebElement homeCheckboxLabel;
    private WebElement expandBtn;
    private ArrayList<WebElement> treeNodes;
    private WebElement homeCheckbox;

    public CheckboxPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public ArrayList<WebElement> getToggleBtns() {
        return (ArrayList<WebElement>) getDriver().findElements(By.cssSelector("button[title='Toggle']"));
    }

    public WebElement getHomeCheckboxLabel() {
        return getDriver().findElement(By.cssSelector("label[for='tree-node-home']"));
    }

    public WebElement getExpandBtn() {
        return getDriver().findElement(By.cssSelector("button[title='Expand all']"));
    }

    public ArrayList<WebElement> getTreeNodes() {
        return (ArrayList<WebElement>) getDriver().findElements(By.xpath("//label/input"));
    }

    public WebElement getHomeCheckbox() {
        return getDriver().findElement(By.id("tree-node-home"));
    }

    public void clickToggleBtn(int index) {
        getToggleBtns().get(index).click();
    }

    public void clickHomeCheckboxLabel() {
        getHomeCheckboxLabel().click();
    }

    public void clickExpandBtn() {
        getExpandBtn().click();
    }

    public void open() {
        getDriver().get("https://demoqa.com/checkbox");
    }
}
