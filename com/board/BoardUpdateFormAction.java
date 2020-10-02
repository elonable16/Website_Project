package com.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.board.BoardDAO;
import com.board.BoardVO;
import com.commons.Action;

public class BoardUpdateFormAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String b_num = request.getParameter("b_num");
		BoardDAO bDao = BoardDAO.getInstance();
		BoardVO bVo = bDao.selectBoardItem(Integer.parseInt(b_num));
		String url = "./mvcboard/boardUpdate.jsp";
		request.setAttribute("boardone", bVo);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);	
	}

}
