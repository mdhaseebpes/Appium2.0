package InteractionsApp.androidInteraction;

import driverSession.CreateSession;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.time.Duration;

public class AndroidLockUnLock {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateSession.createDriver("android" ,"real");

        ((AndroidDriver)driver).lockDevice();
       // ((AndroidDriver)driver).lockDevice(Duration.ofSeconds(5));
        System.out.println(((AndroidDriver)driver).isDeviceLocked());
        ((AndroidDriver)driver).unlockDevice();

        ((AndroidDriver)driver).activateApp("io.appium.android.apis");
    }
}
