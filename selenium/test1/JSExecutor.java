package selenium.test1;

import java.time.Duration;

import org.jspecify.annotations.NonNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

class JSExecutor {
    private static WebDriver driver;
    static void main(String[] args) {
        setDriver(Driver.CHROME);
        setImplicitWait(30);
        setPageLoadWait(30);
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.location='https://rediff.com'");
        String title = (String) js.executeScript("return document.title");
        System.out.println(title);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

    static void setDriver(Driver _driver) {
        String currentLoc = System.getProperty("user.dir");
        switch (_driver) {
            case Driver.CHROME -> {
                System.setProperty("webdriver.chrome.driver", currentLoc + "/driver/chromedriver.exe");
                ChromeOptions options = getChromeOptions();
                driver = new ChromeDriver(options);
            }
            default -> {
                System.setProperty("webdriver.edge.driver", currentLoc + "/driver/msedgedriver.exe");
            }
        }
    }

    private static @NonNull ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-notifications");
//        options.addArguments("--headless=new");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-infobars"); // right now not support,
        // it is to remove the banner showing browser controlled by automated test software
        return options;
    }

    enum Driver {
        CHROME,
        EDGE
    }

    private static void setImplicitWait(int seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    private static void setPageLoadWait(int seconds) {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(seconds));
    }

    private static WebDriverWait getDriverWait(int seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds));
    }
}
