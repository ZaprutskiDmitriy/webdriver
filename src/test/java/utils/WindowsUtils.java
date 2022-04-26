package utils;

import org.openqa.selenium.WindowType;

import java.util.ArrayList;

public class WindowsUtils {
    public static void switchToNewTab() {
        DriverProvider.getDriver().switchTo().window(getWindowHandles().get(1));
    }

    public static void switchToOldTab() {
        DriverProvider.getDriver().switchTo().window(getWindowHandles().get(0));
    }

    public static void openNewTab() {
        DriverProvider.getDriver().switchTo().newWindow(WindowType.TAB);
    }

    private static ArrayList<String> getWindowHandles() {
        return new ArrayList<>(DriverProvider.getDriver().getWindowHandles());
    }
}
