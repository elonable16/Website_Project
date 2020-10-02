package com.commons;
import java.sql.*;

public class DBConn {
	public static Connection getConnection() {
		Connection conn = null;
//		String url = "jdbc:oracle:thin:@192.168.0.225:1521:oracle1";
//		String user = "elon";
//		String password = "1234";
		String url = "jdbc:mysql://localhost:3306/website?characterEncoding=utf-8&serverTimezone=UTC";
		String user = "kelon";
		String password = "1234kelon";
		try{
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,password);
			conn.setAutoCommit(false);
		} catch(Exception e) {
			System.out.println(e.toString());
		}
		return conn;
	}
	public static void close(Connection conn) {
		try {
			conn.setAutoCommit(true);
			conn.close();
		}catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
