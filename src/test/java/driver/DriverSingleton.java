package driver;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;

public class DriverSingleton {

    private static WebDriver driver;

    private DriverSingleton() {}

    public static WebDriver getDriver() {
        if (driver == null) {
            if(Objects.equals(System.getProperty("browser"), "chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if(Objects.equals(System.getProperty("browser"), "firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
        }
        driver.manage().window().maximize();
        return driver;
    }

    public static void closeBrowser() {
        driver.quit();
        driver = null;
    }

}
