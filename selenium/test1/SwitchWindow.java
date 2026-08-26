package selenium.test1;

import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.Iterator;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;

class SwitchWindow {
    static WebDriver driver;
    static void main(String[] args) {
        final String URL = "https://www.udemy.com/";
        final String browser = "chrome";
        final int implicitWait = 10;
        final int pageLoadTimeout = 30;
        final int webDriverWait = 30;

        initializeBrowser(browser);
        initializeImplicitWait(implicitWait);
        initializePageLoadTimeout(pageLoadTimeout);
        driver.get(URL);
        driver.manage().window().maximize();
        WebElement privacyLink = driver.findElement(By.xpath("//div[@class='structured-links-column']//a[contains(@href,'/terms/privacy/')]"));
        WebDriverWait wait = initializeWebDriverWait(webDriverWait);
        wait.until(ExpectedConditions.visibilityOf(privacyLink));
        privacyLink.sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> windowHandles = driver.getWindowHandles();
        String currentWindow = driver.getWindowHandle();
        Iterator<String> itr = windowHandles.iterator();
        while (itr.hasNext()) {
            String handle = itr.next();
            System.out.println(handle);
            if (!handle.equals(currentWindow)) {
                driver.switchTo().window(handle);
            }
        }
        takeScreenshot("privacy_page");
        try {
            Thread.sleep(Duration.ofSeconds(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

    private static void initializeBrowser(String browser) {
        if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }
    }

    private static void initializeImplicitWait(int seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    private static void initializePageLoadTimeout(int seconds) {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(seconds));
    }

    private static WebDriverWait initializeWebDriverWait(int seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds));
    }

    private static void takeScreenshot(String destName) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File (System.getProperty("user.dir") + "/target/screenshot/"+destName + ".png");
        try {
            Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
