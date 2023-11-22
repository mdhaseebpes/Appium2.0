/*
package Gestures;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.ios.IOSTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;


public class AllMethods {

    public static void scrollUsingTouchAction(AppiumDriver driver,String direction) {

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

        TouchAction touch = new TouchAction(driver);
        touch.press(PointOption.point(x, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).
                moveTo(PointOption.point(x, endY)).release().perform();
    }

    public MobileElement scrollToElement(AppiumDriver driver) {


        WebElement element = driver.findElement(MobileBy.AndroidUIAutomator
                ("new UiScrollable(new UiSelector().scrollable(true).instance(0))." +
                        "scrollIntoView(new UiSelector().text(\"ElementText\").instance(0))"));

        return (io.appium.java_client.MobileElement) ((FindsByAndroidUIAutomator) driver).findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector()" + ".scrollable(true)).scrollIntoView("
                        + "new UiSelector().description(\"test-Price\"));");



    }


    public void iOSScrollToElement(AppiumDriver driver) {
        RemoteWebElement element = (RemoteWebElement)driver.findElement(By.name("test-ADD TO CART"));
        String elementID = element.getId();
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("element", elementID);
//	  scrollObject.put("direction", "down");
//	  scrollObject.put("predicateString", "label == 'ADD TO CART'");
//	  scrollObject.put("name", "test-ADD TO CART");
        scrollObject.put("toVisible", "sdfnjksdnfkld");
        driver.executeScript("mobile:scroll", scrollObject);
    }

    public void scroll(AppiumDriver driver){
        Dimension size  = driver.manage().window().getSize();
        int pointX = driver.manage().window().getSize().width/3;
        int pointY = (driver.manage().window().getSize().height*3)/4;
        int top = driver.manage().window().getSize().height/4;

        //down
        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(PointOption.point(pointX,pointY)).moveTo(PointOption.point(pointX,top))
                .release().perform();

        int x  = size.width/2;
        int y = (size.height*3)/4;
        int down = size.height/4;

        //up
        TouchAction touchAction1 = new TouchAction(driver);
        touchAction.longPress(PointOption.point(x,y)).moveTo(PointOption.point(x,down)).release().perform();


    }

    public MobileElement androidScrollToElementUsingUiScrollable(AppiumDriver driver, String childLocAttr, String childLocValue) {
        return (MobileElement) ((FindsByAndroidUIAutomator) driver).findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector()" + ".scrollable(true)).scrollIntoView("
                        + "new UiSelector()." + childLocAttr + "(\"" + childLocValue + "\"));");
    }

    public void tapCordinate(AppiumDriver driver, int x , int y){


        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(new PointOption().withCoordinates(x,y)).perform();
    }

    public void tapCoordinateMobileElement(AppiumDriver driver, MobileElement element){
        Point point = element.getCenter();
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(new PointOption().withCoordinates(point)).perform().release();
    }

    public void longPress(AppiumDriver driver ,MobileElement element) {
        TouchAction<?> touchAction = new TouchAction(driver);
        touchAction.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(element))
                ).release().perform();
    }

    public void takeScreenShot(AppiumDriver driver){
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //FileUtils.copyFile(screenshotFile, new File("path/to/save/screenshot.png"));

    }

    public void zoomPitchINGesture(AppiumDriver driver){
        //: You can perform a pinch-in gesture on the screen using the `zoom()` method in Appium

        int startX1 = 500;
        int startY1 = 1000;
        int endX1 = 600;
        int endY1 = 900;

        int startX2 = 600;
        int startY2 = 900;
        int endX2 = 500;
        int endY2 = 1000;

        TouchAction<?> touchAction = new IOSTouchAction(driver);
        touchAction.press(PointOption.point(startX1, startY1)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(endX1, endY1)).release()
                .press(PointOption.point(startX2, startY2)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(endX2, endY2)).release()
                .perform();

    }


    public void zoomPitchOutGesture(AppiumDriver driver){
        //: You can perform a pinch-in gesture on the screen using the `zoom()` method in Appium

        int startX1 = 500;
        int startY1 = 1000;
        int endX1 = 400;
        int endY1 = 1100;

        int startX2 = 400;
        int startY2 = 1100;
        int endX2 = 500;
        int endY2 = 1000;


        TouchAction<?> touchAction = new IOSTouchAction(driver);
        touchAction.press(PointOption.point(startX1, startY1)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(endX1, endY1)).release()
                .press(PointOption.point(startX2, startY2)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(endX2, endY2)).release()
                .perform();


    }

    public void networkConnection(AppiumDriver driver){
        ConnectionStateBuilder connectionStateBuilder = new ConnectionStateBuilder();
        connectionStateBuilder.withWiFiEnabled();
     //   ((HasNetworkConnection) driver).setNetworkConnection(connectionStateBuilder);


    } }
*/
