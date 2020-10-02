package com.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.board.BoardDAO;
import com.commons.Action;

public class BoardDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String b_num = request.getParameter("b_num");
		BoardDAO bDao = BoardDAO.getInstance();
		bDao.deleteBoard(Integer.parseInt(b_num));
		response.sendRedirect("./BoardServlet?cmd=board_list");
	}

}
