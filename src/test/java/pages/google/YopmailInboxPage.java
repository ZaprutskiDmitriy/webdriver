package pages.google;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.FrameUtils;

import java.util.List;

public class YopmailInboxPage extends BasePage {
    private final String MAIL_CONTENT_FRAME_ID = "ifmail";
    private final String LIST_OF_MAILS_FRAME_ID = "ifinbox";

    @FindBy(id = "mail")
    private WebElement mailContent;

    @FindBy(xpath = "//button[@class='lm']")
    private List<WebElement> listOfMails;

    @FindBy(id = "nbmail")
    private WebElement counterMessages;

    @FindBy(id = "refresh")
    private WebElement refreshButton;

    public YopmailInboxPage(WebDriver driver) {
        super(driver);
    }

    public YopmailInboxPage chooseMail() {
        int counter = 0;
        while (counterMessages.getText().equalsIgnoreCase("0 mail") || counter > 200) {
            refreshButton.click();
            counter++;
        }
        FrameUtils.switchToFrameById(LIST_OF_MAILS_FRAME_ID);
        listOfMails.get(0).click();
        FrameUtils.switchToDefaultContent();
        return this;
    }

    public String getMailContent() {
        FrameUtils.switchToFrameById(MAIL_CONTENT_FRAME_ID);
        return mailContent.getText();
    }
}
