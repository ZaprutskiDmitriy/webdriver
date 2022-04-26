package pages.pastebin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ExplicitWait;

public class PastePage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='highlighted-code']//div[@class='left']//a")
    private WebElement codeHighlightedTag;

    @FindBy(tagName = "textarea")
    private WebElement codeTextarea;

    public PastePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void isPageOpened() {
        ExplicitWait.waitVisibilityOfElement(codeHighlightedTag);
    }

    public String getPasteTitle() {
        return driver.getTitle();
    }

    public String getCodeHighlightedTag() {
        return codeHighlightedTag.getText();
    }

    public String getCode() {
        return codeTextarea.getText();
    }
}
