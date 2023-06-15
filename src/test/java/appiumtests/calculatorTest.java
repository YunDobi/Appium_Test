package appiumtests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileCommand;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class calculatorTest {

    static AppiumDriver driver;

    public static void main(String[] args) {
        try {
            openCalculator(args);
        } catch (Exception exp) {
//            System.out.println(exp.getCause());
            System.out.println(exp.getMessage());
            exp.printStackTrace();
        }
    }

    public static void openCalculator(String[] args) throws Exception {
        XCUITestOptions options = new XCUITestOptions()
                .setUdid("1C2B9B65-3BF1-487B-AAA0-E9962A67A60F")
                .setPlatformVersion("16.2");

        IOSDriver driver = new IOSDriver(
        new URL("http://127.0.0.1:4723"), options
        );




        driver.findElement(By.xpath("(//XCUIElementTypeIcon[@name=\"Calendar\"])[2]")).click();
                Thread.sleep(2000);
        driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Today\"]")).click();
        try {
            driver.findElement(AppiumBy.accessibilityId("1997"));
            System.out.println("worked");


        } catch (Exception error) {
            System.out.println("2021 error");
            driver.findElement(AppiumBy.accessibilityId("June")).click();
            driver.findElement(AppiumBy.accessibilityId("2023")).click();
            helper.scrollDown(driver);
        }
        System.out.println("Started");


//        HashMap<String, String> scrollObject = new HashMap<String, String>();
//        scrollObject.put("direction", "up");
//        scrollObject.put("value", "1997");
//        System.out.println(scrollObject);
//
//        driver.executeScript("mobile:scroll", scrollObject);
//        driver.findElement(AppiumBy.accessibilityId("1997"));


        //Find Developer from Setting
//        driver.findElement(AppiumBy.accessibilityId("Settings")).click();
//        Thread.sleep(5000);
//        HashMap<String, String> scrollObject = new HashMap<String, String>();
//        scrollObject.put("direction", "down");
//        scrollObject.put("value", "Developer");
//
//        driver.executeScript("mobile:scroll", scrollObject);
//        driver.findElement(AppiumBy.accessibilityId("DEVELOPER_SETTINGS")).click();

    }
}
