package InteractionsApp.androidInteraction;

import driverSession.CreateSession;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.time.Duration;

public class AndroidInteractions {

    public static void main(String[] args) throws Exception {

        AppiumDriver driver = CreateSession.createDriver("android","real");

        Thread.sleep(3000);
      //  ((AndroidDriver) driver).terminateApp("io.appium.android.apis");

     //   String androidUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" +
      //          File.separator + "resources" + File.separator + "Android" + File.separator + "ApiDemos-debug.apk";

      // ((AndroidDriver)driver).installApp(androidUrl);
      boolean check =  ((AndroidDriver)driver).isAppInstalled("io.appium.android.apis");

        System.out.println("Is app installed " + check);

        ((AndroidDriver)driver).runAppInBackground(Duration.ofSeconds(4));


        Thread.sleep(3000);
        ((AndroidDriver) driver).terminateApp("io.appium.android.apis");

        ((AndroidDriver)driver).activateApp("io.appium.android.apis");

        Thread.sleep(3000);
        System.out.println(((AndroidDriver)driver).queryAppState("io.appium.android.apis"));

        ((AndroidDriver) driver).terminateApp("io.appium.android.apis");

        Thread.sleep(3000);
        System.out.println(((AndroidDriver)driver).queryAppState("io.appium.android.apis"));




    }
}
