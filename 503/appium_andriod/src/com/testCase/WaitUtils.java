package com.testCase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

	/**
	 * 等待元素出现
	 * 
	 * @param driver
	 * @param by
	 * @param waitTime
	 */
	public static void waitForVisible(WebDriver driver, By by, int waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		for (int attempt = 0; attempt < waitTime; attempt++) {
			System.out.println("attempt:" + attempt);
			try {
				driver.findElement(by);
				break;
			} catch (Exception e) {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			}
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	/**
	 * 等待元素出现
	 * 
	 * @param driver
	 * @param by
	 * @param waitTime
	 * @param onWaitForByListener
	 */
	public static void waitForVisible(WebDriver driver, By by, int waitTime, OnWaitForByListener onWaitForByListener) {
		for (int attempt = 0; attempt < waitTime; attempt++) {
			System.out.println("attempt:" + attempt);
			try {
				driver.findElement(by);
				if (onWaitForByListener != null) {
					onWaitForByListener.success();
				}
				break;
			} catch (Exception e) {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			}
		}

		if (onWaitForByListener != null) {
			onWaitForByListener.fail();
		}

	}

	/**
	 * 等待元素出现
	 * 
	 * @param driver
	 * @param by
	 * @param waitTime
	 * @param onWaitForByListener
	 * @param end
	 *            true为抛异常，结束
	 */
	public static void waitForVisible(WebDriver driver, By by, int waitTime, OnWaitForByListener onWaitForByListener,
			boolean end) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		for (int attempt = 0; attempt < waitTime; attempt++) {
			System.out.println("attempt:" + attempt);
			try {
				driver.findElement(by);
				if (onWaitForByListener != null) {
					onWaitForByListener.success();
				}
				break;
			} catch (Exception e) {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			}
		}

		if (onWaitForByListener != null) {
			onWaitForByListener.fail();
		}

		if (end) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		}
	}

	public interface OnWaitForByListener {
		public void success();

		public void fail();
	}

}
