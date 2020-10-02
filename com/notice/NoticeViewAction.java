package com.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.notice.NoticeDAO;
import com.notice.NoticeVO;

public class NoticeViewAction implements ActionNotice {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String n_num = request.getParameter("n_num");
		NoticeDAO nDao = NoticeDAO.getInstance();
		NoticeVO nVo = nDao.selectOne(Integer.parseInt(n_num));
		String url ="./mvcnotice/noticeView.jsp";
		
		request.setAttribute("notice", nVo);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
