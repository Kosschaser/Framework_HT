package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "//devsite-search")
    private WebElement searchIcon;

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchBar;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public  WebElement getSearchIcon() {
        return searchIcon;
    }

    public void typeIntoSearchBar(String request) {
        searchBar.sendKeys(request);
    }

    public void performSearch() {
        searchBar.sendKeys(Keys.ENTER);
    }

}
