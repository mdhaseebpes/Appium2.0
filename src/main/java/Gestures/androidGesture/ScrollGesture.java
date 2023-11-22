package Gestures.androidGesture;

import com.google.common.collect.ImmutableMap;
import driverSession.CreateSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class ScrollGesture {
    public static void main(String[] args) throws Exception {
       AppiumDriver driver = CreateSession.createDriver("Android","real");
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
     //   WebElement element = driver.findElement(AppiumBy.id("android:id/list"));
       // scrollDownByCoOrdinate(driver,100,100,600,600);
        scrollDownTillEnd(driver,100,100,600,600);
      // WebElement elementScroll= driver.findElement(AppiumBy.accessibilityId("Auto Complete"));
      // scrollDownByElement(driver,elementScroll);

       // scrollUsingDimension(driver,"down");
    }

    public static void scrollDownByCoOrdinate(AppiumDriver driver, int left ,int top,int width,int height){
        driver.executeScript("mobile:scrollGesture", ImmutableMap.of(
                "left",left,"top",top,"width",width,"height",height,
                "direction" ,"down",
                "percent" ,1.0
        ));
    }

    public static void scrollDownTillEnd(AppiumDriver driver, int left ,int top,int width,int height) {
        boolean canScrollMore = true;
        while(canScrollMore){
            canScrollMore = (Boolean) driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", left, "top", top, "width", width, "height", height,
//                "elementId", ((RemoteWebElement) element).getId(),
                    "direction", "down",
                    "percent", 1.0
            ));
            System.out.println(canScrollMore);
        }
    }

    public static void scrollDownByElement(AppiumDriver driver, WebElement element){
        driver.executeScript("mobile:scrollGesture", ImmutableMap.of(
                "elementId",((RemoteWebElement)element).getId(),
                "direction" ,"down",
                "percent" ,1.0
        ));
    }

    //Not working
    public static void scrollUsingDimension(AppiumDriver driver,String direction) {

        Dimension dim = driver.manage().window().getSize();
        int x = dim.getWidth() / 2;
        int startY = 0;
        int endY = 0;

        switch (direction) {
            case "up":
                startY = (int) (dim.getHeight() * 0.8);
                endY = (int) (dim.getHeight() * 0.2);
                break;
            case "down":
                startY = (int) (dim.getHeight() * 0.2);
                endY = (int) (dim.getHeight() * 0.8);
                break;

        }

        driver.executeScript("mobile:scrollGesture", ImmutableMap.of(
                "left", x, "top", startY, "width", x, "height", endY,
                "direction", direction,
                "percent", 1.0
        ));
    }
}
