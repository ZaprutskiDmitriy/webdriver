package tests.google;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.google.GoogleCalculatorMainPage;
import pages.google.YopmailEmailGeneratorPage;
import pages.google.YopmailInboxPage;
import pages.google.YopmailMainPage;
import utils.DriverProvider;
import utils.TestListener;

@Listeners({TestListener.class})
public class BaseTest {
    public WebDriver driver;
    protected GoogleCalculatorMainPage googleCalculatorMainPage;
    protected YopmailMainPage yopmailMainPage;
    protected YopmailEmailGeneratorPage yopmailEmailGeneratorPage;
    protected YopmailInboxPage yopmailInboxPage;

    @BeforeMethod
    public void setUp() {
        driver = DriverProvider.getDriver();
        googleCalculatorMainPage = new GoogleCalculatorMainPage(driver);
        yopmailMainPage = new YopmailMainPage(driver);
        yopmailEmailGeneratorPage = new YopmailEmailGeneratorPage(driver);
        yopmailInboxPage = new YopmailInboxPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverProvider.closeDriver();
    }
}
