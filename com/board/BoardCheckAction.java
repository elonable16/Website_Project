package com.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.commons.Action;

public class BoardCheckAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String b_num = request.getParameter("b_num");
		String b_passwd = request.getParameter("b_passwd");
		BoardDAO bDao = BoardDAO.getInstance();
		boolean chk = bDao.checkBoard(b_passwd, b_num);
		String url = "";
		if(chk) {
			url = "./mvcboard/checkOk.jsp";
		}else {
			url= "./mvcboard/boardCheck.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);				
	}
	
}
