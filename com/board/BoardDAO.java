package com.board;
import java.sql.*;
import java.util.*;
import com.commons.MyDate;
import com.commons.DBConn;

public class BoardDAO {
	private static BoardDAO instance = null;
	private BoardDAO() {
	}
	public static BoardDAO getInstance() {
		if(instance == null) {
			instance = new BoardDAO();
		}
		return instance;
	}
	public List<BoardVO> selectAll(int pagenum, int pagesize){ // 전체 레코드셋 저장
		String sql = "";
		Connection conn = null;
		PreparedStatement  pstmt = null;
		ResultSet rs = null;
		List<BoardVO> list = new ArrayList<BoardVO>();
		try {
			conn = DBConn.getConnection();
			sql = "select * from ";
			sql += "(select * from ";
			sql += "(select rownum as SEQ, b_num, b_subject, b_name,b_passwd, b_date,b_contents from ";
			sql += "(select * from mvcboard b order by b_num desc)";
			sql += " )where SEQ >= ? "; // 페이지 번호
			sql += ")where rownum <=?"; // 페이지 단위
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,(pagenum-1)*pagesize+1);
			pstmt.setInt(2,pagesize);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO bVo = new BoardVO();
				bVo.setB_num(rs.getInt("b_num"));
				bVo.setB_subject(rs.getString("b_subject"));
				bVo.setB_name(rs.getString("b_name"));
				bVo.setB_passwd(rs.getString("b_passwd"));
				bVo.setB_date(rs.getString("b_date"));
				bVo.setB_contents(rs.getString("b_contents"));
				list.add(bVo);
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
	public void insertBoard(BoardVO bVo) {
		String sql = "";
		Connection conn = null;
		PreparedStatement  pstmt = null;
		try {
			conn = DBConn.getConnection();
			sql = "insert into mvcboard values(seq_mb_num.nextval,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bVo.getB_subject());
			pstmt.setString(2, bVo.getB_name());
			pstmt.setString(3, bVo.getB_passwd());
			pstmt.setString(4, MyDate.getDate());
			pstmt.setString(5, bVo.getB_contents());
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
	
	public BoardVO selectBoardItem(int b_num) {
		String sql = "";
		Connection conn = null;
		PreparedStatement  pstmt = null;
		ResultSet rs = null;
		BoardVO bVo = null;
		try {
			conn = DBConn.getConnection();
			sql = "select * from mvcboard where b_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b_num);
			rs = pstmt.executeQuery();
			rs.next();
			bVo = new BoardVO();
			bVo.setB_num(rs.getInt("b_num"));
			bVo.setB_subject(rs.getString("b_subject"));
			bVo.setB_name(rs.getString("b_name"));
			bVo.setB_passwd(rs.getString("b_passwd"));
			bVo.setB_date(rs.getString("b_date"));
			bVo.setB_contents(rs.getString("b_contents"));
			rs.close();
			pstmt.close();
		}catch(Exception e) {
				System.out.println(e.toString());
		}finally {
			DBConn.close(conn);
		}
		return bVo;
	}
	
	public boolean checkBoard(String b_passwd,String b_num) {
		String sql = "";
		Connection conn = null;
		PreparedStatement  pstmt = null;
		ResultSet rs = null;
		boolean chk = false;
		try {
			conn = DBConn.getConnection();
			sql = "select count(b_num) from mvcboard where b_num=? and b_passwd=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(b_num));
			pstmt.setString(2, b_passwd);
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
	public void updateBoard(BoardVO bVo) {
		String sql = "";
		Connection conn = null;
		PreparedStatement  pstmt = null;
		try {
			conn = DBConn.getConnection();
			sql = "update mvcboard set b_subject=?, b_name=?, b_contents=? where b_num =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bVo.getB_subject());
			pstmt.setString(2, bVo.getB_name());
			pstmt.setString(3, bVo.getB_contents());
			pstmt.setInt(4, bVo.getB_num());
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
	public void deleteBoard(int b_num) {
		String sql = "";
		Connection conn = null;
		PreparedStatement  pstmt = null;
		try {
			conn = DBConn.getConnection();
			sql = "delete from mvcboard where b_num =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b_num);
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
	public PagingVO pagingBoard(int pagenum, int pagesize, int groupsize) {
		String sql = "";
		Connection conn = null;
		PreparedStatement  pstmt = null;
		ResultSet rs = null;
		PagingVO pVo = null;
		int startpage =1;
		int endpage=1;
		int lastpage=1;
		try {
			conn = DBConn.getConnection();
			sql = "select count(b_num) from mvcboard";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			pVo = new PagingVO();
			int total = rs.getInt(1);
			rs.close();
			pstmt.close();
			lastpage = (total-1)/pagesize + 1;
			startpage = (pagenum - 1)/groupsize * groupsize + 1; 
			endpage = startpage + groupsize -1;
			pVo.setEndpage(endpage);
			pVo.setGroupsize(groupsize);
			pVo.setLastpage(lastpage);
			pVo.setPagenum(pagenum);
			pVo.setPagesize(pagesize);
			pVo.setStartpage(startpage);
		}catch(Exception e) {
				System.out.println(e.toString());
		}finally {
			DBConn.close(conn);
		}
		return pVo;
	}
	
}
