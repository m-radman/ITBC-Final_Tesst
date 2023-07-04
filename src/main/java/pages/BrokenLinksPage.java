package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class BrokenLinksPage extends BasePage {
    private WebElement brokenImgLink;
    private WebElement brokenLink;

    public BrokenLinksPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getBrokenImgLink() {
        return getDriver().findElement(By.cssSelector("img[src='/images/Toolsqa_1.jpg']"));
    }

    public WebElement getBrokenLink() {
        return getDriver().findElement(By.xpath("//a[contains(text(), 'Broken')]"));
    }

    public int getLinkResponseCode(WebElement element) throws IOException {
        String source = element.getAttribute("href");

        URL url = new URL(source);
        URLConnection urlConnection = url.openConnection();
        HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
        httpURLConnection.setConnectTimeout(5000);
        httpURLConnection.connect();

        return httpURLConnection.getResponseCode();
    }

    public void open() {
        getDriver().get("https://demoqa.com/broken");
    }
}
