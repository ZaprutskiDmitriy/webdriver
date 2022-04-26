package pages.google;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ExplicitWait;

public class YopmailEmailGeneratorPage extends BasePage {
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(id = "egen")
    private WebElement emailAddress;

    @FindBy(xpath = "//span[text()='Check Inbox']//ancestor::button[contains(@class,'egenbut')]")
    private WebElement checkInboxButton;

    public YopmailEmailGeneratorPage(WebDriver driver) {
        super(driver);
    }

    public String getEmailAddress() {
        ExplicitWait.waitVisibilityOfElement(emailAddress);
        logger.info("Generated email address: " + emailAddress.getText());
        return emailAddress.getText();
    }

    public YopmailInboxPage navigateToInboxPage() {
        logger.info("Click on 'Check inbox button'");
        checkInboxButton.click();
        return new YopmailInboxPage(driver);
    }
}
