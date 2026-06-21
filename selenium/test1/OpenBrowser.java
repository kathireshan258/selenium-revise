package selenium.test1;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class OpenBrowser {

  private static WebDriver BROWSER_DRIVER = null;

  static void main() {
    initDriver(Drivers.Chrome);
    BROWSER_DRIVER.manage().window().maximize();
    BROWSER_DRIVER.get("https://www.amazon.in/");
    BROWSER_DRIVER.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(2));
    System.out.println("current URL:" + BROWSER_DRIVER.getCurrentUrl());
    System.out.println(BROWSER_DRIVER.getPageSource());
    WebDriverWait wait = new WebDriverWait(BROWSER_DRIVER, Duration.ofMinutes(2));
    wait.until(ExpectedConditions.titleIs("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in"));
    System.out.println("page title:"+ BROWSER_DRIVER.getTitle());
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
    WebElement searchBox = BROWSER_DRIVER.findElement(By.id("twotabsearchtextbox"));
    wait.until(ExpectedConditions.visibilityOf(searchBox));
    System.out.println("SearchBox Placeholder Text: " + searchBox.getAttribute("placeholder"));
    searchBox.sendKeys("headphones");
    searchBox.submit();

    WebElement firstElement = BROWSER_DRIVER.findElement(By.cssSelector("span[data-component-type='s-search-results'] div[role='listitem'][data-component-type='s-search-result'] h2 span"));
    System.out.println("fistElement: " + firstElement.getText());
    firstElement.click();


    List<WebElement> links = BROWSER_DRIVER.findElements(By.tagName("a"));
    System.out.println("links: " + links.size());
    links.forEach(link -> {
      System.out.println("Text::" + link.getText());
      System.out.println("Link Text::" + link.getAttribute("href"));
      VerifyLink.check(link.getAttribute("href"));
    });

//    try {
//      Thread.sleep(30000);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }

    BROWSER_DRIVER.quit();
  }


  static void  initDriver(Drivers driver) {
    final String CWD = System.getProperty("user.dir");
    switch(driver) {
      case Drivers.FireFox -> {
        System.setProperty("webdriver.gecko.driver", CWD + "/driver/geckodriver.exe");
        BROWSER_DRIVER = new FirefoxDriver();
      }

      case Drivers.Edge -> {
        System.setProperty("webdriver.edge.driver", CWD + "/driver/msedgedriver.exe");
        BROWSER_DRIVER = new EdgeDriver();
      }

      default -> {
        System.setProperty("webdriver.chrome.driver", CWD + "/driver/chromedriver.exe");
        BROWSER_DRIVER = new ChromeDriver();
      }
    }
  }


  void initChromeOptionsDriver() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--start-maximized");
    options.addArguments("--disable-notifications");
    options.addArguments("--disable-infobars");
    options. addArguments("--disable-extensions");
    options.addArguments("--ignore-certificate-errors");
    options.addArguments("--user-data-dir=C:\\Users\\Your_Username\\AppData\\\\Local\\Google\\Chrome\\User Data");
    options.addArguments("--incognito");
    options.addArguments("--disable-popup-blocking");
    options.addArguments("--disable-gpu");
    options.addArguments("--no-sandbox");

//    options.setBinary("c:/users/applications/chrome.exe");

//    options.setAcceptInsecureCerts(true);

    // 2. Specify the exact profile folder name inside "User Data" (e.g., "Default" or "Profile 1")
//    options.addArguments("--profile-directory=Default");

    /*
    // use proxy
    Proxy proxy = new Proxy();
    proxy.setHttpProxy("proxy.example.com:8080");
    options.setCapability(CapabilityType.PROXY, proxy);
     */

    BROWSER_DRIVER = new ChromeDriver(options);
  }


  void initFirefoxOptionsDriver() {
    FirefoxOptions options = new FirefoxOptions();
    ProfilesIni profiles = new ProfilesIni();
    FirefoxProfile firefoxProfile = profiles.getProfile("default");
    firefoxProfile.setPreference("dom.webnotifications.enabled", false);
    firefoxProfile.setAcceptUntrustedCertificates(true);
    firefoxProfile.setAssumeUntrustedCertificateIssuer(false);

    options.setProfile(firefoxProfile);
    BROWSER_DRIVER = new FirefoxDriver(options);
  }

}
