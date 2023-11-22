package Gestures.iosGestures;

import com.beust.ah.A;
import driverSession.CreateSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;

public class IosZoomInOut {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateSession.createDriver("ios","simulator");
        System.out.println(driver.getSessionId());

        ZoomInIOS(driver);
        WebElement element = driver.findElement(AppiumBy.
                iOSClassChain("**/XCUIElementTypeOther[`name == \"OverlayView\"`][1]"));
        ZoomOutIOS(driver,element);
    }

    public static void ZoomInIOS(AppiumDriver driver){
        HashMap<String,Object> params = new HashMap<>();

        params.put("scale",10);
        params.put("velocity",2.2);
        driver.executeScript("mobile:pinch",params);

    }

    public static void ZoomOutIOS(AppiumDriver driver , WebElement element){
        HashMap<String,Object> params = new HashMap<>();
        params.put("elementId",((RemoteWebElement)element).getId());
        params.put("scale",0.1);
        params.put("velocity",-1.2);
        driver.executeScript("mobile:pinch",params);

    }
}
