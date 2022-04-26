package tests.pastebin;

import org.testng.annotations.Test;

public class HelloWebPastebinTest extends BaseTest {

    @Test
    public void pastebinTest() {
        mainPage.openPage()
                .pasteCode("Hello from WebDriver")
                .selectExpiration()
                .pasteTitle("helloweb")
                .submitForm();
    }
}
