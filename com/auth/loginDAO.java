package com.auth;

import com.commons.DBConn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginDAO {
	private static loginDAO instance = null;
	private loginDAO() {
	}
	public static loginDAO getInstance() {
		if(instance == null) {
			instance = new loginDAO();
		}
		return instance;
	}
	public boolean checkLogin(String id, String passwd) {
		String sql = "";
		Connection conn = null;
		PreparedStatement  pstmt = null;
		ResultSet rs = null;
		boolean chk = false;
		try {
			conn = DBConn.getConnection();
			sql = "select count(id) from customer where id=? and passwd=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			rs = pstmt.executeQuery();
			rs.next();
			if(rs.getInt(1)==1) {
				chk=true;
			}
			rs.close();
			pstmt.close();
		}catch(Exception e) {
			System.out.println(e.toString());
		}finally {
			DBConn.close(conn);
		}	
		return chk;
	}
	public boolean checkId(String id) {
		String sql = "";
		Connection conn = null;
		PreparedStatement  pstmt = null;
		ResultSet rs = null;
		boolean chk = false;
		try {
			conn = DBConn.getConnection();
			sql = "select count(id) from customer where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			if(rs.getInt(1)==1) {
				chk=true;   // 중복아이피가 있는 경우
			}
			rs.close();
			pstmt.close();
		}catch(Exception e) {
			System.out.println(e.toString());
		}finally {
			DBConn.close(conn);
		}	
		return chk;
	}
	public void insertCustomer(String id, String email, String passwd, String phone, String signin, String u_name, String ip) {
		String sql = "";
		Connection conn = null;
		PreparedStatement  pstmt = null;
		try {
			conn = DBConn.getConnection();
			sql = "insert into customer values (get_seq('seq_custom'),?,?,?,?,?,null,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, email);
			pstmt.setString(3, passwd);
			pstmt.setString(4, phone);
			pstmt.setString(5, signin);
			pstmt.setString(6, u_name);
			pstmt.setString(7, ip);
			System.out.println(sql);
			pstmt.executeUpdate();
			pstmt.close();
			conn.commit();
		}catch(Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			System.out.println(e.toString());
		}finally {
			DBConn.close(conn);
		}	
	}
}
