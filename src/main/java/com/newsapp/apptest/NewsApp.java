package com.newsapp.apptest;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class NewsApp {

	AndroidDriver<WebElement> driver = null;

	// 初始化，安装apk
	@BeforeClass
	public void init() {

		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "isapp");
		File app = new File(appDir, "zb-cn-release-3.24.5.apk");

		// 设置属性
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "127.0.0.1:62001");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "5.1.1");
		cap.setCapability("app", app.getAbsolutePath());
		cap.setCapability("automationName", "UiAutomator1");
		cap.setCapability("appPackage", "com.zb.sph.zaobaochina");
		cap.setCapability("appActivity", "com.zb.sph.app.activity.SplashPageActivity");

		// 加载驱动
		try {
			driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Thread.sleep(3000);
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void test() {

		driver.findElement(By.id("com.zb.sph.zaobaochina:id/btnAccept")).click();

		(new TouchAction(driver)).press(PointOption.point(862, 1219)).moveTo(PointOption.point(115, 1222)).release()
				.perform();
		(new TouchAction(driver)).press(PointOption.point(850, 1228)).moveTo(PointOption.point(68, 1229)).release()
				.perform();
		(new TouchAction(driver)).press(PointOption.point(785, 1136)).moveTo(PointOption.point(104, 1134)).release()
				.perform();
		(new TouchAction(driver)).press(PointOption.point(830, 1132)).moveTo(PointOption.point(117, 1132)).release()
				.perform();

		driver.findElement(By.id("com.zb.sph.zaobaochina:id/btn_done")).click();

		driver.findElement(By.id("com.zb.sph.zaobaochina:id/action_hamburger")).click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		MobileElement el6 = (MobileElement) driver.findElementById("com.zb.sph.zaobaochina:id/btn_user");
		el6.click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		MobileElement el7 = (MobileElement) driver.findElementById("com.zb.sph.zaobaochina:id/textUserName");
		el7.click();
		el7.sendKeys("sphtechqa007");

		MobileElement el2 = (MobileElement) driver.findElementById("com.zb.sph.zaobaochina:id/textPassword");
		el2.click();
		el2.sendKeys("2018Sphqa");

		driver.findElement(By.id("com.zb.sph.zaobaochina:id/loginButton")).click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String result = driver.findElement(By.id("com.zb.sph.zaobaochina:id/alertTitle")).getText();
		System.out.println(result);

//		driver.findElement(By.id("android:id/button1")).click();

//		driver.findElementByAccessibilityId("首页").click();
//
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		driver.findElementByAccessibilityId("联合早报").click();
//
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//
//		String resultCheck = driver.findElement(By.id("	com.zb.sph.zaobaochina:id/article_headline")).getText();
//		System.out.println(resultCheck);

	}

	@AfterClass
	public void end() {
		driver.quit();
	}
}
