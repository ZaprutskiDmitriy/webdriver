package elements;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.DriverProvider;
import utils.ExplicitWait;

public class Dropdown {
    private WebElement dropdown;
    private String optionLocator;
    private final Logger logger = LogManager.getRootLogger();

    public Dropdown(WebElement dropdown, String optionLocator) {
        this.dropdown = dropdown;
        this.optionLocator = optionLocator;
    }

    public void select(String option) {
        dropdown.click();
        logger.info("Choose option " + option + " in dropdown");
        WebElement selectedOption = ExplicitWait.waitVisibilityOfElement(DriverProvider.getDriver().findElement(By.xpath(String.format(optionLocator, option))));
        ExplicitWait.waitVisibilityOfElement(selectedOption);
        selectedOption.click();
    }
}
