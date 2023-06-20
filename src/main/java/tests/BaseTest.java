package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.SeleniumTrainingPage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;
    private SeleniumTrainingPage seleniumTrainingPage;

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public JavascriptExecutor getJs() {
        return js;
    }

    public SeleniumTrainingPage getSeleniumTrainingPage() {
        return seleniumTrainingPage;
    }

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;
        seleniumTrainingPage = new SeleniumTrainingPage(driver, wait);
    }

    @BeforeMethod
    public void beforeEachTest() {
        getDriver().manage().window().maximize();
    }

    @AfterClass
    public void cleanup() {
        getDriver().close();
    }

    public void getScreenshotOfElement(WebElement element) throws IOException {
        File file = element.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(file, new File(
                "C:\\Users\\milra\\IdeaProjects\\ITBC_project_MilosRadman\\src\\screenshots\\captchaScreenshot.png"));

    }

    public String fetchTextFromImg(String imgPath) throws TesseractException {
        ITesseract image = new Tesseract();

        image.setDatapath("C:\\Users\\milra\\IdeaProjects\\ITBC_project_MilosRadman\\src\\tesseract");
        image.setLanguage("eng");

        String code = image.doOCR(new File(imgPath));
        return code;
    }
}
