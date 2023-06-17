package appiumtests;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.time.Duration;

public class helper {

    public static void scrollDown (IOSDriver driver) {
        Dimension dimension = driver.manage().window().getSize();
        int scrollStart = (int) (dimension.getHeight() * 0.2);
        int scrollEnd = (int) (dimension.getHeight() * 0.8);

        new TouchAction((PerformsTouchActions) driver)
                .press(PointOption.point(0,scrollStart))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(0,scrollEnd))
                .release().perform();
    }
}
