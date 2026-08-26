package selenium.test1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.interactions.Actions;

class MouseKeyboardActions {
    private static WebDriver driver;
    static void main(String[] args) {
        final String browser = "chrome";
        int implicitlyWait = 30;
        int pageLoadTimeout = 30;
        final String URL = "https://udemy.com";

        initBrowserDriver(browser);
        initializeImplicitWait(implicitlyWait);
        initializePageLoadTimeout(pageLoadTimeout);

        driver.get(URL);
        WebElement teachUdemy = driver.findElements(By.xpath("//*[text()='Teach on Udemy']")).getFirst();
        driver.manage().window().minimize();
        WebDriverWait wait = initializeWebDriverWait(20);
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);
        actions.moveToElement(teachUdemy).perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

    private static void initBrowserDriver(String browser) {
        String currentPath = System.getProperty("user.dir");
        switch (browser) {

            case "firefox" -> {
                System.setProperty("webdriver.gecko.driver", currentPath + "/driver/gecko.exe");
                driver = new FirefoxDriver();
            }

            case "edge" -> {
                System.setProperty("webdriver.edge.driver", currentPath + "/driver/msedgedriver.exe");
                driver = new EdgeDriver();
            }

            default -> {
                System.setProperty("webdriver.chrome.driver", currentPath + "/driver/chromedriver.exe");
                driver = new ChromeDriver();
            }
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
}
