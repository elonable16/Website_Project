package com.notice;
import java.sql.*;
import java.util.*;
import com.commons.MyDate;
import com.commons.DBConn;
public class NoticeDAO {
	private static NoticeDAO instance = null;
	private NoticeDAO() {}
	public static NoticeDAO getInstance() {
		if(instance ==null) {
			instance = new NoticeDAO();
		}
		return instance;
	}
	public List<NoticeVO> selectAll(){
		String sql = "";
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		try {
			sql = "select * from notice order by n_num desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				NoticeVO nVo = new NoticeVO();
				nVo.setN_num(rs.getInt("n_num"));
				nVo.setN_name(rs.getString("n_name"));
				nVo.setN_subject(rs.getString("n_subject"));
				nVo.setN_date(rs.getString("n_date"));
				nVo.setN_contents(rs.getString("n_contents"));
				list.add(nVo);
			}
			rs.close();
			pstmt.close();
		}catch(Exception e) {
			System.out.println(e.toString());
		}finally {
			DBConn.close(conn);
		}
		return list;
	}
	public NoticeVO selectOne(int n_num) {
		String sql = "";
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		NoticeVO nVo = new NoticeVO();
		try {
			sql = "select * from notice where n_num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, n_num);
			rs = pstmt.executeQuery();
			rs.next();
			nVo.setN_num(rs.getInt("n_num"));
			nVo.setN_name(rs.getString("n_name"));
			nVo.setN_subject(rs.getString("n_subject"));
			nVo.setN_date(rs.getString("n_date"));
			nVo.setN_contents(rs.getString("n_contents"));
			rs.close();
			pstmt.close();
		}catch(Exception e) {
			System.out.println(e.toString());
		}finally {
			DBConn.close(conn);
		}
		return nVo;
	}
}
