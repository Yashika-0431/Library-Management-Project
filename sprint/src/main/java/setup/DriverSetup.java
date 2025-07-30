package setup;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import config.ConfigReader;

public class DriverSetup {
    public static WebDriver webdriver;

    public static WebDriver getDriver() {
        if (webdriver == null) {
            Properties prop = ConfigReader.getProperties();

            String browser = prop.getProperty("browser");
            String driverName = prop.getProperty("drivername");
            String driverPath = prop.getProperty("driverpath");

            if (browser.equalsIgnoreCase("firefox")) {
                System.setProperty(driverName, driverPath);
                webdriver = new FirefoxDriver();
            }else if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty(driverName, driverPath);
                webdriver = new ChromeDriver();
            }

        }
        return webdriver;
    }
}
