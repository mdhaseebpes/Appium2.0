package Gestures.iosGestures;

import driverSession.CreateSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class IosSlider {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateSession.createDriver("ios","simulator");
        System.out.println(driver.getSessionId());
        slider(driver);
    }

    public static void slider(AppiumDriver driver){
        driver.findElement(AppiumBy.accessibilityId("Sliders")).click();

        WebElement element = driver.findElement(AppiumBy.iOSNsPredicateString("value == \"42%\""));
        element.sendKeys("0");

        element = driver.findElement(AppiumBy.iOSNsPredicateString("value == \"0%\""));
        element.sendKeys("1");
    }
}
