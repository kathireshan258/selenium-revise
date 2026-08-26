package selenium.test1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;


class WebTables {

    private static WebDriver DRIVER;
    static String URL = "https://money.rediff.com/tools/forex";
    static int PAGELOAD_TIMEOUT = 30, IMPLICITWAIT_TIMEOUT = 30, EXPLICITWAIT_TIMEOUT = 30;
    static void main(String[] args) {
        initializeBrowser(Browsers.CHROME);
        DRIVER.get(URL);
        initImplicitWait(IMPLICITWAIT_TIMEOUT);
        initPageLoadTimeout(PAGELOAD_TIMEOUT);
        DRIVER.manage().window().maximize();
        List<WebElement> thead = DRIVER.findElements(By.cssSelector("table thead tr th"));
        for (WebElement th : thead) {
            System.out.println(th.getText());
        }

        List<WebElement> tbody = DRIVER.findElements(By.cssSelector("table tbody tr td"));
        for (WebElement td : tbody) {
            System.out.println(td.getText());
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        DRIVER.quit();
    }


    private static void initializeBrowser(Browsers browser) {
        switch (browser) {
            case Browsers.EDGE -> {
                System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")
                        + "/driver/msedgedriver.exe");
                DRIVER = new EdgeDriver();
            }
            case Browsers.CHROME -> {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
                        + "/driver/chromedriver.exe");
                DRIVER = new ChromeDriver();
            }
        }
    }

    private enum Browsers {
        CHROME,
        EDGE
    }

    private static void initImplicitWait(int seconds) {
        DRIVER.manage().timeouts().implicitlyWait(
                Duration.ofSeconds(seconds)
        );
    }

    private static void initPageLoadTimeout(int seconds) {
        DRIVER.manage().timeouts().pageLoadTimeout(
                Duration.ofSeconds(seconds)
        );
    }

    private static WebDriverWait initWebDriverWait(int seconds) {
        return new WebDriverWait(DRIVER,
                Duration.ofSeconds(seconds));
    }
}


