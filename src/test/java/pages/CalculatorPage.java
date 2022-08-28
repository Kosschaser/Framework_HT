package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalculatorPage extends BasePage{

    @FindBy(xpath = "//*[@id=\"cloud-site\"]/devsite-iframe/iframe")
    WebElement FrameOne;

    @FindBy(xpath = "//iframe[@id='myFrame']")
    WebElement FrameTwo;

    @FindBy(xpath = "//input[@ng-model='listingCtrl.computeServer.quantity']")
    WebElement quantityField;

    @FindBy(xpath = "//input[@ng-model='listingCtrl.computeServer.label']")
    WebElement instancesField;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.os']")
    WebElement operatingSystemField;

    @FindBy(xpath = "//md-option[@value='free']")
    WebElement freeOSOption;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.class']")
    WebElement provisioningModelField;

    @FindBy(xpath = "//md-option[@value='regular']")
    WebElement provisioningModelOption;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.series']")
    WebElement seriesField;

    @FindBy(xpath = "//md-option[@value='n1']")
    WebElement seriesOption;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.instance']")
    WebElement machineTypeField;

    @FindBy(xpath = "//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']")
    WebElement machineTypeOption;

    @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']")
    WebElement addGPUcheck;

    @FindBy(xpath = "//div[@ng-if='listingCtrl.computeServer.addGPUs && listingCtrl.checkAvailabilityForThisFamily('isGpuAvailable')']")
    WebElement addGPUcontainer;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.gpuType']")
    WebElement GPUtypeField;

    @FindBy(xpath = "//md-option[@value='NVIDIA_TESLA_V100']")
    WebElement GPUtypeOption;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.gpuCount']")
    WebElement GPUquantityField;

    @FindBy(xpath = "//md-option[@ng-repeat='item in listingCtrl.supportedGpuNumbers[listingCtrl.computeServer.gpuType]' and @value='1']")
    WebElement GPUquantityValue;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.ssd']")
    WebElement SSDfield;

    @FindBy(xpath = "//md-option[@ng-repeat='item in listingCtrl.dynamicSsd.computeServer' and @value='2']")
    WebElement SSDoption;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.location']")
    WebElement DatacenterField;

    @FindBy(xpath = "//*[@id=\"select_option_224\"]")
    WebElement DatacenterOption;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.cud']")
    WebElement UsageField;

    @FindBy(xpath = "//div[@class='md-select-menu-container md-active md-clickable']//md-option[@value='1']")
    WebElement UsageOption;

    @FindBy(xpath = "//button[@aria-label='Add to Estimate']")
    WebElement addToEstimateButton;

    @FindBy(xpath = "//md-card-content[@id='resultBlock']")
    WebElement resultBlockContainer;

    @FindBy(xpath = "//button[@aria-label='Email']")
    WebElement sendToEmailButton;

    @FindBy(xpath = "//input[@ng-model='emailQuote.user.email']")
    WebElement emailSendTo;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    WebElement sendEstimateToEmail;

    @FindBy(xpath = "//*[@id='resultBlock']//h2/b")
    WebElement totalEstimate;

    public String getTotalEstimate() {
        String text = totalEstimate.getText();
        return text.substring(text.indexOf(':') + 1, text.indexOf("per")).trim();
    }

    public WebElement getSendEstimateToEmail() {
        return sendEstimateToEmail;
    }

    public void typeEmailSendTo(String email) {
        emailSendTo.sendKeys(email);
    }

    public WebElement getSendToEmailButton() {
        return sendToEmailButton;
    }

    public WebElement getResultBlockContainer() {
        return resultBlockContainer;
    }

    public WebElement getAddToEstimateButton() {
        return addToEstimateButton;
    }

    public WebElement getDatacenterField() {
        return DatacenterField;
    }

    public WebElement getDatacenterOption() {
        return DatacenterOption;
    }

    public WebElement getUsageField() {
        return UsageField;
    }

    public WebElement getUsageOption() {
        return UsageOption;
    }

    public WebElement getSSDfield() {
        return SSDfield;
    }

    public WebElement getSSDoption() {
        return SSDoption;
    }

    public WebElement getGPUquantityField() {
        return GPUquantityField;
    }

    public WebElement getGPUquantityValue() {
        return GPUquantityValue;
    }

    public WebElement getGPUtypeField() {
        return GPUtypeField;
    }

    public WebElement getGPUtypeOption() {
        return GPUtypeOption;
    }

    public WebElement getAddGPUcheck() {
        return addGPUcheck;
    }

    public WebElement getaddGPUcontainer() {
        return addGPUcontainer;
    }

    public WebElement getCalculatorContainer() {
        return FrameOne;
    }

    public WebElement getFrameTwo() {
        return FrameTwo;
    }

    public WebElement getProvisioningModelField() {
        return provisioningModelField;
    }

    public WebElement getProvisioningModelOption() {
        return provisioningModelOption;
    }

    public WebElement getSeriesField() {
        return seriesField;
    }

    public WebElement getSeriesOption() {
        return seriesOption;
    }

    public WebElement getMachineTypeField() {
        return machineTypeField;
    }

    public WebElement getMachineTypeOption() {
        return machineTypeOption;
    }

    public void typeIntoQuantityField(String input) {
        quantityField.sendKeys(input);
    }

    public void typeIntoInstancesField(String input) {
        instancesField.sendKeys(input);
    }

    public WebElement getSelectOS() {
        return operatingSystemField;
    }

    public WebElement getFreeOSOption() {
        return freeOSOption;
    }

    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

}
