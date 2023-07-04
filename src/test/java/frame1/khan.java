package frame1;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

//import com.relevantcodes.extentreports.LogStatus;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;


//import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class khan extends caps1 {
	AndroidDriver<AndroidElement> driver;

	@BeforeTest
	public void setup() throws IOException, InterruptedException {
		driver = capsi(deviceName, platformName, appPackage, appActivity);
		//String FinancialLiteracyPage = require('pages/FinancialLiteracyPage');
		//financialLiteracyPage = new FinancialLiteracyPage();
		 //financialLiteracyPage fp = new financialLiteracyPage();
		   // recentLessonsPage = new RecentLessonsPage();

	}

	@Test
	public void test1() throws InterruptedException {
		System.out.println("KhanAcademy");
		Thread.sleep(10000);
		// tap on search
		driver.findElement(MobileBy.AccessibilityId("Search")).click();
		Thread.sleep(10000);
		// clicking computing
		driver.findElement(MobileBy.xpath("//*[@text='Computing']")).click();
		Thread.sleep(5000);
		// clicking the computer science
		driver.findElement(MobileBy.xpath(
				"//android.widget.Button[@content-desc=\"Computer science\"]/android.view.ViewGroup/android.view.ViewGroup[2]"))
				.click();
		Thread.sleep(1000);
		// clicking on cryptography
		driver.findElement(MobileBy.xpath("//*[@text='Cryptography']")).click();
		Thread.sleep(4000);
		// adding a bookmarks to ancient cryptography
		driver.findElement(
				MobileBy.xpath("(//android.widget.Button[@content-desc=\"Add Bookmark\"])[1]/android.widget.ImageView"))
				.click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		// driver.findElement(MobileBy.xpath("//*[@text='GOT IT']")).click();
		Thread.sleep(2000);
		//scroll the below topics
		swipe(driver, 500, 1900, 500, 500, 3000);
		Thread.sleep(3000);
		swipe(driver, 500, 1500, 500, 500, 3000);

		// Thread.sleep(1000);
		// driver.findElement(MobileBy.xpath("[@text='Cryptography challenge
		// 101']")).click();
		//add the bookmarks to cryptography challenge
		driver.findElement(
				MobileBy.xpath("(//android.widget.Button[@content-desc=\"Add Bookmark\"])[1]/android.widget.ImageView"))
				.click();
		swipe(driver, 500, 1900, 500, 500, 3000);
		swipe(driver, 500, 1500, 500, 500, 3000);
		driver.findElement(MobileBy.xpath("//*[@text='Modular arithmetic']")).click();//clicking on modular arithmetic
		Thread.sleep(3000);
		//add a bookmark to modular arithmetic
		driver.findElement(
				MobileBy.xpath("(//android.widget.Button[@content-desc=\"Add Bookmark\"])[1]/android.widget.ImageView"))
				.click();
		//go one step back to computer science page
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(4000);
		//clicking on information theory
		driver.findElement(MobileBy.xpath("//*[@text='Information theory']")).click();
		Thread.sleep(2000);
		//scroll action
		swipe(driver, 500, 1000, 500, 500, 3000);
		//clicking the modern information theory bookmark
		driver.findElement(MobileBy.xpath("//*[@text='Modern information theory']")).click();
		//click the bookmark on above
		driver.findElement(
				MobileBy.xpath("(//android.widget.Button[@content-desc=\"Add Bookmark\"])[1]/android.widget.ImageView"))
				.click();
		Thread.sleep(1000);
		
		//verifying all the bookmarks
		driver.findElement(MobileBy.xpath("//android.view.View[@content-desc=\"Bookmarks\"]/android.widget.ImageView"))
				.click();
		Thread.sleep(3000);
		
		// verify the bookmarks
		boolean isTextPresent = isTextPresent(driver, "Modern information theory");
		// Print the result
		System.out.println("Bookmark present: " + isTextPresent);
		boolean isTextPresent1 = isTextPresent(driver, "Modular arithmetic");
		// Print the result
		System.out.println("Bookmark present: " + isTextPresent1);
		boolean isTextPresent2 = isTextPresent(driver, "Cryptography challenge 101");
		// Print the result
		System.out.println("Bookmark present: " + isTextPresent2);
		boolean isTextPresent3 = isTextPresent(driver, "Ancient cryptography");
		// Print the result
		System.out.println("Bookmark present: " + isTextPresent3);
		// tick the checkbox in the bookmarks
		//driver.findElement(MobileBy.xpath("//*[@text='Edit']")).click();
		
		for(int i=0;i<=3;i++)
		{
			driver.findElement(MobileBy.xpath("//*[@text='Edit']")).click();
			Thread.sleep(1000);
			driver.findElement(MobileBy.xpath("(//android.view.ViewGroup[@content-desc=\"Select bookmark\"])[1]/android.widget.ImageView")).click();
			driver.findElement(MobileBy.xpath("//*[@text='Delete']")).click();
			Thread.sleep(1000);
		}
//		driver.pressKey(new KeyEvent(AndroidKey.BACK));
//		Thread.sleep(4000);
//		driver.pressKey(new KeyEvent(AndroidKey.BACK));
//		Thread.sleep(2000);
//		driver.pressKey(new KeyEvent(AndroidKey.BACK));
//		Thread.sleep(1000);
//		driver.pressKey(new KeyEvent(AndroidKey.BACK));
//		Thread.sleep(3000);
		    
		
		
		// checking delete all those checked bookmarks
		System.out.println("deleted all the bookmarks");
		//driver.findElement(MobileBy.xpath("//*[@text='Delete']")).click();
//        //not need to go back in the same page having the search option  
//        //again tap to search
		driver.findElement(MobileBy.AccessibilityId("Search")).click();
		Thread.sleep(2000);
		driver.findElement(MobileBy.AccessibilityId("Search")).click();
		Thread.sleep(2000);
		// tap on life skills
		driver.findElement(MobileBy.xpath("//*[@text='Life skills']")).click();
		Thread.sleep(5000);
		// tap on financial literacy
		driver.findElement(MobileBy.xpath("//*[@text='Financial Literacy']")).click();
		Thread.sleep(2000);
		// open the first topic
		driver.findElement(MobileBy.xpath("//*[@text='Welcome to Financial Literacy']")).click();
		Thread.sleep(3000);
		driver.findElement(MobileBy.xpath("//*[@text='Welcome to Financial Literacy']")).click();
		Thread.sleep(15);
		
		
		driver.findElement(MobileBy.AccessibilityId("Home")).click();
		Thread.sleep(3000);
		// open the first video and play for 15secs
		//driver.findElement(MobileBy.xpath("android.widget.ImageView")).click();
		// financialLiteracyPage.openFirstVideo();
		// financialLiteracyPage.playVideo(15);
		Thread.sleep(4000);
		// tap on home
		//driver.findElement(MobileBy
				//.xpath("////android.view.View[@content-desc=\"Home\"]/android.view.ViewGroup/android.widget.ImageView"))
				//.click();
		//Thread.sleep(3000);
		// swipe to verify the recent lessons
		//swipe(driver, 500, 1900, 500, 500, 3000);
		driver.findElement(MobileBy.xpath("//*[@text='Recent lessons']"));
		Thread.sleep(2000);
		// close the application
		driver.quit();

	}
}
