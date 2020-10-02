package com.shop;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import com.commons.Action;
public class productViewAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String url="";
		if("".equals(request.getParameter("p_code"))||request.getParameter("p_code")==null) {
			url="./HomeServlet?cmd=main";
		}else{			
			int p_code = Integer.parseInt(request.getParameter("p_code"));
			productDAO pDao = productDAO.getInstance();
			productVO pVo = pDao.selectProduct(p_code);
			request.setAttribute("product", pVo);
			url="./shop/product_view.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
