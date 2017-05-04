package com.test.utils;

import org.openqa.selenium.JavascriptExecutor;

import io.appium.java_client.android.AndroidDriver;

public class DriverUtil {
	
	/**
	 * 滑动屏幕
	 * @param startX
	 * @param startY
	 * @param endX
	 * @param endY
	 * @param duration
	 * @param repeat
	 * @param driver
	 */
	public static void swipeScreen(Double startX, Double startY, Double endX, Double endY, int duration, int repeat,
			AndroidDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		java.util.HashMap<String, Double> swipeObj = new java.util.HashMap<String, Double>();
		swipeObj.put("startX", startX);
		swipeObj.put("startY", startY);
		swipeObj.put("endX", endX);
		swipeObj.put("endY", endY);
		for (int i = 0; i < repeat; i++) {
			try {
				js.executeScript("mobile: flick", swipeObj);
			} catch (Exception ex) {
				System.out.println("滑动屏幕失败");
			}
		}
	}
}