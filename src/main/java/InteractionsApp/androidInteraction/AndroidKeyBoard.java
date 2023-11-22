package InteractionsApp.androidInteraction;

import com.google.common.collect.ImmutableMap;
import driverSession.CreateSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class AndroidKeyBoard {

    public static void main(String[] args) throws Exception {

        AppiumDriver driver = CreateSession.createDriver("android","real");

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
         Thread.sleep(3000);

        // By element = AppiumBy.accessibilityId("TextFields");
        WebElement element = driver.findElement(AppiumBy.id("android:id/list"));

       // scrollDownByElement(driver,element);
        scrollDownTillEnd(driver,100,100,600,600);

        By editText = AppiumBy.id("io.appium.android.apis:id/edit");
        driver.findElement(editText).click();
        Thread.sleep(3000);

        System.out.println(((AndroidDriver) driver).isKeyboardShown());

        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.C));
//        driver.getKeyboard().pressKey(Keys.ARROW_DOWN); -> Deprecated
        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.HOME));
        ((AndroidDriver)driver).pressKey(new KeyEvent().withKey(AndroidKey.BRIGHTNESS_UP));
        ((AndroidDriver)driver).pressKey(new KeyEvent().withKey(AndroidKey.BRIGHTNESS_DOWN));
        ((AndroidDriver)driver).pressKey(new KeyEvent().withKey(AndroidKey.NOTIFICATION));
        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.CALENDAR));
        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.B));
        Thread.sleep(3000);
//        driver.getKeyboard().pressKey(Keys.HOME); -> Deprecated
        ((AndroidDriver) driver).hideKeyboard();
    }

    public static void scrollDownByElement(AppiumDriver driver, WebElement element){
        boolean canScroll= true;
        while(canScroll) {
       canScroll  =     (boolean) driver.executeScript("mobile:scrollGesture", ImmutableMap.of(
                    "elementId", ((RemoteWebElement) element).getId(),
                    "direction", "down",
                    "percent", 0.75
            ));
        }
    }

    public static void scrollDownTillEnd(AppiumDriver driver, int left, int top, int width, int height) {
            boolean canScrollMore = true;
        while (canScrollMore) {
            canScrollMore = (Boolean) driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", left, "top", top, "width", width, "height", height,
//                "elementId", ((RemoteWebElement) element).getId(),
                    "direction", "down",
                    "percent", 1.0
            ));
            try {
                if (driver.findElement(AppiumBy.accessibilityId("TextFields")).isDisplayed()) {
                    System.out.println("Found the element clicked");
                    driver.findElement(AppiumBy.accessibilityId("TextFields")).click();
                    break;
                }
            } catch (Exception ex) {
                System.out.println("Did not find the element");

            }
            System.out.println("No Element present ");
        }
        

    }
}
