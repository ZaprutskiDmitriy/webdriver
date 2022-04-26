package pages.google;

import elements.Dropdown;
import model.VirtualMachine;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ExplicitWait;

public class GoogleCalculatorMainPage extends BasePage {
    private static final String BASE_URL = "https://cloudpricingcalculator.appspot.com/";
    private final Logger logger = LogManager.getRootLogger();

    private String operatingSystemLocator = "//md-option//div[contains(text(),'%s')]";
    private String machineClassLocator = "//md-option//ancestor::div[@aria-hidden='false']//div[contains(text(),'%s')]";
    private String machineSeriesLocator = "//md-option//div[contains(text(),'%s')]";
    private String machineTypeLocator = "//md-option//div[contains(text(),'%s')]";
    private String gpuTypeLocator = "//md-option//div[contains(text(),'%s')]";
    private String numberOfGpusLocator = "//md-option[@value='1'][contains(@ng-repeat,'GpuNumbers')]//div[contains(text(),'%s')]";
    private String localSsdLocator = "//md-option//div[contains(text(),'%s')]";
    private String datacenterLocationLocator = "//md-option[@region-option]//ancestor::div[@aria-hidden='false']//div[contains(text(),'%s')]";
    private String committedUsageLocator = "//md-option//ancestor::div[@aria-hidden='false']//div[contains(text(),'%s')]";

    @FindBy(xpath = "//*[contains(@class,'md-active')]//div[@title='Compute Engine'][contains(@class,'compute')]")
    private WebElement computeEngineIcon;

    @FindBy(xpath = "//label[text()='What are these instances for?']//preceding::input[contains(@name,'quantity')]")
    private WebElement numberOfInstancesInput;

    @FindBy(xpath = "//label[text()='Operating System / Software']/ancestor::md-input-container//span[contains(@class,'md-select-icon')]")
    private WebElement operatingSystemDropdown;

    @FindBy(xpath = "//label[text()='Machine Class']/ancestor::md-input-container//span[contains(@class,'md-select-icon')]")
    private WebElement machineClassDropdown;

    @FindBy(xpath = "//label[text()='Series']/ancestor::md-input-container//span[contains(@class,'md-select-icon')]")
    private WebElement machineSeriesDropdown;

    @FindBy(xpath = "//label[text()='Machine type']/ancestor::md-input-container//span[contains(@class,'md-select-icon')]")
    private WebElement machineTypeDropdown;

    @FindBy(xpath = "//form[@name='ComputeEngineForm']//div[contains(text(),'Add GPUs')]//ancestor::md-checkbox")
    private WebElement addGpuCheckbox;

    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    private WebElement gpuTypeDropdown;

    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement numberOfGpusDropdown;

    @FindBy(xpath = "//label[text()='Local SSD']/ancestor::md-input-container//span[contains(@class,'md-select-icon')]")
    private WebElement localSsdDropdown;

    @FindBy(xpath = "//label[text()='Datacenter location']/ancestor::md-input-container//span[contains(@class,'md-select-icon')]")
    private WebElement datacenterLocationDropdown;

    @FindBy(xpath = "//label[text()='Committed usage']/ancestor::md-input-container//span[contains(@class,'md-select-icon')]")
    private WebElement committedUsageDropdown;

    @FindBy(xpath = "//form[@name='ComputeEngineForm']//button[@aria-label='Add to Estimate']")
    private WebElement addToEstimateButton;

    @FindBy(xpath = "//button[@aria-label='Email Estimate']")
    private WebElement emailEstimateButton;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    private WebElement sendEmailButton;

    @FindBy(xpath = "//md-card-content[@id='resultBlock']")
    private WebElement resultBlock;

    @FindBy(xpath = "//input[@name='description'][@type='email']")
    private WebElement emailInputField;

    public GoogleCalculatorMainPage(WebDriver driver) {
        super(driver);
    }

    public GoogleCalculatorMainPage openPage() {
        driver.get(BASE_URL);
        return this;
    }

    public GoogleCalculatorMainPage selectSection() {
        logger.info("Select section");
        ExplicitWait.waitVisibilityOfElement(computeEngineIcon);
        computeEngineIcon.click();
        return this;
    }

    public GoogleCalculatorMainPage enterNumberOfInstances(VirtualMachine virtualMachine) {
        logger.info("Select number of instances");
        numberOfInstancesInput.sendKeys(String.valueOf(virtualMachine.getNumberOfInstances()));
        return this;
    }

    public GoogleCalculatorMainPage selectOperatingSystem(VirtualMachine virtualMachine) {
        logger.info("Select operating system");
        new Dropdown(operatingSystemDropdown, operatingSystemLocator).select(virtualMachine.getOperatingSystem());
        return this;
    }

    public GoogleCalculatorMainPage selectVirtualMachineClass(VirtualMachine virtualMachine) {
        logger.info("Select class of virtual machine");
        new Dropdown(machineClassDropdown, machineClassLocator).select(virtualMachine.getMachineClass());
        return this;
    }

    public GoogleCalculatorMainPage selectInstanceSeries(VirtualMachine virtualMachine) {
        logger.info("Select instance series");
        new Dropdown(machineSeriesDropdown, machineSeriesLocator).select(virtualMachine.getMachineSeries());
        return this;
    }

    public GoogleCalculatorMainPage selectInstanceType(VirtualMachine virtualMachine) {
        logger.info("Select instance type");
        new Dropdown(machineTypeDropdown, machineTypeLocator).select(virtualMachine.getMachineType());
        return this;
    }

    public GoogleCalculatorMainPage selectAddGpuCheckbox() {
        logger.info("Select 'Add GPU' checkbox)");
        addGpuCheckbox.click();
        return this;
    }

    public GoogleCalculatorMainPage selectGpuType(VirtualMachine virtualMachine) {
        logger.info("Select GPU type");
        new Dropdown(gpuTypeDropdown, gpuTypeLocator).select(virtualMachine.getGpuType());
        return this;
    }

    public GoogleCalculatorMainPage selectNumberOfGpus(VirtualMachine virtualMachine) {
        logger.info("Select number of GPUs");
        new Dropdown(numberOfGpusDropdown, numberOfGpusLocator).select(String.valueOf(virtualMachine.getNumberOfGpus()));
        return this;
    }

    public GoogleCalculatorMainPage selectLocalSsd(VirtualMachine virtualMachine) {
        logger.info("Select local SSD");
        new Dropdown(localSsdDropdown, localSsdLocator).select(virtualMachine.getLocalSsd());
        return this;
    }

    public GoogleCalculatorMainPage selectDatacenterLocation(VirtualMachine virtualMachine) {
        logger.info("Select datacenter location");
        new Dropdown(datacenterLocationDropdown, datacenterLocationLocator).select(virtualMachine.getDatacenterLocation());
        return this;
    }

    public GoogleCalculatorMainPage selectCommittedUsage(VirtualMachine virtualMachine) {
        logger.info("Select committed usage");
        new Dropdown(committedUsageDropdown, committedUsageLocator).select(virtualMachine.getCommittedUsage());
        return this;
    }

    public GoogleCalculatorMainPage clickOnAddToEstimateButton() {
        logger.info("Click on 'Add to estimate button'");
        addToEstimateButton.click();
        return this;
    }

    public GoogleCalculatorMainPage clickOnEmailEstimateButton() {
        logger.info("Click on 'Email estimate button'");
        emailEstimateButton.click();
        return this;
    }

    public GoogleCalculatorMainPage enterEmailInForm(String email) {
        logger.info("Enter email address " + email + " in input field");
        ExplicitWait.waitVisibilityOfElement(emailInputField);
        emailInputField.sendKeys(email);
        return this;
    }

    public GoogleCalculatorMainPage clickOnSendEmailButton() {
        logger.info("Click on 'Send email button'");
        ExplicitWait.waitUntilElementToBeClickable(sendEmailButton);
        sendEmailButton.click();
        return this;
    }

    public String getResult() {
        logger.info("Text from result block:\n" + resultBlock.getText());
        return resultBlock.getText();
    }
}
