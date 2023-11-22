import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class CreateDriverSession {

    public static AppiumDriver initializeDriver(String platformName) throws Exception {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability("newCommandTimeout", 300);

        URL url = new URL("http://0.0.0.0:4723");

        switch (platformName.toLowerCase()) {
            case "android":
                desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "pixel_5");
                desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
                desiredCapabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
                desiredCapabilities.setCapability("avd","Pixel_5");
                desiredCapabilities.setCapability("avdLaunchTimeout",180000);
                desiredCapabilities.setCapability("readyTimeout",120000);
                String appUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" +
                        File.separator + "resources" + File.separator + "Android" + File.separator + "ApiDemos-debug.apk";
                desiredCapabilities.setCapability(MobileCapabilityType.APP, appUrl);
                //desiredCapabilities.setCapability("appPackage" ,"io.appium.android.apis");
                // desiredCapabilities.setCapability("appActivity" ,"io.appium.android.apis.ApiDemos");
                return new AndroidDriver(url, desiredCapabilities);

            case "ios":
                desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
                desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone");
                desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                desiredCapabilities.setCapability(MobileCapabilityType.UDID, "6a18684874317167b34e0786ec843b778a523059");
                String iOSUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" +
                        File.separator + "resources" + File.separator + "IOS" + File.separator + "Amway.ipa";
                //desiredCapabilities.setCapability(MobileCapabilityType.APP, iOSUrl);
                desiredCapabilities.setCapability("bundleId" ,"com.amway.global.creators.dev");
                return new IOSDriver(url, desiredCapabilities);

            default:
                throw new Exception("invalid platform");

        }

    }

}
