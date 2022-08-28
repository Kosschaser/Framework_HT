package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EmailPage extends BasePage{

    @FindBy(id = "login")
    WebElement emailLogin;

    @FindBy(xpath = "//div[@id='refreshbut']/button")
    WebElement emailApproveButton;

    @FindBy(xpath = "//div[@class='bname']")
    WebElement emailName;

    @FindBy(xpath = "//button[@id='refresh']/..")
    WebElement emailRefresh;

    @FindBy(name = "ifinbox")
    WebElement inboxFrame;

    @FindBy(name = "ifmail")
    WebElement bodyMailFrame;

    @FindBy(className = "lmf")
    List<WebElement> letters;

    @FindBy(xpath = "//div[@id='mail']//h3")
    List<WebElement> estimatedSum;

    public String getEstimatedSumFromEmail() {
        for (WebElement el: estimatedSum) {
            if (el.getText().contains("USD")){
                return el.getText();
            }
        }
        return null;
    }

    public WebElement getGoogleLetter() {
        for (WebElement el:
             letters) {
            if(el.getText().contains("Google")) {
                return el;
            }
        }
        return null;
    }

    public WebElement getInboxFrame() {
        return inboxFrame;
    }

    public WebElement getBodyMailFrame() {
        return bodyMailFrame;
    }

    public WebElement getEmailRefresh() {
        return emailRefresh;
    }

    public WebElement getEmailName() {
        return emailName;
    }

    public void typeMail(String email) {
        emailLogin.sendKeys(email);
    }

    public WebElement getEmailApproveButton() {
        return emailApproveButton;
    }

    public EmailPage(WebDriver driver) {
        super(driver);
    }

}
