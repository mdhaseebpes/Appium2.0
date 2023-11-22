import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class ElementBasicActions {

/*    public void scrollDown(AppiumDriver driver) {
        int pressX = driver.manage().window().getSize().width / 3;
        int bottomY = (driver.manage().window().getSize().height * 3) / 4;
        int topY = driver.manage().window().getSize().height / 4;
        TouchAction touchAction = new TouchAction(driver)
        touchAction.longPress(PointOption.point(pressX, bottomY)).moveTo(PointOption.point(pressX, topY)).release().perform();
    }*/

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");

        By views = AppiumBy.accessibilityId("Views");
        By textFields = AppiumBy.accessibilityId("TextFields");
        By editText = AppiumBy.id("io.appium.android.apis:id/edit");

        driver.findElement(views).click();

        Thread.sleep(5000);

        //Swipe

       // WebElement element = driver.findElement(AppiumBy.id("android:id/list"));

        boolean canScrollMore = true;

        while (canScrollMore) {
            canScrollMore = (Boolean) driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 600, "height", 600,
                    "direction", "down",
                    "percent", 0.75
            ));
            System.out.println("can scroll down more: " + canScrollMore);
        }



        driver.findElement(textFields).click();
        driver.findElement(editText).sendKeys("my text");
        Thread.sleep(3000);
        driver.findElement(editText).clear();
    }
}

// click, sendKeys, clear
