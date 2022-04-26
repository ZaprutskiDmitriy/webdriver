package pages.pastebin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.HighlightUtils;

public class MainPage {
    private static final String BASE_URL = "https://pastebin.com";
    private final Logger logger = LogManager.getRootLogger();
    private WebDriver driver;

    @FindBy(id = "postform-text")
    private WebElement newPasteArea;

    @FindBy(id = "select2-postform-expiration-container")
    private WebElement pasteExpirationDropdown;

    @FindBy(xpath = "//li[text()='10 Minutes']")
    private WebElement pasteExpirationTenMinutes;

    @FindBy(id = "select2-postform-format-container")
    private WebElement syntaxHighlightingDropdown;

    @FindBy(xpath = "//li[text()='Bash']")
    private WebElement syntaxHighlightingBash;

    @FindBy(id = "postform-name")
    private WebElement pasteNameInput;

    @FindBy(css = "button[type=submit]")
    private WebElement submitButton;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MainPage openPage() {
        driver.get(BASE_URL);
        return this;
    }

    public MainPage pasteCode(String code) {
        logger.info("Enter code: " + code + " in 'New Paste Area'");
        new Actions(driver).sendKeys(newPasteArea, code).build().perform();
        return this;
    }

    public MainPage selectExpiration() {
        logger.info("Select expiration");
        pasteExpirationDropdown.click();
        pasteExpirationTenMinutes.click();
        return this;
    }

    public MainPage selectSyntaxHighlighting() {
        logger.info("Select syntax highlighting");
        syntaxHighlightingDropdown.click();
        syntaxHighlightingBash.click();
        return this;
    }

    public MainPage pasteTitle(String title) {
        logger.info("Enter title: " + title);
        pasteNameInput.sendKeys(title);
        return this;
    }

    public PastePage submitForm() {
        HighlightUtils.highlightWithJS(submitButton);
        logger.info("Click submit form");
        new Actions(driver).moveToElement(submitButton).click().build().perform();
        return new PastePage(driver);
    }
}
