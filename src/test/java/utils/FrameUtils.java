package utils;

public class FrameUtils {
    public static void switchToFrameById(String id) {
        DriverProvider.getDriver().switchTo().frame(id);
    }

    public static void switchToDefaultContent() {
        DriverProvider.getDriver().switchTo().defaultContent();
    }
}
