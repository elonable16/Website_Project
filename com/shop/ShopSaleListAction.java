package com.shop;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.commons.Action;

public class ShopSaleListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String url="";
		productDAO pDao = productDAO.getInstance();
		List<productVO> list= null;		
		list = pDao.selectSaleList();
		url = "./shop/shop_sale.jsp";
		request.setAttribute("list", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}		
}
