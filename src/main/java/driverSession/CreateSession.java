package driverSession;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class CreateSession {

    public static void main(String[] args) throws Exception {

      CreateSession.createDriver("Android","real");
    }

    public static AppiumDriver createDriver(String platform , String device) throws Exception {
        DesiredCapabilities dc = new DesiredCapabilities();

        URL url = new URL("http://0.0.0.0:4723");
        switch (platform.toLowerCase()) {
            case "android":
                if(device.equalsIgnoreCase("real")) {
                    dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                    dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4");
                    dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiAutomator2");
                    dc.setCapability(MobileCapabilityType.UDID, "98131FFAZ007HX");
                    dc.setCapability("newCommandTimeout", 300);
                }
                if(device.equalsIgnoreCase("emulator")){
                    dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                    dc.setCapability(MobileCapabilityType.DEVICE_NAME, "pixel_5");
                    dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiAutomator2");
                    dc.setCapability(MobileCapabilityType.UDID, "emulator-5554");
                    //dc.setCapability("avd","Pixel_5");
                    dc.setCapability("newCommandTimeout", 300);
                }
            String androidUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" +
                    File.separator + "resources" + File.separator + "Android" + File.separator + "ApiDemos-debug.apk";
                  dc.setCapability(MobileCapabilityType.APP, androidUrl);
                 //  dc.setCapability("unlockType","pin");
               // dc.setCapability("unlockKey","1111");
              // dc.setCapability("appPackage","io.appium.android.apis");
              // dc.setCapability("appActivity",".ApiDemos");
              //  dc.setCapability("appPackage","com.google.android.apps.maps");
               // dc.setCapability("appActivity","com.google.android.apps.MapsActivity");
            return new AndroidDriver(url,dc);

            case "ios":
                if(device.equalsIgnoreCase("real")){
                    dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
                    dc.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone");
                    dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                    dc.setCapability(MobileCapabilityType.UDID, "6a18684874317167b34e0786ec843b778a523059");
                    String iosUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" +
                            File.separator + "resources" + File.separator + "IOS" + File.separator + "UIKitCatalog.ipa";
                    dc.setCapability(MobileCapabilityType.APP, iosUrl);

                }
                if(device.equalsIgnoreCase("simulator")) {
                    dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
                    dc.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 14");
                    dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                    dc.setCapability(MobileCapabilityType.UDID, "5253B513-3935-4B71-87A2-1DCF9D4B38C3");
                    dc.setCapability("simulatorStartupTimeout", 180000);
                    String iosUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" +
                            File.separator + "resources" + File.separator + "IOS" + File.separator + "UIKitCatalog-iphonesimulator.app";
                    dc.setCapability(MobileCapabilityType.APP, iosUrl);
                  // dc.setCapability("bundleId","com.example.apple-samplecode.UICatalog");
                    //dc.setCapability("bundleId","com.apple.Maps");

                }
                dc.setCapability("newCommandTimeout", 300);
                dc.setCapability("includeSafariInWebviews",true);
                dc.setCapability("webviewConnectTimeout",90000);
                return new IOSDriver(url,dc);

            default:
                throw new Exception("invalid platform");

        }

    }

    public static WebElement WaitElementVisible(AppiumDriver driver , By locator , int time){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
