package com.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.commons.Action;

public class BoardCheckFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String b_num = request.getParameter("b_num");
		String url = "./mvcboard/boardCheck.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
//		request.setAttribute("b_num", b_num);
		dispatcher.forward(request, response);
		
	}
	
}
