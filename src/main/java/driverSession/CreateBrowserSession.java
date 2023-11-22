package driverSession;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class CreateBrowserSession {
    public static void main(String[] args) {

    }

    public static AppiumDriver createBrowserSession(String platform , String device) throws Exception {
        DesiredCapabilities dc = new DesiredCapabilities();

        URL url = new URL("http://0.0.0.0:4723");

       switch (platform.toLowerCase()){
           case "android":
           if(device.equalsIgnoreCase("emulator")){
             dc.setCapability(MobileCapabilityType.UDID,"emulator-5554");
               dc.setCapability(MobileCapabilityType.DEVICE_NAME, "pixel_5");
           }
           if(device.equalsIgnoreCase("real")){
               dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4");
               dc.setCapability(MobileCapabilityType.UDID, "98131FFAZ007HX");
               dc.setCapability("newCommandTimeout", 300);
           }
               dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
               dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
               dc.setCapability(MobileCapabilityType.BROWSER_NAME ,"chrome");
               // should be used only if chromeBrowser is not compatible with appium bundle Chrome version
              // dc.setCapability("chromedriverExecutableDir", "/Users/mohammed/Downloads/ChromeDriverDir");
            return new AndroidDriver(url,dc);
           case "ios" :
               if(device.equalsIgnoreCase("real")){
                   dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
                   dc.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone");
                   dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                   dc.setCapability(MobileCapabilityType.UDID, "6a18684874317167b34e0786ec843b778a523059");
               }
               if(device.equalsIgnoreCase("simulator")) {
                   dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
                   dc.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 14");
                   dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                   dc.setCapability(MobileCapabilityType.UDID, "5253B513-3935-4B71-87A2-1DCF9D4B38C3");
                   dc.setCapability("simulatorStartupTimeout", 180000);

               }
               dc.setCapability("newCommandTimeout", 300);
               dc.setCapability(MobileCapabilityType.BROWSER_NAME ,"Safari");
               return new IOSDriver(url,dc);
           default:
               throw new Exception("invalid platform");
       }
    }
}
