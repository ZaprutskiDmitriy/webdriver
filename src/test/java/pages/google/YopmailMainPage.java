package pages.google;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YopmailMainPage extends BasePage {
    private static final String BASE_URL = "https://yopmail.com/";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//div[@id='listeliens']//a[@href='email-generator']")
    private WebElement emailGenerator;

    @FindBy(id = "login")
    private WebElement emailInputField;

    @FindBy(id = "refreshbut")
    private WebElement submitButton;

    public YopmailMainPage(WebDriver driver) {
        super(driver);
    }

    public YopmailMainPage openPage() {
        driver.get(BASE_URL);
        return this;
    }

    public YopmailEmailGeneratorPage generateEmailAddress() {
        logger.info("Click on 'Generate email address button'");
        emailGenerator.click();
        return new YopmailEmailGeneratorPage(driver);
    }

    public YopmailMainPage enterEmailAddress(String email) {
        logger.info("Enter email address " + email + " in input field");
        emailInputField.sendKeys(email);
        return this;
    }

    public YopmailInboxPage navigateToEmailInbox() {
        logger.info("Click on 'Submit button'");
        submitButton.click();
        return new YopmailInboxPage(driver);
    }
}
