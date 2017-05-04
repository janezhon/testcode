package com.test.jdbc;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class login {
	public void loginzc(String phone, AndroidDriver<WebElement> driver, OnLoginListener onLoginListener) {

		try {
			driver.findElementById("login_phone").click();
			driver.findElementById("login_phone").sendKeys(phone);// 用户注册


			
			Thread.sleep(2000);
			driver.findElementById("login_next").click();
			Thread.sleep(2000);

			// String phone = "186 7777 1294";
			String phone1 = phone.substring(0, 3) + phone.substring(4, 8) + phone.substring(8, 4);
			System.out.print(phone1);
			JDBCutil mJDBCutil = new JDBCutil();
			String rm = mJDBCutil.getRm(phone1);
			Thread.sleep(5000);// 获取验证码

			driver.findElementById("reg_code").sendKeys(rm);
			Thread.sleep(2000);
			driver.findElementById("reg_pwd").sendKeys("222222");
			Thread.sleep(2000);
			driver.findElementById("reg_rcmder").sendKeys("1899135");// 填入高手码
			Thread.sleep(2000);
			driver.hideKeyboard();
			Thread.sleep(1000);// 收起键盘
			driver.findElementById("reg_next").click();
			Thread.sleep(5000);
			if (driver.getPageSource().contains("跳过")) {
				System.out.print("注册成功");
			} else {
				System.out.print("注册失败");
			}
			Thread.sleep(12000);
			driver.findElementByXPath("//android.view.View[contains(@content-desc,'开户领180元现金红包')]").click();
			//driver.findElementById("tv_cancel").click();
			Thread.sleep(2000);
			if (onLoginListener != null) {
				onLoginListener.success();
			}
		} catch (Exception e) {
			if (onLoginListener != null) {
				onLoginListener.faile();
			}
		}
	}

	public interface OnLoginListener {
		void success();

		void faile();
	}
}
