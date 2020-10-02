package com.shop;
import java.sql.*;
import java.util.*;
import com.commons.MyDate;
import com.commons.DBConn;
public class productDAO {
	private static productDAO instance = null;
	private productDAO() {}
	public static productDAO getInstance() {
		if(instance ==null) {
			instance = new productDAO();
		}
		return instance;
	}
	public List<productVO> selectAll(){
		String sql = "";
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<productVO> list = new ArrayList<productVO>();
		try {
			sql = "select * from product order by p_grade desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				productVO pVo = new productVO();
				pVo.setP_code(rs.getInt("p_code"));
				pVo.setP_class(rs.getInt("p_class"));
				pVo.setP_name(rs.getString("p_name"));
				pVo.setP_stock(rs.getInt("p_stock"));
				pVo.setP_grade(rs.getFloat("p_grade"));
				pVo.setP_price(rs.getInt("p_price"));
				pVo.setP_image1(rs.getString("p_image1"));
				pVo.setP_image2(rs.getString("p_image2"));
				pVo.setP_image3(rs.getString("p_image3"));
				pVo.setP_image4(rs.getString("p_image4"));
				pVo.setP_detail(rs.getString("p_detail"));
				pVo.setP_sale(rs.getString("p_sale"));
				list.add(pVo);
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
	public List<productVO> selectCategory(int p_class){
		String sql = "";
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<productVO> list = new ArrayList<productVO>();
		try {
			sql = "select * from product where p_class=? order by p_grade desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,p_class);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				productVO pVo = new productVO();
				pVo.setP_code(rs.getInt("p_code"));
				pVo.setP_class(rs.getInt("p_class"));
				pVo.setP_name(rs.getString("p_name"));
				pVo.setP_stock(rs.getInt("p_stock"));
				pVo.setP_grade(rs.getFloat("p_grade"));
				pVo.setP_price(rs.getInt("p_price"));
				pVo.setP_image1(rs.getString("p_image1"));
				pVo.setP_image2(rs.getString("p_image2"));
				pVo.setP_image3(rs.getString("p_image3"));
				pVo.setP_image4(rs.getString("p_image4"));
				pVo.setP_detail(rs.getString("p_detail"));
				pVo.setP_sale(rs.getString("p_sale"));
				list.add(pVo);
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
	public List<productVO> selectSaleList(){
		String sql = "";
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<productVO> list = new ArrayList<productVO>();
		try {
			sql = "select * from product where p_sale='Y' order by p_grade desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				productVO pVo = new productVO();
				pVo.setP_code(rs.getInt("p_code"));
				pVo.setP_class(rs.getInt("p_class"));
				pVo.setP_name(rs.getString("p_name"));
				pVo.setP_stock(rs.getInt("p_stock"));
				pVo.setP_grade(rs.getFloat("p_grade"));
				pVo.setP_price(rs.getInt("p_price"));
				pVo.setP_image1(rs.getString("p_image1"));
				pVo.setP_image2(rs.getString("p_image2"));
				pVo.setP_image3(rs.getString("p_image3"));
				pVo.setP_image4(rs.getString("p_image4"));
				pVo.setP_detail(rs.getString("p_detail"));
				pVo.setP_sale(rs.getString("p_sale"));
				list.add(pVo);
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
	public List<productVO> selectBestList(){
		String sql = "";
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<productVO> list = new ArrayList<productVO>();
		try {
			sql = "select * from product where p_grade>=4.5 order by p_grade desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				productVO pVo = new productVO();
				pVo.setP_code(rs.getInt("p_code"));
				pVo.setP_class(rs.getInt("p_class"));
				pVo.setP_name(rs.getString("p_name"));
				pVo.setP_stock(rs.getInt("p_stock"));
				pVo.setP_grade(rs.getFloat("p_grade"));
				pVo.setP_price(rs.getInt("p_price"));
				pVo.setP_image1(rs.getString("p_image1"));
				pVo.setP_image2(rs.getString("p_image2"));
				pVo.setP_image3(rs.getString("p_image3"));
				pVo.setP_image4(rs.getString("p_image4"));
				pVo.setP_detail(rs.getString("p_detail"));
				pVo.setP_sale(rs.getString("p_sale"));
				list.add(pVo);
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
	public productVO selectProduct(int p_code){
		String sql = "";
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		productVO pVo= new productVO();
		try {
			sql = "select * from product where p_code=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, p_code);
			rs = pstmt.executeQuery();
			rs.next();
			pVo.setP_code(rs.getInt("p_code"));
			pVo.setP_class(rs.getInt("p_class"));
			pVo.setP_name(rs.getString("p_name"));
			pVo.setP_stock(rs.getInt("p_stock"));
			pVo.setP_grade(rs.getFloat("p_grade"));
			pVo.setP_price(rs.getInt("p_price"));
			pVo.setP_image1(rs.getString("p_image1"));
			pVo.setP_image2(rs.getString("p_image2"));
			pVo.setP_image3(rs.getString("p_image3"));
			pVo.setP_image4(rs.getString("p_image4"));
			pVo.setP_detail(rs.getString("p_detail"));
			pVo.setP_sale(rs.getString("p_sale"));
			rs.close();
			pstmt.close();
		}catch(Exception e) {
			System.out.println(e.toString());
		}finally {
			DBConn.close(conn);
		}
		return pVo;
	}
//	public productVO selectOne(int n_num) {
//		String sql = "";
//		Connection conn = DBConn.getConnection();
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		productVO nVo = new productVO();
//		try {
//			sql = "select * from notice where n_num = ?";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, n_num);
//			rs = pstmt.executeQuery();
//			rs.next();
//			nVo.setN_num(rs.getInt("n_num"));
//			nVo.setN_name(rs.getString("n_name"));
//			nVo.setN_subject(rs.getString("n_subject"));
//			nVo.setN_date(rs.getString("n_date"));
//			nVo.setN_contents(rs.getString("n_contents"));
//			rs.close();
//			pstmt.close();
//		}catch(Exception e) {
//			System.out.println(e.toString());
//		}finally {
//			DBConn.close(conn);
//		}
//		return nVo;
//	}
}
