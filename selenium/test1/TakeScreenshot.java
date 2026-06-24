package selenium.test1;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

class TakeScreenshot {

    private static WebDriver driver;
    private static final String URL = "https://www.facebook.com/";

    void main() {
        initBrowser(Drivers.Chrome);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(URL);
        wait.until(ExpectedConditions.titleIs("Facebook"));
        WebElement createAcc = driver.findElement(By.xpath("//a[@aria-label='Create new account']"));
        createAcc.click();

        // verify user is in reg page and enter the reg details
        wait.until(ExpectedConditions.urlContains("https://www.facebook.com/reg"));
        WebElement heading = driver.findElement(By.xpath("//span[string()='Get started on Facebook']"));
        if (ExpectedConditions.textToBePresentInElement(heading, "Get started on Facebook").apply(driver)) {
            log(LogType.SUCCESS, "User is in reg page");
            takeScreenShot("reg_page.png");
        } else {
            log(LogType.FAILURE, "User is not in reg page");
            takeScreenShot("reg_page_error.png");
        }

        // Create Account Page
        WebElement createAccMsg = driver.findElement(By.xpath("//span[contains(text(),'Create an account to connect')]"));
        log(LogType.INFO, createAccMsg.getText());

        // Name section (First name and last name)
        WebElement nameLbl = driver.findElement(By.xpath("//span[text()='Name']"));
        log(LogType.INFO, nameLbl.getText());
        WebElement fNameInput = driver.findElement(By.xpath("//label[text()='First name']/preceding-sibling::input"));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(fNameInput));
            fNameInput.click();
            fNameInput.sendKeys("Harry");
            log(LogType.SUCCESS, "First name entered successfully");
            takeScreenShot("first_name_entered.png");
        } catch (TimeoutException t) {
            log(LogType.FAILURE, "Could not enter first name");
            takeScreenShot("first_name_error.png");
        }

        WebElement fNameLbl = driver.findElement(By.xpath("//label[text()='First name']"));
        log(LogType.INFO, fNameLbl.getText());
        WebElement lNameInput = driver.findElement(By.xpath("//label[text()='Surname']/preceding-sibling::input"));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(lNameInput));
            lNameInput.click();
            lNameInput.sendKeys("Potter");
            log(LogType.SUCCESS, "Last name entered successfully");
            takeScreenShot("last_name_entered.png");
        } catch (TimeoutException t) {
            log(LogType.FAILURE, "Could not enter last name");
            takeScreenShot("last_name_error.png");
        }
        WebElement lNameLbl = driver.findElement(By.xpath("//label[text()='Surname']"));
        log(LogType.INFO, lNameLbl.getText());

        // Date of Birth section
        WebElement dobLabel = driver.findElement(By.xpath("//span[text()='Date of birth']"));
        log(LogType.INFO, dobLabel.getText());
        WebElement dobLblInfo = driver.findElement(By.xpath("//div[@aria-haspopup='dialog' and contains(@aria-label, 'date of birth')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(dobLblInfo).click().build().perform();

        // Date of birth info pop up section
        WebElement dobInfoPopUp = driver.findElement(By.xpath("//div[@aria-label='Click for more information']"));
        try {
            wait.until(ExpectedConditions.textToBePresentInElement(dobInfoPopUp, "Providing your date of birth helps make sure that you get the right Facebook experience for your age. If you want to change who sees this, go to the About section of your profile. For more details, please visit our Privacy Policy."));
            log(LogType.SUCCESS, "Date of birth info displayed with expected text");
            log(LogType.INFO, dobInfoPopUp.getText());

            // Privacy policy section in DOB info pop up
            try {
                WebElement privacyPolicyLink = dobInfoPopUp.findElement(By.xpath(".//a"));
                log(LogType.INFO, privacyPolicyLink.getText());
                wait.until(ExpectedConditions.attributeToBe(privacyPolicyLink, "href", "https://www.facebook.com/policy.php"));
                log(LogType.SUCCESS, "Privacy Policy link has correct href");
                String link = privacyPolicyLink.getAttribute("href");

                // Open Privacy policy in new tab
                driver.switchTo().newWindow(WindowType.TAB);
                assert link != null;
                driver.navigate().to(link);
                String currentWindowHandle = driver.getWindowHandle();
                Set<String> handles = driver.getWindowHandles();
                for (String handle : handles) {
                    if(!Objects.equals(handle, currentWindowHandle)) {
                        driver.switchTo().window(handle);
                    }
                }

                // Switch windows and close the window
                List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
                driver.switchTo().window(windowHandles.get(1));
                driver.switchTo().window(windowHandles.get(0));
                driver.switchTo().window(windowHandles.get(1));
                driver.close();
                driver.switchTo().window(windowHandles.get(0));
            } catch (TimeoutException t) {
                log(LogType.FAILURE, "Privacy Policy link does not have correct href");
            }
            takeScreenShot("dob_page.png");
        } catch (TimeoutException e) {
            log(LogType.FAILURE, "Date of birth info not displayed or text did not match");
            takeScreenShot("dob_page_error.png");
        }

        // Day section
        WebElement dayLbl = driver.findElement(By.xpath("//span[text()='Day']/parent::div"));;
        log(LogType.INFO, dayLbl.getText());
        dayLbl.click();

        int randomMonth = selectRandomMonth();
        int randomDate = selectRandomDay(randomMonth);
        int randomYear = selectRandomYear(2010, 1900);
        WebElement dayOption = driver.findElement(By.xpath("//div[@role='option' and @aria-selected='false']//div[text()='"+ randomDate +"']"));;
        dayOption.click();

        // Month section
        WebElement monthLbl = driver.findElement(By.xpath("//span[text()='Month']/parent::div"));
        log(LogType.INFO, monthLbl.getText());
        monthLbl.click();
        List<WebElement> monthOptions = driver.findElements(By.xpath("//div[@aria-label='Select month' and @role='listbox']//div[string-length(text()) > 0]"));
        monthOptions.get(randomMonth >= 12 ? randomMonth - 1 : randomMonth).click();

        monthLbl.click();
        monthOptions = driver.findElements(By.xpath("//div[@aria-label='Select month' and @role='listbox']//div[string-length(text()) > 0]"));
        for (WebElement month : monthOptions) {
            wait.until(ExpectedConditions.visibilityOf(month));
            String monthTxt = month.getText();
            if (monthTxt.equals(getSelectedMonth(randomMonth))) {
                month.click();
                log(LogType.SUCCESS, monthTxt + " selected");
                break;
            } else {
                log(LogType.FAILURE, monthTxt + " not selected");
            }
        }

        // Year section
        WebElement yearLbl = driver.findElement(By.xpath("//span[text()='Year']/parent::div"));
        log(LogType.INFO, yearLbl.getText());
        yearLbl.click();

        List<WebElement> yearOptions = driver.findElements(By.xpath("//div[@aria-label='Select year' and @role='listbox']//div[string-length(text()) > 0]"));
        for(WebElement year: yearOptions) {
            String yearTxt = year.getText();
            if(Integer.parseInt(yearTxt) == randomYear) {
                year.click();
                log(LogType.SUCCESS,  yearTxt + " selected");
                break;
            } else {
                log(LogType.FAILURE, yearTxt + " not selected");
            }
        }

        // Gender section
        WebElement gender = driver.findElement(By.xpath("//span[text()='Gender']"));
        log(LogType.INFO, gender.getText());
        WebElement genderPlaceHolder = driver.findElement(By.xpath("//span[text()='Select your gender']/ancestor::div[@role='combobox']"));
        log(LogType.INFO, genderPlaceHolder.getText());
        genderPlaceHolder.click();

        WebElement genderOption = driver.findElement(By.xpath("//div[contains(@aria-label, 'selecting gender') and @role='listbox']//div[text()='"+ Gender.Male +"']"));
        genderOption.click();
        log(LogType.SUCCESS, Gender.Male + " selected");

        // Mobile number or phone number section
        WebElement mobOrEmailLbl = driver.findElement(By.xpath("//span[text()='Mobile number or email address']"));
        log(LogType.INFO, mobOrEmailLbl.getText());

        WebElement mobOrEmailPlaceHolder = driver.findElement(By.xpath("//input[@type='text' and @value]/following-sibling::label[text()='Mobile number or email address']"));
        log(LogType.INFO, mobOrEmailPlaceHolder.getText());
        WebElement mobOrEmailInput = driver.findElement(By.xpath("//label[text()='Mobile number or email address']/preceding-sibling::input[@type='text' and @value]"));
        mobOrEmailInput.click();
        mobOrEmailInput.sendKeys("1234567890");
        log(LogType.SUCCESS, "Mobile number or email address entered");

        // Password section
        WebElement passLbl = driver.findElement(By.xpath("//span[text()='Password']"));
        log(LogType.INFO, passLbl.getText());

        WebElement passPlaceHolder = driver.findElement(By.xpath("//input[@type='password']/following-sibling::label"));
        if (passPlaceHolder.getText().equals("Password")) {
            log(LogType.SUCCESS, "Valid Password placeholder text present");
        } else {
            log(LogType.FAILURE, "InValid Password placeholder text present");
        }

        WebElement passInput = driver.findElement(By.xpath("//input[@type='password']"));
        passInput.click();
        passInput.sendKeys("YourPasswordHere");
        log(LogType.SUCCESS, "Password entered");

        // submit button
        WebElement submitBtn = driver.findElement(By.xpath("//span[text()='Submit']/ancestor::div[@role='button']"));
        log(LogType.INFO, submitBtn.getText());
        submitBtn.click();

        // finally quit the driver
        log(LogType.INFO, "Quitting the driver");
        driver.quit();
    }

    private static void takeScreenShot(final String dest) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File(System.getProperty("user.dir") + "/target/screenshots/" + dest);
        try {
            Files.copy(src.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void partialScreenShot(WebElement element, String dest) {
        File src = element.getScreenshotAs(OutputType.FILE);
        File destFile = new File(System.getProperty("user.dir") + "target/screenshots/" + dest);
    }

    private static void initBrowser(Drivers _driver) {
        switch (_driver) {
            case Edge -> driver = new EdgeDriver();
            case FireFox -> driver = new FirefoxDriver();
            case null, default -> driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    private static void log(LogType type, String message) {
        switch (type) {
            case FAILURE -> System.err.println(type + message);
            case null, default -> System.out.println(type + message);
        }
    }

    private enum LogType {
        SUCCESS,
        FAILURE,
        INFO;

        @Override
        public String toString() {
            return "[" + name() + "]::";
        }
    }

    private String getSelectedMonth(Object month) {
        if (month instanceof Integer i) {
            return switch (i) {
                case 1 -> "January";
                case 2 -> "February";
                case 3 -> "March";
                case 4 -> "April";
                case 5 -> "May";
                case 6 -> "June";
                case 7 -> "July";
                case 8 -> "August";
                case 9 -> "September";
                case 10 -> "October";
                case 11 -> "November";
                case 12 -> "December";
                default -> throw new IllegalArgumentException("Invalid month: " + month);
            };
        } else if (month instanceof String s) {
            return switch (s) {
              case "January" -> "January";
              case "February" -> "February";
              case "March" -> "March";
              case "April" -> "April";
              case "May" -> "May";
              case "June" -> "June";
              case "July" -> "July";
              case "August" -> "August";
              case "September" -> "September";
              case "October" -> "October";
              case "November" -> "November";
              case "December" -> "December";
              default -> throw new IllegalArgumentException("Invalid month: " + month);
            };
        } else {
            throw new IllegalArgumentException("Invalid month: " + month);
        }
    }

    private int selectRandomMonth() {
        return (int) (Math.random() * 12) + 1;
    }

    private int selectRandomDay(int month) {
        int multiPlied = month == 2 ? 28 : month == 4 || month == 6 || month == 9 || month == 11 ? 30 : 31;
        return (int) (Math.random() * multiPlied) + 1;
    }

    private int selectRandomYear(int maxYear, int minYear) {
        return (int) (Math.random() * ((maxYear - minYear) + 1) + minYear);
    }

    private enum MonthInInt {
        January(1),
        February(2),
        March(3),
        April(4),
        May(5),
        June(6),
        July(7),
        August(8),
        September(9),
        October(10),
        November(11),
        December(12);

        private final int value;
        MonthInInt(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    private enum Gender {
        Male,
        Female,
        Custom
    }
}
