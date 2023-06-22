package tests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;
    private Faker faker;
    private ChromeOptions options;
    private Alert alert;
    private Actions actions;
    private SeleniumTrainingPage seleniumTrainingPage;
    private BookStoreRegisterPage bookStoreRegisterPage;
    private BookStoreLoginPage bookStoreLoginPage;
    private ButtonsPage buttonsPage;
    private RadioButtonPage radioButtonPage;
    private BookStoreProfilePage bookStoreProfilePage;
    private BookStorePage bookStorePage;
    private SingleBookPage singleBookPage;

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public JavascriptExecutor getJs() {
        return js;
    }

    public Faker getFaker() {
        return faker;
    }

    public Alert getAlert() {
        return getWait().until(ExpectedConditions.alertIsPresent());
    }

    public Actions getActions() {
        return actions;
    }

    public SeleniumTrainingPage getSeleniumTrainingPage() {
        return seleniumTrainingPage;
    }

    public BookStoreRegisterPage getBookStoreRegisterPage() {
        return bookStoreRegisterPage;
    }

    public BookStoreLoginPage getBookStoreLoginPage() {
        return bookStoreLoginPage;
    }

    public ButtonsPage getButtonsPage() {
        return buttonsPage;
    }

    public RadioButtonPage getRadioButtonPage() {
        return radioButtonPage;
    }

    public BookStoreProfilePage getBookStoreProfilePage() {
        return bookStoreProfilePage;
    }

    public BookStorePage getBookStorePage() {
        return bookStorePage;
    }

    public SingleBookPage getSingleBookPage() {
        return singleBookPage;
    }

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        options = new ChromeOptions();
        options.addExtensions(new File(
                "C:\\Users\\milra\\IdeaProjects\\ITBC_project_MilosRadman\\src\\extensions\\mpbjkejclgfgadiemmefgebjfooflfhl.crx"));
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;
        faker = new Faker();
        actions = new Actions(driver);
        seleniumTrainingPage = new SeleniumTrainingPage(driver, wait);
        bookStoreRegisterPage = new BookStoreRegisterPage(driver, wait);
        bookStoreLoginPage = new BookStoreLoginPage(driver, wait);
        buttonsPage = new ButtonsPage(driver, wait);
        radioButtonPage = new RadioButtonPage(driver, wait);
        bookStoreProfilePage = new BookStoreProfilePage(driver, wait);
        bookStorePage = new BookStorePage(driver, wait);
        singleBookPage = new SingleBookPage(driver, wait);
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
