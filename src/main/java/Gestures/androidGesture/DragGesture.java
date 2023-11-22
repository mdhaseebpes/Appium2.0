package Gestures.androidGesture;

import com.google.common.collect.ImmutableMap;
import driverSession.CreateSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class DragGesture {
    public static void main(String[] args) throws Exception {

        AppiumDriver driver = CreateSession.createDriver("Android","real");
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement element= driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
        dragGestures(driver,element,655,590);
  String co = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1")).getAttribute("bounds");
        System.out.println(co);

    }

    public static void dragGestures(AppiumDriver driver, WebElement element ,int x , int y){
        driver.executeScript("mobile:dragGesture", ImmutableMap.of(
                "elementId" ,((RemoteWebElement)element).getId(),
                "endX", x,
                   "endY",y
        ));



    }
}
