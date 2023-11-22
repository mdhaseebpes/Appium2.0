package Gestures.iosGestures;

import com.beust.ah.A;
import driverSession.CreateSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;
import java.util.Map;

public class IosTouchAndHold {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateSession.createDriver("ios","simulator");
        System.out.println(driver.getSessionId());
       WebElement element = driver.findElement(AppiumBy.accessibilityId("Steppers"));
        tap(driver,element);
        touchAndHold(driver);


    }


    public static void tap(AppiumDriver driver, WebElement element){
        HashMap<String,Object> params = new HashMap<>();
        params.put("elementId",((RemoteWebElement)element).getId());
        //x and y co ordinate is mandatory for tap
        params.put("x",0);
        params.put("y",0);
        driver.executeScript("mobile:tap", params);

    }

    public static void touchAndHold(AppiumDriver driver){

        WebElement element = driver.findElement(AppiumBy
                .iOSClassChain("**/XCUIElementTypeButton[`label == \"Increment\"`][1]"));

        Map<String, Object> params = new HashMap<>();
        params.put("elementId", ((RemoteWebElement) element).getId());
        params.put("duration", 5);
        driver.executeScript("mobile: touchAndHold", params);
    }

    public static void dragAndDrop(AppiumDriver driver){
        Map<String, Object> params = new HashMap<>();
        params.put("fromX", 60);
        params.put("fromY", 300);
        params.put("toX", 60);
        params.put("toY", 0);
        params.put("duration", 1);
        driver.executeScript("mobile: dragFromToForDuration", params);
    }

}
