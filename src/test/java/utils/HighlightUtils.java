package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class HighlightUtils {
    private static final Logger logger = LogManager.getRootLogger();

    public static void highlightWithJS(WebElement element) {
        String bg = element.getCssValue("backgroundColor");
        JavascriptExecutor js = ((JavascriptExecutor) DriverProvider.getDriver());
        js.executeScript("arguments[0].style.backgroundColor = '" + "yellow" + "'", element);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            logger.error(e);
        }
        js.executeScript("arguments[0].style.backgroundColor = '" + bg + "'", element);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            logger.error(e);
        }
    }
}
