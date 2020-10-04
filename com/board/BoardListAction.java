package com.board;
import java.util.*;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.commons.Action;
import com.commons.PagingVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletException;

public class BoardListAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String pagenum = request.getParameter("pagenum");
		String url = "./GuestBook/guestbook_list.jsp";
		int pgnum = 1;
		int pagesize = 10;
		int groupsize = 10;
		if(pagenum == null) {
			pgnum = 1;
		}else {
			pgnum = Integer.parseInt(pagenum);
		}
		
		BoardDAO bDao = BoardDAO.getInstance();
		PagingVO page = bDao.pagingBoard(pgnum, pagesize, groupsize);
		List<BoardVO> list = bDao.selectAll(pgnum,pagesize);
		request.setAttribute("list", list); //view로 데이터 전송
		request.setAttribute("page", page);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}
}
