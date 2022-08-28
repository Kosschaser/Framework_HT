package tests.regression;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.TestDataReader;
import tests.BaseTest;
import utils.Waiters;

public class PricingCalculatorTest extends BaseTest {

    private static final String QUERY = "Google Cloud Platform Pricing Calculator";
    private static final String EMAIL = TestDataReader.getTestData("testData.email");

    @Test
    public void CalculatorTest() throws InterruptedException {
        getHomePage().clickElement(getHomePage().getSearchIcon());
        getHomePage().typeIntoSearchBar(QUERY);
        getHomePage().performSearch();
        Waiters.waitVisibilityOfElement(getDriver(), 10, getSearchPage().getSearchResultLink());
        getSearchPage().clickElement(getSearchPage().getSearchResultLink());
        driver.switchTo().frame(getCalculatorPage().getCalculatorContainer());
        driver.switchTo().frame(getCalculatorPage().getFrameTwo());
        getCalculatorPage().typeIntoQuantityField("4");
        getCalculatorPage().typeIntoInstancesField("");
        getCalculatorPage().clickElement(getCalculatorPage().getSelectOS());
        Waiters.waitVisibilityOfElement(getDriver(), 10, getCalculatorPage().getFreeOSOption());
        getCalculatorPage().clickElement(getCalculatorPage().getFreeOSOption());
        getCalculatorPage().clickElement(getCalculatorPage().getProvisioningModelField());
        Waiters.waitVisibilityOfElement(getDriver(), 10, getCalculatorPage().getProvisioningModelOption());
        getCalculatorPage().clickElement(getCalculatorPage().getProvisioningModelOption());
        getCalculatorPage().clickElement(getCalculatorPage().getSeriesField());
        Waiters.waitVisibilityOfElement(getDriver(), 10, getCalculatorPage().getSeriesOption());
        getCalculatorPage().clickElement(getCalculatorPage().getSeriesOption());
        Waiters.waitClickabilityOfElement(getDriver(), 10, getCalculatorPage().getMachineTypeField());
        getCalculatorPage().clickElement(getCalculatorPage().getMachineTypeField());
        Waiters.waitVisibilityOfElement(getDriver(), 10, getCalculatorPage().getMachineTypeOption());
        getCalculatorPage().clickElement(getCalculatorPage().getMachineTypeOption());
        getCalculatorPage().clickElement(getCalculatorPage().getAddGPUcheck());
//        Waiters.waitVisibilityOfElement(getDriver(), 10, getCalculatorPage().getaddGPUcontainer());
        getCalculatorPage().clickElement(getCalculatorPage().getGPUtypeField());
        Waiters.waitVisibilityOfElement(getDriver(), 10, getCalculatorPage().getGPUtypeOption());
        getCalculatorPage().clickElement(getCalculatorPage().getGPUtypeOption());
        getCalculatorPage().clickElement(getCalculatorPage().getGPUquantityField());
        Waiters.waitVisibilityOfElement(getDriver(), 10, getCalculatorPage().getGPUquantityValue());
        getCalculatorPage().clickElement(getCalculatorPage().getGPUquantityValue());
        getCalculatorPage().clickElement(getCalculatorPage().getSSDfield());
        Waiters.waitVisibilityOfElement(getDriver(), 10, getCalculatorPage().getSSDoption());
        getCalculatorPage().clickElement(getCalculatorPage().getSSDoption());
        getCalculatorPage().clickElement(getCalculatorPage().getDatacenterField());
        Waiters.waitVisibilityOfElement(getDriver(), 10, getCalculatorPage().getDatacenterOption());
        getCalculatorPage().clickElement(getCalculatorPage().getDatacenterOption());
        getCalculatorPage().clickElement(getCalculatorPage().getUsageField());
        Waiters.waitVisibilityOfElement(getDriver(), 10, getCalculatorPage().getUsageOption());
        getCalculatorPage().clickElement(getCalculatorPage().getUsageOption());
        getCalculatorPage().clickElement(getCalculatorPage().getAddToEstimateButton());
        Waiters.waitVisibilityOfElement(getDriver(), 10, getCalculatorPage().getResultBlockContainer());

        String estimate = getCalculatorPage().getTotalEstimate();

        driver.switchTo().defaultContent();
        driver.switchTo().frame(getCalculatorPage().getCalculatorContainer());
        driver.switchTo().frame(getCalculatorPage().getFrameTwo());

        getCalculatorPage().moveToElement(getCalculatorPage().getSendToEmailButton());
        getCalculatorPage().clickElement(getCalculatorPage().getSendToEmailButton());
        String originalTab = driver.getWindowHandle();

        ((JavascriptExecutor)driver).executeScript("window.open()");

        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalTab.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        driver.get("https://yopmail.com/");
        String emailTab = driver.getWindowHandle();

        getEmailPage().typeMail(EMAIL);
        getEmailPage().clickElement(getEmailPage().getEmailApproveButton());

        String emailName = getEmailPage().getEmailName().getText();
        driver.switchTo().window(originalTab);
        driver.switchTo().frame(getCalculatorPage().getCalculatorContainer());
        driver.switchTo().frame(getCalculatorPage().getFrameTwo());
        getCalculatorPage().typeEmailSendTo(emailName);
        getCalculatorPage().clickElement(getCalculatorPage().getSendEstimateToEmail());

        driver.switchTo().window(emailTab);
        Thread.sleep(5000);
        ((JavascriptExecutor)driver).executeScript("if(chkl())r();");
        driver.switchTo().frame(getEmailPage().getInboxFrame());
        getEmailPage().clickElement(getEmailPage().getGoogleLetter());

        driver.switchTo().defaultContent();
        driver.switchTo().frame(getEmailPage().getBodyMailFrame());
        String estimatedOnMail = getEmailPage().getEstimatedSumFromEmail();
        System.out.println(estimate + " " + estimatedOnMail);
        Assert.assertEquals(estimate, estimatedOnMail);
    }

}
