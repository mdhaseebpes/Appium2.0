package driverSession;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class CreateSessionUsingOptions {

    public static void main(String[] args) throws MalformedURLException {
      //CreateSessionUsingOptions.androidDriverOptions();
     CreateSessionUsingOptions.iosDriverOptions();
    }


    public static AppiumDriver androidDriverOptions() throws MalformedURLException {
        String androidUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" +
                File.separator + "resources" + File.separator + "Android" + File.separator + "ApiDemos-debug.apk";

        UiAutomator2Options uiAutomator2Options = new UiAutomator2Options()
                .setDeviceName("pixel_5")
                .setAutomationName("uiAutomator2")
                .setUdid("emulator-5554")
                .setApp(androidUrl);

        URL url = new URL("http://0.0.0.0:4723");

        return new AndroidDriver(url, uiAutomator2Options);
    }

    public static AppiumDriver iosDriverOptions() throws MalformedURLException {
        String iosUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" +
                File.separator + "resources" + File.separator + "IOS" + File.separator + "UIKitCatalog-iphonesimulator.app";
        XCUITestOptions xcuiTestOptions = new XCUITestOptions()
                .setDeviceName("iPhone 14")
                .setAutomationName("XCUITest")
                .setUdid("5253B513-3935-4B71-87A2-1DCF9D4B38C3")
                .setApp(iosUrl);

        URL url = new URL("http://0.0.0.0:4723");

        return new IOSDriver(url,xcuiTestOptions);
    }
}
