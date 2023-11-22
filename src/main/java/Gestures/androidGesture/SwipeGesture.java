package Gestures.androidGesture;

import com.google.common.collect.ImmutableMap;
import driverSession.CreateSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.input.model.TouchPoint;
import org.openqa.selenium.remote.RemoteWebElement;

import java.time.Duration;

public class SwipeGesture {
   static AppiumDriver driver;
    public static void main(String[] args) throws Exception {
         driver  = CreateSession.createDriver("Android","real");
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
      WebElement leftSwipeElement =  driver.findElement(AppiumBy.xpath("//*[@resource-id=\"io.appium.android.apis:id/gallery\"]/android.widget.ImageView[1]"));

    // WebElement element = driver.findElement(AppiumBy.id("android:id/list"));
     //swipeUp(driver);
      //  swipeUpByElement(driver ,element);

        swipeLeft(driver,leftSwipeElement);

    }

    public static void swipeUp(AppiumDriver driver){
        driver.executeScript("mobile:swipeGesture", ImmutableMap.of(
                "left", 400,
                "top", 600,
                "width",500,
                "height",1200,
                "direction","up",
                "percent",0.75
        ));
    }


    public static void swipeUpByElement(AppiumDriver driver, WebElement element){


        driver.executeScript("mobile:swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement)element).getId(),
                "direction","up",
                "percent",0.75
        ));
    }

    public static void swipeLeft(AppiumDriver driver, WebElement element){
        driver.executeScript("mobile:swipeGesture", ImmutableMap.of(
                "elementId",((RemoteWebElement)element).getId(),
                "direction","left",
                "percent",0.75
        ));
    }

    public static void swipeRight(AppiumDriver driver, WebElement element){
        driver.executeScript("mobile:swipeGesture", ImmutableMap.of(
                "elementId",((RemoteWebElement)element).getId(),
                "direction","right",
                "percent",0.75
        ));
    }

    public static void scrollUsingTouchAction(AppiumDriver driver,String direction) {

        Dimension dim = driver.manage().window().getSize();
        int x = dim.getWidth() / 2;
        int startY = 0;
        int endY = 0;

        switch (direction) {
            case "up":
                startY = (int) (dim.getHeight() * 0.8);
                endY = (int) (dim.getHeight() * 0.2);
                break;
            case "down":
                startY = (int) (dim.getHeight() * 0.2);
                endY = (int) (dim.getHeight() * 0.8);
                break;

        }


    }


}
