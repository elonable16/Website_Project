package com.notice;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.commons.Action;
import com.commons.PagingVO;
import com.notice.*;
import com.shop.productDAO;
import com.shop.productVO;

public class NoticeListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		NoticeDAO nDao = NoticeDAO.getInstance();
		int pagenum = 1;
		int pagesize = 10;
		int groupsize = 10;
		String url="";
		productDAO pDao = productDAO.getInstance();
		PagingVO page = null;
		List<NoticeVO> list= null;
		
		if("".equals(request.getParameter("pagenum"))||request.getParameter("pagenum")==null) {
			pagenum = 1;
		}else {
			pagenum = Integer.parseInt(request.getParameter("pagenum"));
		}
		
		page = nDao.pagingAll(pagenum, pagesize, groupsize);
		list = nDao.selectAll(pagenum, pagesize);
		url="./Notice/notice_list.jsp";
		
		request.setAttribute("list", list);
		request.setAttribute("page", page);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
