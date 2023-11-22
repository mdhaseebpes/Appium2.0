package Gestures.androidGesture;

import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.Immutable;
import driverSession.CreateSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class ZoomOutIn {

    public static void main(String[] args) throws Exception {
       AppiumDriver driver = CreateSession.createDriver("Android" ,"emulator");
        pinchOpenGestureZoomIN(driver);

    }

    public static void pinchOpenGestureZoomIN(AppiumDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Skip\"]")).click();
        Thread.sleep(5000);

        driver.executeScript("mobile:pinchOpenGesture", ImmutableMap.of(
                "left", 400,
                    "top", 600,
                "width",600,
                "height",600,
                "percent",0.75
        ));

    }

    public static void pinchCloseGestureZoomOut(AppiumDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Skip\"]")).click();
        Thread.sleep(5000);

        driver.executeScript("mobile:pinchCloseGesture", ImmutableMap.of(
                "left", 400,
                "top", 600,
                "width",600,
                "height",600,
                "percent",0.75
        ));

    }
}
