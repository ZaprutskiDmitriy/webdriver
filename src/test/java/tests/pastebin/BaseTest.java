package tests.pastebin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.pastebin.MainPage;
import pages.pastebin.PastePage;
import utils.DriverProvider;
import utils.TestListener;

@Listeners({TestListener.class})
public class BaseTest {
    WebDriver driver;
    MainPage mainPage;
    PastePage pastePage;

    @BeforeMethod
    public void setUp() {
        driver = DriverProvider.getDriver();
        mainPage = new MainPage(driver);
        pastePage = new PastePage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverProvider.closeDriver();
    }
}
