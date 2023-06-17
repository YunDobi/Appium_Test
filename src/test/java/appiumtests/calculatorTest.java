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
import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;

public class calculatorTest {
    public static boolean finding = false;

    public static void main(String[] args) {
        try {
            openCalculator(args);
        } catch (Exception exp) {
//            System.out.println(exp.getCause());
            System.out.println(exp.getMessage());
            exp.printStackTrace();
        }
    }

    @Test
    public static void openCalculator(String[] args) throws Exception {
        LocalDate currentDate = LocalDate.now();
        Month currentMonth =  currentDate.getMonth();
        String currentMonthinString = String.valueOf(currentMonth).substring(0,1) + String.valueOf(currentMonth).substring(1).toLowerCase();
        String year = "1997";
        String month = "December";
        String days = "16";


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
            driver.findElement(AppiumBy.accessibilityId(year));
            System.out.println("worked");


        } catch (Exception error) {
            System.out.println("2021 error");
            driver.findElement(AppiumBy.accessibilityId(currentMonthinString)).click();
            driver.findElement(AppiumBy.accessibilityId("2023")).click();
            while (finding == false) {
                try {
                    driver.findElement(AppiumBy.accessibilityId(year));
//                    driver.findElement(By.name("1997"));
                    finding = true;
                } catch (Exception err) {
                    helper.scrollDown(driver);
                }
            }
            driver.findElement(AppiumBy.accessibilityId(month + year)).click();
            driver.findElement(AppiumBy.accessibilityId("Tuesday, December 16")).click();
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
