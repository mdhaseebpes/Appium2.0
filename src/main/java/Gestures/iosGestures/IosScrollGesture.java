package Gestures.iosGestures;

import driverSession.CreateSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;

public class IosScrollGesture {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateSession.createDriver("ios","simulator");
        System.out.println(driver.getSessionId());
        WebElement element=  driver.findElement(AppiumBy.iOSNsPredicateString("type == \"XCUIElementTypeTable\""));

       // scrollDown(driver,element);
       // scrollDownByName(driver,element);
        //scrollDownByPredicateString(driver,element);
        scrollDownByAccessibility(driver);
    }

    public static void scrollDown(AppiumDriver driver, WebElement element){
        HashMap<String,Object> params  = new HashMap<>();
        params.put("direction","down");
        driver.executeScript("mobile:scroll",params);
    }

    public static void scrollDownByName(AppiumDriver driver, WebElement element){
        HashMap<String,Object> params  = new HashMap<>();
        params.put("elementId",((RemoteWebElement)element).getId());
        params.put("name", "Web View");
        driver.executeScript("mobile:scroll",params);
    }

    public static void scrollDownByPredicateString(AppiumDriver driver, WebElement element){
        HashMap<String,Object> params  = new HashMap<>();
        params.put("elementId",((RemoteWebElement)element).getId());
        params.put("predicateString", "label==\"Web View\"");
        driver.executeScript("mobile:scroll",params);
    }

    public static void scrollDownByAccessibility(AppiumDriver driver){
       WebElement childElement = driver.findElement(AppiumBy.accessibilityId("Web View"));
        HashMap<String,Object> params  = new HashMap<>();
        params.put("elementId",((RemoteWebElement)childElement).getId());
        params.put("toVisible", true);
        driver.executeScript("mobile:scroll",params);
    }
}
