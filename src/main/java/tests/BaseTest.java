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
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.HashMap;

public class BaseTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;
    private Faker faker;
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
    private CheckboxPage checkboxPage;
    private LinksPage linksPage;
    private BrokenLinksPage brokenLinksPage;
    private UploadDownloadPage uploadDownloadPage;
    private DroppablePage droppablePage;

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

    public CheckboxPage getCheckboxPage() {
        return checkboxPage;
    }

    public LinksPage getLinksPage() {
        return linksPage;
    }

    public BrokenLinksPage getBrokenLinksPage() {
        return brokenLinksPage;
    }

    public UploadDownloadPage getUploadDownloadPage() {
        return uploadDownloadPage;
    }

    public DroppablePage getDroppablePage() {
        return droppablePage;
    }

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File(
                "src/extensions/mpbjkejclgfgadiemmefgebjfooflfhl.crx"));

        Path currentRelativePath = Paths.get("src/screenshots");
        String downloadPath = currentRelativePath.toAbsolutePath().toString();

        HashMap<String, Object> chromePref = new HashMap<String, Object>();
        chromePref.put("download.default_directory", downloadPath);
        options.setExperimentalOption("prefs", chromePref);

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
        checkboxPage = new CheckboxPage(driver, wait);
        linksPage = new LinksPage(driver, wait);
        brokenLinksPage = new BrokenLinksPage(driver, wait);
        uploadDownloadPage = new UploadDownloadPage(driver, wait);
        droppablePage = new DroppablePage(driver, wait);
    }

    @BeforeMethod
    public void beforeEachTest() {
        getDriver().manage().window().maximize();
    }

    @AfterClass
    public void cleanup() {
        getDriver().quit();
    }

    public void getScreenshotOfElement(WebElement element) throws IOException {
        File file = element.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(file, new File(
                "src/screenshots/captchaScreenshot.png"));

    }

    public String fetchTextFromImg(String imgPath) throws TesseractException {
        ITesseract image = new Tesseract();

        image.setDatapath("src/tesseract");
        image.setLanguage("eng");

        String code = image.doOCR(new File(imgPath));
        return code;
    }

    public boolean checkFilePresence() {
        File directory = new File("src/screenshots");
        File[] filesList = directory.listFiles();

        for (File file : filesList) {
            if(file.getName().contains("sampleFile")) {
                return true;
            }
        }
        return false;
    }

    File img = new File("src/screenshots/captchaScreenshot.png");
}
