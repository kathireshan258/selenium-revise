package handsOn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.ArrayList;
import java.util.List;


class SimpleOne {
  static String BASEURL = "https://www1.bgo.bgdigitaltest.co.uk/identity";
  static String FIREFOX = "firefox";
  static String CHROME = "chrome";
  static String EDGE = "edge";
  static int DEFAULT_WAIT_TIME = 15000;

  static void main(String[] args) {

//    ChromeOptions options = new ChromeOptions();
//    options.addArguments("--disable-infobars");
//    options.addArguments("--force-dark-mode");

//    WebDriver driver = new ChromeDriver(options);

    SimpleOne simpleOne = new SimpleOne();

//    WebDriver driver = simpleOne.setupDrivers(SimpleOne.CHROME);

    List<String> driverOptions = new ArrayList<>();
//    driverOptions.add("--force-dark-mode");
    driverOptions.add("--start-maximized"); // can also use driver.window().maximized();
    driverOptions.add("--incognito");
    driverOptions.add("--disable-extensions");
    driverOptions.add("--disable-infobars");
//    driverOptions.add("--window-size=1920,1080"); // can also use driver.window().setSize();
//    driverOptions.add("--user-data-dir=/path/to/your/custom/profile");

    
    WebDriver driver = simpleOne.setupDrivers(SimpleOne.CHROME, driverOptions);

    driver.get(BASEURL);

    String loginEmail = "autosq7a-dualtrend@yopmail.com";

    try {
      Thread.sleep(DEFAULT_WAIT_TIME);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    driver.quit();

  }

  WebDriver setupDrivers(String browser) {
    WebDriver driver;
    if (browser.equals(SimpleOne.CHROME)) {
      System.setProperty("webdriver.chrome.driver", "C:\\DevelopmentAvecto\\learning\\selenium\\driver\\chromedriver.exe");
      driver = new ChromeDriver();
    } else if (browser.equals(SimpleOne.FIREFOX)) {
      System.setProperty("webdriver.gecko.driver", "C:\\DevelopmentAvecto\\learning\\selenium\\driver\\msedgedriver.exe");
      driver = new FirefoxDriver();
    } else if (browser.equals(SimpleOne.EDGE)) {
      System.setProperty("webdriver.edge.driver", "C:\\DevelopmentAvecto\\learning\\selenium\\driver\\msedgedriver.exe");
      driver = new EdgeDriver();
    } else {
      System.setProperty("webdriver.edge.driver", "C:\\DevelopmentAvecto\\learning\\selenium\\driver\\msedgedriver.exe");
      driver = new EdgeDriver();
    }
    return driver;
  }

  WebDriver setupDrivers(String browser, List<String> options) {
    WebDriver driver;
    if (browser.equals(SimpleOne.CHROME)) {
      System.setProperty("webdriver.chrome.driver", "C:\\DevelopmentAvecto\\learning\\selenium\\driver\\chromedriver.exe");
      ChromeOptions chromeOptions = new ChromeOptions();
      chromeOptions.addArguments(options);
      driver = new ChromeDriver(chromeOptions);
    } else if (browser.equals(SimpleOne.FIREFOX)) {
      System.setProperty("webdriver.gecko.driver", "C:\\DevelopmentAvecto\\learning\\selenium\\driver\\msedgedriver.exe");
      FirefoxOptions firefoxOptions = new FirefoxOptions();
      firefoxOptions.addArguments(options);
      driver = new FirefoxDriver(firefoxOptions);
    } else if (browser.equals(SimpleOne.EDGE)) {
      System.setProperty("webdriver.edge.driver", "C:\\DevelopmentAvecto\\learning\\selenium\\driver\\msedgedriver.exe");
      EdgeOptions edgeOptions = new EdgeOptions();
      edgeOptions.addArguments(options);
      driver = new EdgeDriver(edgeOptions);
    } else {
      System.setProperty("webdriver.edge.driver", "C:\\DevelopmentAvecto\\learning\\selenium\\driver\\msedgedriver.exe");
      EdgeOptions edgeOptions = new EdgeOptions();
      edgeOptions.addArguments(options);
      driver = new EdgeDriver(edgeOptions);
    }
    return driver;
  }
}
