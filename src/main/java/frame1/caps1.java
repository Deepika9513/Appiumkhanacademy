package frame1;

import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class caps1 {
	public static String deviceName;
	public static String platformName;
	public static String appPackage;
	public static String appActivity;
	public AppiumDriverLocalService service;

	// for starting the server
	public AppiumDriverLocalService startServer() {
		boolean flag = checkifserverisRunning(4755);
		if (!flag) {
			service = AppiumDriverLocalService.buildDefaultService();
			service.start();
		}
		return service;
	}

	public static boolean checkifserverisRunning(int port) {
		boolean isServerRunning = false;
		ServerSocket serversocket;
		try {
			serversocket = new ServerSocket(port);
			serversocket.close();
		} catch (IOException e) {
			isServerRunning = true;
		} finally {
			serversocket = null;
		}
		return isServerRunning;
	}

	public static AndroidDriver<AndroidElement> capsi(String deviceName, String platformName, String appPackage,
			String appActivity) throws IOException, InterruptedException {
		FileReader fr = new FileReader(System.getProperty("user.dir") + "//src//main//java//global.properties");

		Properties pi = new Properties();
		pi.load(fr);
		deviceName = pi.getProperty("deviceName");
		platformName = pi.getProperty("platformName");
		appPackage = pi.getProperty("appPackage");
		appActivity = pi.getProperty("appActivity");

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appPackage);
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appActivity);
 		dc.setCapability(MobileCapabilityType.NO_RESET, false);
		// automation name for android is android ui automator (in built feature of
		// android used to find the element)
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		System.out.println(dc);
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4755/wd/hub"),
				dc);
		return driver;

	}
	protected static void swipe(AndroidDriver<AndroidElement> driver, int startX, int startY, int endX, int endY, int durationMillis) {
        TouchAction<?> touchAction = new TouchAction<>(driver);
        touchAction.press(PointOption.point(startX, startY))
                .waitAction()
                .moveTo(PointOption.point(endX, endY))
                .release()
                .perform();
    }
	 protected static boolean isTextPresent(AndroidDriver<AndroidElement> driver, String searchText) {
	        String pageSource = driver.getPageSource();
	        return pageSource.contains(searchText);
	    }
}
