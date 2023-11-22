package webView;

import com.google.common.collect.ImmutableMap;
import driverSession.CreateSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.Set;

public class webViewExample {

    public static void main(String[] args) throws Exception {
       AppiumDriver driver = CreateSession.createDriver("Android", "emulator");

       driver.findElement(AppiumBy.accessibilityId("Views")).click();

       Thread.sleep(2000);

       // By ele1 = AppiumBy.accessibilityId("WebView2");
        WebElement andElement = driver.findElement(AppiumBy.id("android:id/list"));
       boolean canScrollMore = true;
        while (canScrollMore) {
            canScrollMore = (Boolean) driver.executeScript("mobile: swipeGesture", ImmutableMap.of("left", 100, "top", 100, "width", 700, "height", 600,
               "elementId", ((RemoteWebElement) andElement).getId(),
                    "direction", "up",
                    "percent", 0.75
            ));
            Thread.sleep(2000);
           try{
               if(driver.findElement(AppiumBy.accessibilityId("WebView2")).isDisplayed()){
                   System.out.println("Element is found");
                   driver.findElement(AppiumBy.accessibilityId("WebView2")).click();
                   break;
               }
           }catch (Exception ex){
               System.out.println("Element not found");
           }

       }

        Set<String> contextHandles = ((AndroidDriver)driver).getContextHandles();
        for(String context: contextHandles){
            System.out.println(context);
        }

        ((AndroidDriver) driver).context(contextHandles.toArray()[1].toString());

        By Text = AppiumBy.xpath("\"//*[@class=\\\"android.webkit.WebView\\\"]/android.widget.TextView[1]\"");

      WebElement ele= CreateSession.WaitElementVisible(driver,Text,14);
        System.out.println(ele.getText());


    }
}
