package Gestures.androidGesture;

import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.Immutable;
import driverSession.CreateSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class LongClick {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateSession.createDriver("Android","real");
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement  element= driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
        //longClickGestureByElement(driver,element);
        longClickGestureByCoOrdinates(driver,element,222,600);
    }


    public static void longClickGestureByElement(AppiumDriver driver ,WebElement element){
        driver.executeScript("mobile:longClickGesture", ImmutableMap.of(
                "elementId",((RemoteWebElement)element).getId(),
                "duration",1000
        ));
    }

    public static void longClickGestureByCoOrdinates(AppiumDriver driver,WebElement element, int x , int y){
        driver.executeScript("mobile:longClickGesture", ImmutableMap.of(
                "x",x,
                    "y",y,
                "duration" ,1000
        ));
    }

    public static void doubleClickGestureByElement(AppiumDriver driver ,WebElement element){
        driver.executeScript("mobile:doubleClickGesture", ImmutableMap.of(
                "elementId",((RemoteWebElement)element).getId()

        ));
    }

    public static void ClickGestureByElement(AppiumDriver driver ,WebElement element){
        driver.executeScript("mobile:clickGesture", ImmutableMap.of(
                "elementId",((RemoteWebElement)element).getId()
        ));
    }
}
