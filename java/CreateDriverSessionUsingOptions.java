
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class CreateDriverSessionUsingOptions {

    public static void main(String[] args) throws MalformedURLException {
     /*   String appUrl = System.getProperty("user.dir") + File.separator + "src" +File.separator + "test" +
                File.separator + "resources" + File.separator + "IOS" + File.separator + "AmwayTaiwan.ipa";
        XCUITestOptions options = new XCUITestOptions().
                setPlatformName("iOS").
                setDeviceName("iPhone").
                setAutomationName("XCUITest").
                setUdid("6a18684874317167b34e0786ec843b778a523059").
                setApp(appUrl);

        URL url = new URL("http://0.0.0.0:4723");

        AppiumDriver driver = new IOSDriver(url, options);*/

          String appUrl = System.getProperty("user.dir") + File.separator + "src" +File.separator + "test" +
                 File.separator + "resources" + File.separator + "Android" + File.separator + "ApiDemos-debug.apk";
        UiAutomator2Options options = new UiAutomator2Options().
                setDeviceName("Pixel 4").
                setAutomationName("UiAutomator2").
                 setUdid("98131FFAZ007HX").
                setApp(appUrl);

        URL url = new URL("http://0.0.0.0:4723");

        AppiumDriver driver = new AndroidDriver(url, options);
    }
}

