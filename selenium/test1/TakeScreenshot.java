package selenium.test1;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

class TakeScreenshot {

    private static WebDriver driver;

    private static void takeScreenShot(final String dest) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File(dest);
        try {
            Files.copy(src.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
