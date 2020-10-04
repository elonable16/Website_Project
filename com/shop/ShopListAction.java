package com.shop;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.commons.Action;
import com.commons.PagingVO;

public class ShopListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int p_class=0;
		int pagenum = 1;
		int pagesize = 9;
		int groupsize = 5;
		String url="";
		productDAO pDao = productDAO.getInstance();
		PagingVO page = null;
		List<productVO> list= null;
		
		if("".equals(request.getParameter("pagenum"))||request.getParameter("pagenum")==null) {
			pagenum = 1;
		}else {
			pagenum = Integer.parseInt(request.getParameter("pagenum"));
		}
		
		if(request.getParameter("p_class").equals("100")||request.getParameter("p_class").equals("200")||request.getParameter("p_class").equals("300")||request.getParameter("p_class").equals("400")) {			
			p_class=Integer.parseInt(request.getParameter("p_class"));
		}else {
			p_class=0;
		}

		
		if(p_class == 0){
			page = pDao.pagingAll(pagenum, pagesize, groupsize);
			list = pDao.selectAll(pagenum, pagesize);
			url = "./shop/shop.jsp";
		}else if(p_class != 0) {
			page = pDao.pagingCategory(p_class, pagenum, pagesize, groupsize);
			list = pDao.selectCategory(p_class, pagenum, pagesize);
			url = "./shop/shop.jsp";
		}
		request.setAttribute("list", list);
		request.setAttribute("page", page);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}		
}
