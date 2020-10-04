package com.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.commons.Action;
import com.notice.NoticeDAO;
import com.notice.NoticeVO;

public class NoticeViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int n_num = 0;
		String url ="";
		NoticeDAO nDao = NoticeDAO.getInstance();
		if("".equals(request.getParameter("n_num"))|| request.getParameter("n_num")==null) {
			url="./NoticeServlet?cmd=notice_list&pagenum=1";
		}else {
			n_num = Integer.parseInt(request.getParameter("n_num"));
			url="./Notice/notice_view.jsp";
		}
		
		nDao.clicknotice(n_num);
		NoticeVO nVo = nDao.selectOne(n_num);
		
		request.setAttribute("notice", nVo);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
