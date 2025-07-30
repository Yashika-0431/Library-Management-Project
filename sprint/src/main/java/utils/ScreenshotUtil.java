// File: utils/ScreenshotUtil.java
package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static String takeScreenshot(WebDriver driver, String screenshotName) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String destPath = System.getProperty("user.dir") + "/reports/screenshots/" + screenshotName + "_" + timestamp + ".png";
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.createDirectories(new File(destPath).getParentFile().toPath());
            Files.copy(src.toPath(), new File(destPath).toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destPath;
    }
}
