package selenium.test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

class Iframe {
  static WebDriver BROWSER_DRIVER;
  static void main() {
    final String url = "https://jqueryui.com/controlgroup/";
    initDriver(Drivers.Chrome);
    BROWSER_DRIVER.get(url);

    log(LogType.INFO, "Starting Browser::" + Drivers.Chrome.name());
    WebDriverWait wait = new  WebDriverWait(BROWSER_DRIVER, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.titleContains("jQuery UI"));
    log(LogType.SUCCESS, "Tile present::" + BROWSER_DRIVER.getTitle());


    WebElement controlGrpIframe = BROWSER_DRIVER.findElement(By.xpath("//iframe[contains(@src, 'controlgroup')]"));
    BROWSER_DRIVER.switchTo().frame(controlGrpIframe);
    WebElement stdRdBtnLbl = BROWSER_DRIVER.findElement(By.xpath("//label[@for='transmission-standard']"));
    wait.until(ExpectedConditions.elementToBeClickable(stdRdBtnLbl));
    stdRdBtnLbl.click();

    WebElement stdRdBtn = BROWSER_DRIVER.findElement(By.xpath("//input[@id='transmission-standard']"));

    if(stdRdBtn.isSelected()) {
      log(LogType.SUCCESS, "Standard Button is selected");
    } else {
      log(LogType.ERROR, "Standard Button is not selected");
    }

    WebElement compactCarDrpDwn = BROWSER_DRIVER.findElement(By.xpath("//select[@id='car-type']"));
    compactCarDrpDwn.click();
    if (compactCarDrpDwn.isSelected()) {
      log(LogType.SUCCESS, "Compact car grp is selected");
    } else {
      log(LogType.ERROR, "Compact car grp is not selected");
    }

    BROWSER_DRIVER.quit();
  }

  private static void initDriver(Drivers drivers) {
    final int _pageLoadTimeout = 30, _implicitlyWait = 30;

    switch (drivers) {
      case Drivers.Edge -> BROWSER_DRIVER = new EdgeDriver();
      case Drivers.FireFox -> BROWSER_DRIVER = new FirefoxDriver();
      default -> BROWSER_DRIVER = new ChromeDriver();
    }

    BROWSER_DRIVER.manage().window().maximize();
    BROWSER_DRIVER.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(_pageLoadTimeout));
    BROWSER_DRIVER.manage().timeouts().implicitlyWait(Duration.ofSeconds(_implicitlyWait));
  }

  private static void log(LogType logType, String message) {
    final int repeatCount = 100;
    IntConsumer separator = (_repeatCount) -> {
      int letters = " log ".length();
      System.out.println("*".repeat((_repeatCount/2) - letters/2 ) + " LOG " +
          "*".repeat(_repeatCount/2 - letters/2));
    };

    Runnable separatorTwo = () -> {
      System.out.println("=".repeat(repeatCount));
    };

    separator.accept(repeatCount);

    switch (logType) {
//      case INFO ->  System.out.println("[" + logType.name() +"]: " + message);
      //instead of printing using name() you can format it using toString method in the constructor
      // and get the final version

      case INFO ->  System.out.println(logType.toString() + message);
      case ERROR ->  System.err.println(logType.toString() + message);
      case SUCCESS ->  System.out.println(logType.toString() + message);
      case FAILED ->   System.out.println(logType.toString() + message);
    }

    separatorTwo.run();
  }

  private enum LogType {
    INFO,
    ERROR,
    SUCCESS,
    FAILED;

    @Override
    public String toString() {
      return "[" + name() + "]::";
    }
  }
}
