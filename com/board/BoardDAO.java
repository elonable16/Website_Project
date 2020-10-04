package com.board;
import java.sql.*;
import java.util.*;
import com.commons.MyDate;
import com.commons.DBConn;
import com.commons.PagingVO;
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
			sql += "(select @rownum:=@rownum+1 as SEQ, gm_num, gm_subject, gm_name,gm_passwd, gm_datew, gm_dateu, gm_content, gm_cnt from ";
			sql += "(select * from guestbook_main order by gm_num desc) as gm where (@rownum:=0)=0 ";
			sql += ")as gm2 "; // 페이지 번호
			sql += ")as gm3 limit ?, ?"; // 페이지 단위
			
			
//			sql = "select * from ";
//			sql += "(select * from ";
//			sql += "(select rownum as SEQ, gm_num, gm_subject, gm_name,gm_passwd, gm_datew, gm_dateu, gm_contents from ";
//			sql += "(select * from guestbook_main gm order by gm_num desc)";
//			sql += " )where SEQ >= ? "; // 페이지 번호
//			sql += ")where rownum <=?"; // 페이지 단위
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,(pagenum-1)*pagesize);
			pstmt.setInt(2,pagesize);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO bVo = new BoardVO();
				bVo.setGm_num(rs.getInt("gm_num"));
				bVo.setGm_subject(rs.getString("gm_subject"));
				bVo.setGm_name(rs.getString("gm_name"));
				bVo.setGm_passwd(rs.getString("gm_passwd"));
				bVo.setGm_datew(rs.getString("gm_datew"));
				bVo.setGm_dateu(rs.getString("gm_dateu"));
				bVo.setGm_content(rs.getString("gm_content"));
				bVo.setGm_cnt(rs.getInt("gm_cnt"));
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
	
	public List<BoardVO> selectBoardItem(int gm_num) {
		String sql = "";
		Connection conn = null;
		PreparedStatement  pstmt = null;
		ResultSet rs = null;
		BoardVO bVo = null;
		List<BoardVO> list = new ArrayList<BoardVO>();
		try {
			
			conn = DBConn.getConnection();
			sql = "select * from guestbook_main gm,guestbook_sub gs where gm.gm_num=? and gm.gm_num=gs.gm_num order by gs.gs_num desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gm_num);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				bVo = new BoardVO();
				bVo.setGm_num(rs.getInt("gm_num"));
				bVo.setGm_subject(rs.getString("gm_subject"));
				bVo.setGm_name(rs.getString("gm_name"));
				bVo.setGm_passwd(rs.getString("gm_passwd"));
				bVo.setGm_datew(rs.getString("gm_datew"));
				bVo.setGm_dateu(rs.getString("gm_dateu"));
				bVo.setGm_content(rs.getString("gm_content"));
				bVo.setGm_cnt(rs.getInt("gm_cnt"));
				bVo.setGs_num(rs.getInt("gs_num"));
				bVo.setGs_name(rs.getString("gs_name"));
				bVo.setGs_contents(rs.getString("gs_contents"));
				bVo.setGs_datew(rs.getString("gs_datew"));
				bVo.setGs_dateu(rs.getString("gs_dateu"));
				bVo.setGs_ip(rs.getString("gs_ip"));
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
			sql = "select count(gm_num) from guestbook_main";
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
