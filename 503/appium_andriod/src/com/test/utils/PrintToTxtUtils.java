package com.test.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class PrintToTxtUtils {

	private static String phoneUrl = "d:\\phone.txt";
	private static String bankCardUrl = "d:\\bankCard.txt";

	public static void setPhoneToTxt(String content) {
		File fp = new File(phoneUrl);
		PrintWriter pfp;
		try {
			pfp = new PrintWriter(fp);
			pfp.print(content);
			pfp.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void setBankCardToTxt(String content) {
		File fp = new File(bankCardUrl);
		PrintWriter pfp;
		try {
			pfp = new PrintWriter(fp);
			pfp.print(content);
			pfp.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取自增1的手机号
	 * 
	 * @return
	 */
	public static String getNewPhoneTxt() {
		String phone = null;
		try {
			String encoding = "GBK";
			File file = new File(phoneUrl);
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					phone = String.valueOf(Long.valueOf(lineTxt) + 1);
					setPhoneToTxt(phone);
				}
				read.close();
				return phone;
			} else {
				// 文件不存在 创建文件
				setPhoneToTxt("18655555001");
				getNewPhoneTxt();
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取保存手机号
	 * 
	 * @return
	 */
	public static String getPhoneTxt() {
		String phone = null;
		try {
			String encoding = "GBK";
			File file = new File(phoneUrl);
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					phone = lineTxt;
				}
				read.close();
				return phone;
			} else {
				// 文件不存在 创建文件
				setPhoneToTxt("18655555001");
				getPhoneTxt();
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取自增1的银行卡号
	 * 
	 * @return
	 */
	public static String getNewBankCardTxt() {
		String bankCard = null;
		try {
			String encoding = "GBK";
			File file = new File(bankCardUrl);
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					bankCard = lineTxt.substring(0, lineTxt.length() - 4);
					String sub = String.valueOf(Long.valueOf(lineTxt.substring(lineTxt.length() - 4, lineTxt.length())) + 1);

					if (sub.length() < 3) {
						for (int i = 0; i < 4; i++) {
							sub = "0" + sub;
							if (sub.length() > 3) {
								break;
							}
						}
					}
					bankCard = bankCard + sub;
					setBankCardToTxt(bankCard);
				}
				read.close();
				return bankCard;
			} else {
				// 文件不存在 创建文件
				setBankCardToTxt("6222026853325220001");
				getNewBankCardTxt();
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取保存的银行卡
	 * 
	 * @return
	 */
	public static String getBankCardTxt() {
		String bankCard = null;
		try {
			String encoding = "GBK";
			File file = new File(bankCardUrl);
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					bankCard = lineTxt;
				}
				read.close();
				return bankCard;
			} else {
				// 文件不存在 创建文件
				setBankCardToTxt("6222026853325220001");
				getBankCardTxt();
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String args[]) throws Exception {
		System.out.println(getPhoneTxt());
		System.out.println(getNewPhoneTxt());
		System.out.println(getBankCardTxt());
		System.out.println(getNewBankCardTxt());
	}

}
