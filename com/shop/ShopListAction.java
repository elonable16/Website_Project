package com.shop;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.commons.Action;

public class ShopListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int p_class=0;
		String url="";
		productDAO pDao = productDAO.getInstance();
		List<productVO> list= null;
		
		if(request.getParameter("p_class").equals("100")||request.getParameter("p_class").equals("200")||request.getParameter("p_class").equals("300")||request.getParameter("p_class").equals("400")) {			
			p_class=Integer.parseInt(request.getParameter("p_class"));
		}else {
			p_class=0;
		}

		
		if(p_class == 0){
			list = pDao.selectAll();
			url = "./shop/shop.jsp";
		}else if(p_class != 0) {
			list = pDao.selectCategory(p_class);
			url = "./shop/shop.jsp";
		}
		request.setAttribute("list", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}		
}
