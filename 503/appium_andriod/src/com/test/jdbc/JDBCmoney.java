package com.test.jdbc;

public class JDBCmoney {

	public static void main(String[] args) {
		JDBCutil mJDBCutil = new JDBCutil();
		String mid = mJDBCutil.getres("SELECT mid from guser.user where phone = 18699991399","mid");//从此处获取mid，后续从这里一起改
		double banlance= Double.parseDouble(mJDBCutil.getres("SELECT balance from trade.wallet where mid = "+mid,"balance"));	
	
	
	}
}
