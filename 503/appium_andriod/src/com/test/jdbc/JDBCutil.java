package com.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 */
public class JDBCutil {
	public static void main(String[] args) {
		String driver = "com.mysql.jdbc.Driver";
		String dbName = "guser";
		String passwrod = "soI002Ja18va";
		String userName = "weber";
		String url = "jdbc:mysql://182.92.169.114:3306/" + dbName;
		String sql = "select value from temp_code where toObj= 18699991291";

		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, userName, passwrod);
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				// System.out.println(
				// "id : " + rs.getInt(1) + " name : " + rs.getString(2) + "
				// password : " + rs.getString(3));

				System.out.println("--------------" + rs.getString("value"));
			}

			// 关闭记录集
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			// 关闭声明
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			// 关闭链接对象
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		} catch (

		Exception e) {
			e.printStackTrace();
		}
	}

	public void JBDCData() {

	}

	public String getRm(String phone) {
		String driver = "com.mysql.jdbc.Driver";
		String dbName = "guser";
		String passwrod = "soI002Ja18va";
		String userName = "weber";
		String url = "jdbc:mysql://182.92.169.114:3306/" + dbName;
		String sql = "select value from temp_code where toObj= " + phone+ " order by (sendTime) desc ";

		String rm = "";

		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, userName, passwrod);
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				rm = rs.getString("value");
			}

			// 关闭记录集
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			// 关闭声明
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			// 关闭链接对象
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return rm;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rm;
	}//获取验证码


public String getpid(String proid) {
	String driver = "com.mysql.jdbc.Driver";
	String dbName = "gaosouyi42";
	String passwrod = "soI002Ja18va";
	String userName = "weber";
	String url = "jdbc:mysql://182.92.169.114:3306/" + dbName;
	String sql = "SELECT name from gaosouyi42.g_p2p_product where flag = 1 and UNIX_TIMESTAMP() > payTime and UNIX_TIMESTAMP() < beginTime and timeLimit = 30 and activityId = 0";

	String pid = "";

	try {
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, userName, passwrod);
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			pid = rs.getString("name");
		}

		// 关闭记录集
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// 关闭声明
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// 关闭链接对象
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return pid;
	} catch (Exception e) {
		e.printStackTrace();
	}
	return pid;
}//获取 在售30天标的名称
public String getres(String SqlN,String res) {
	String driver = "com.mysql.jdbc.Driver";
	String dbName = "gaosouyi42";
	String passwrod = "soI002Ja18va";
	String userName = "weber";
	String url = "jdbc:mysql://182.92.169.114:3306/" + dbName;
      
	String result = "";

	try {
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, userName, passwrod);
		PreparedStatement ps = conn.prepareStatement(SqlN);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			result = rs.getString(res);
		}

		// 关闭记录集
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// 关闭声明
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// 关闭链接对象
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	} catch (Exception e) {
		e.printStackTrace();
	}
	return result;//传sql语句和查询的字段
}

public void getins(String SqlN) {
	String driver = "com.mysql.jdbc.Driver";
	String dbName = "gaosouyi42";
	String passwrod = "soI002Ja18va";
	String userName = "weber";
	String url = "jdbc:mysql://182.92.169.114:3306/" + dbName;
      

	try {
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, userName, passwrod);
		PreparedStatement ps = conn.prepareStatement(SqlN);
		boolean rs = ps.execute();

		if (rs == true) {
			//result = rs.getString(res);
		}

		// 关闭记录集
		
		// 关闭声明
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// 关闭链接对象
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//return result;
	} catch (Exception e) {
		e.printStackTrace();
	}
	//return result;//传sql语句和查询的字段
}
}
