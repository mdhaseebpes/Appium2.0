package Gestures.iosGestures;

import driverSession.CreateSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;

public class IosSwipeGesture {

    public static void main(String[] args) throws Exception {
      AppiumDriver driver = CreateSession.createDriver("ios","simulator");
        System.out.println(driver.getSessionId());
      WebElement element=  driver.findElement(AppiumBy.iOSNsPredicateString("type == \"XCUIElementTypeTable\""));

        swipeDown(driver,element);
    }

    public static void swipeDown(AppiumDriver driver, WebElement element){
        HashMap<String,Object> params  = new HashMap<>();
        params.put("direction","up");
        params.put("elementId",((RemoteWebElement)element).getId());
        driver.executeScript("mobile:swipe",params);
    }
}
