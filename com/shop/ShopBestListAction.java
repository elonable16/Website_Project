package com.shop;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.commons.Action;
import com.commons.PagingVO;

public class ShopBestListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int p_class=0;
		int pagenum = 1;
		int pagesize = 9;
		int groupsize = 5;
		String url="";
		PagingVO page = null;
		List<productVO> list= null;
		productDAO pDao = productDAO.getInstance();
		
		if("".equals(request.getParameter("pagenum"))||request.getParameter("pagenum")==null) {
			pagenum = 1;
		}else {
			pagenum = Integer.parseInt(request.getParameter("pagenum"));
		}
		
		page = pDao.pagingbest(pagenum, pagesize, groupsize);
		list = pDao.selectBestList(pagenum, pagesize);
		url = "./shop/shop_best.jsp";
		
		request.setAttribute("list", list);
		request.setAttribute("page", page);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}		
}
