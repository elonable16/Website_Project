package com.board;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ListModel;

import com.board.BoardDAO;
import com.board.BoardVO;
import com.commons.Action;


public class BoardViewAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String b_num = request.getParameter("b_num");
		String url = "./mvcboard/boardView.jsp";
		BoardDAO dDao = BoardDAO.getInstance();
		BoardVO bVo = dDao.selectBoardItem(Integer.parseInt(b_num));
		request.setAttribute("boardone", bVo);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
