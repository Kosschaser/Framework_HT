package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{

    @FindBy(xpath = "//div[@class='gsc-thumbnail-inside']//a/b[text()='Google Cloud Platform Pricing Calculator']/..")
    WebElement searchResultLink;

    public WebElement getSearchResultLink() {
        return searchResultLink;
    }

    public void clickSearchResultLink() {
        searchResultLink.click();
    }

    public SearchPage(WebDriver driver) {
        super(driver);
    }
}
