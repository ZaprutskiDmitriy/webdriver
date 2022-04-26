package tests.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ActionsRemoteDriverTest {
    private static final String SELECTABLE_TEST_URL = "http://jqueryui.com/selectable/";

    private static WebDriver driver;

    public static WebDriver getDriver() {
        // required to get single WebDriver instance for the whole test flow
        // and make convenient WebDriver call from other classes
        if (driver == null) {
            setDriver();
        }
        return driver;
    }

    private static void setDriver() {
        // setting options and capabilities for webdriver launch via Grid

        /*
         * initialize WebDriver for Chrome. Please mind webdriver, chromedriver
         * version and chrome browser versions. works for webdriver v3.4.0,
         * chromedriver v2.28, chrome browser v58
         */
        System.setProperty("webdriver.chrome.driver", "c:\\_webdriver\\chromedriver\\chromedriver.exe");
//		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//		capabilities.setPlatform(Platform.WINDOWS);

        // Maximize browser window via options, just an example
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setCapability("platformName", Platform.WINDOWS);

        /**
         * INFO: Using `new ChromeOptions()` is preferred to
         * `DesiredCapabilities.chrome()`
         *
         * Class to manage options specific to {@link ChromeDriver}.
         *
         * <p>
         * Example usage:
         *
         * <pre>
         * <code>
         * ChromeOptions options = new ChromeOptions()
         * options.addExtensions(new File("/path/to/extension.crx"))
         * options.setBinary(new File("/path/to/chrome"));
         *
         * // For use with ChromeDriver:
         * ChromeDriver driver = new ChromeDriver(options);
         *
         * // For use with RemoteWebDriver:
         * RemoteWebDriver driver = new RemoteWebDriver(
         *     new URL("http://localhost:4444/wd/hub"),
         *     new ChromeOptions());
         * </code>
         * </pre>
         *
         * @since Since chromedriver v17.0.963.0
         */

        try {
            // for local execution enable code snippet below
            // DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            // driver = new ChromeDriver(capabilities);
            // driver = new ChromeDriver(options);
//			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @BeforeClass(description = "Start browser")
    public void startBrowser() {
        // init Webdriver and open start url
        driver = getDriver();
    }

    @BeforeClass(dependsOnMethods = "startBrowser", description = "Add implicit wait and maximize window")
    public void addImplicitly() {
        // set a certain implicit wait timeout
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Maximize browser window
        driver.manage().window().maximize();
    }

    @Test(description = "Multiple selection", enabled = false)
    public void selectMultiple() throws InterruptedException {
        // navigating to test url
        driver.get(SELECTABLE_TEST_URL);

        // switching to frame containing web elements
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));

        // getting selectable element list and printing it out for test purpose
        List<WebElement> listItems = driver.findElements(By.cssSelector("ol#selectable *"));
        System.out.println("Item list size: " + listItems.size());

        // perform action chain to select multiple items
        new Actions(driver).clickAndHold(listItems.get(0)).moveToElement(listItems.get(4)).moveByOffset(90, 0).release()
                .perform();

        // freeze for a while to demonstrate action result
        Thread.sleep(3000);
    }

    @AfterClass(description = "Stop Browser")
    public void stopBrowser() {
        // Close browser window and terminate WebDriver.
        // May not work for FF48. Gecko driver issue.
        // https://github.com/SeleniumHQ/selenium/issues/2667
        driver.quit();
    }
}
