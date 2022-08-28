package tests;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.CalculatorPage;
import pages.EmailPage;
import pages.HomePage;
import pages.SearchPage;
import utils.TestListener;

@Listeners({TestListener.class})
public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod()
    public void setUp() {
        driver = DriverSingleton.getDriver();
        driver.get("https://cloud.google.com/");

    }

    @AfterMethod()
    public void tearDown() {
        DriverSingleton.closeBrowser();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public HomePage getHomePage() {
        return new HomePage(getDriver());
    }

    public SearchPage getSearchPage() {
        return new SearchPage(getDriver());
    }

    public CalculatorPage getCalculatorPage() {
        return new CalculatorPage(getDriver());
    }

    public EmailPage getEmailPage() {
        return new EmailPage(getDriver());
    }
}
