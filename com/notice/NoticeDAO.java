package com.notice;
import java.sql.*;
import java.util.*;
import com.commons.MyDate;
import com.commons.PagingVO;
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
	public List<NoticeVO> selectAll(int pagenum, int pagesize){
		String sql = "";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		try {
			conn = DBConn.getConnection();
			sql = "select * from ";
			sql += "(select * from ";
			sql += "(select @rownum:=@rownum+1 as SEQ, n_num, n_category, ad_id, n_contents, n_datefirst, n_datelast, n_cnt, n_ip, n_subject, ad_name from ";
			sql += "(select no.*,ad_name from notice no,webadmin w where no.ad_id = w.ad_id order by n_num desc) as n where (@rownum:=0)=0 ";
			sql += ")as n2 "; // 페이지 번호
			sql += ")as n3 limit ?, ?"; // 페이지 단위
			
//			sql = "select * from ";
//			sql += "(select * from ";
//			sql += "(select rownum as SEQ, n_num, n_category, ad_id, n_contents, n_datefirst, n_datelast, n_cnt, n_ip, n_subject from ";
//			sql += "(select * from notice order by n_num desc)";
//			sql += " )where SEQ >= ? "; // 페이지 번호
//			sql += ")where rownum <= ?"; // 페이지 단위
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,(pagenum-1)*pagesize);
			pstmt.setInt(2,pagesize);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				NoticeVO nVo = new NoticeVO();
				nVo.setN_num(rs.getInt("n_num"));
				nVo.setN_category(rs.getString("n_category"));
				nVo.setAd_id(rs.getString("ad_id"));
				nVo.setN_contents(rs.getString("n_contents"));
				nVo.setN_datefirst(rs.getString("n_datefirst"));
				nVo.setN_datelast(rs.getString("n_datelast"));
				nVo.setN_cnt(rs.getInt("n_cnt"));
				nVo.setN_ip(rs.getString("n_ip"));
				nVo.setN_subject(rs.getString("n_subject"));
				nVo.setAd_name(rs.getString("ad_name"));
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
			sql = "select no.*, w.ad_name from notice no,webadmin w where no.ad_id = w.ad_id and n_num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, n_num);
			rs = pstmt.executeQuery();
			rs.next();
			nVo.setN_num(rs.getInt("n_num"));
			nVo.setN_category(rs.getString("n_category"));
			nVo.setAd_id(rs.getString("ad_id"));
			nVo.setN_contents(rs.getString("n_contents"));
			nVo.setN_datefirst(rs.getString("n_datefirst"));
			nVo.setN_datelast(rs.getString("n_datelast"));
			nVo.setN_cnt(rs.getInt("n_cnt"));
			nVo.setN_ip(rs.getString("n_ip"));
			nVo.setN_subject(rs.getString("n_subject"));
			nVo.setAd_name(rs.getString("ad_name"));
			rs.close();
			pstmt.close();
		}catch(Exception e) {
			System.out.println(e.toString());
		}finally {
			DBConn.close(conn);
		}
		return nVo;
	}
	public PagingVO pagingAll(int pagenum, int pagesize, int groupsize) {
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
			sql = "select count(n_num) from notice";
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
	public void clicknotice(int n_num) {
		String sql = "";
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		try {
			sql = "update notice set n_cnt=n_cnt+1 where n_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,n_num);
			pstmt.executeUpdate();
			pstmt.close();
			conn.commit();
		}catch(Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.toString());
			}
			System.out.println(e.toString());
		}finally {
			DBConn.close(conn);
		}
	}
}
