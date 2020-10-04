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
		String gm_num = request.getParameter("gm_num");
		String url="";
		if(gm_num == null) {
			url = "./BoardServlet?cmd=board_list";
		}else {
			BoardDAO dDao = BoardDAO.getInstance();
			List<BoardVO> list = dDao.selectBoardItem(Integer.parseInt(gm_num));
			
			url = "./GuestBook/guestbook_view.jsp";			
			request.setAttribute("board", list);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
