package webView;

import driverSession.CreateSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class WebViewInspectUsingAI {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateSession.createDriver("iOS","simulator");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

  //      driver.findElement(MobileBy.AccessibilityId("Views")).click();

        // -> Scroll code for Android starts here
/*        WebElement andElement = driver.findElement(AppiumBy.id("android:id/list"));
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) andElement).getId(),
                "direction", "up",
                "percent", 0.75
        ));*/
        //-> Scroll code for Android ends here

        // -> Scroll code for iOS starts here
        WebElement iOSElement = driver.findElement(AppiumBy.
                iOSNsPredicateString("type == \"XCUIElementTypeTable\""));
        Map<String, Object> params = new HashMap<>();
        params.put("direction", "up");
        params.put("element", ((RemoteWebElement) iOSElement).getId());
        driver.executeScript("mobile: swipe", params);
        // -> Scroll code for iOS ends here

        driver.findElement(AppiumBy.accessibilityId("Web View")).click();
        Thread.sleep(3000);
        System.out.println(driver.findElement(AppiumBy.accessibilityId("This is HTML content inside a WKWebView ."))
                .getAttribute("label"));

    }
}
