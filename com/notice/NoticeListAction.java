package com.notice;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.notice.*;

public class NoticeListAction implements ActionNotice{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		NoticeDAO nDao = NoticeDAO.getInstance();
		List<NoticeVO> list = nDao.selectAll();
		String url="./mvcnotice/noticelist.jsp";
		
		request.setAttribute("noticelist", list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
