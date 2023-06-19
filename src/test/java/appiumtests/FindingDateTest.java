package appiumtests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.By;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;

public class FindingDateTest {
    public static boolean finding = false;

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        LocalDate currentDate = LocalDate.now();
        Month currentMonth =  currentDate.getMonth();
        String currentMonthinString = String.valueOf(currentMonth).substring(0,1) + String.valueOf(currentMonth).substring(1).toLowerCase();
        String year = "1997";
        String month = "December";
        String days = "16";
        String stringDay = "label contains " +  "'" + days + "'";

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
                    finding = true;
                } catch (Exception err) {
                    helper.scrollDown(driver);
                }
            }
            driver.findElement(AppiumBy.accessibilityId(month + " " + year)).click();
            driver.findElement(AppiumBy.iOSNsPredicateString(stringDay)).click();
            Thread.sleep(2000);
            driver.quit();
            System.out.println("Done");
        }

    }
}
