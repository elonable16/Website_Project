package com.board;
import java.util.*;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.commons.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletException;

public class BoardListAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String pagenum = request.getParameter("pagenum");
		String url = "./mvcboard/boardlist.jsp";
		int pgnum = 1;
		if(pagenum == null) {
			pgnum = 1;
		}else {
			pgnum = Integer.parseInt(pagenum);
		}
		
		BoardDAO bDao = BoardDAO.getInstance();
		PagingVO pVo = bDao.pagingBoard(pgnum, 3, 5);
		List<BoardVO> list = bDao.selectAll(pgnum,pVo.getPagesize());
		request.setAttribute("list", list); //view로 데이터 전송
		request.setAttribute("pagedata", pVo);
		
		HttpSession session = request.getSession();
		session.setAttribute("m_id", "elon");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
		
	}
}
