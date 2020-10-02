package com.board;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletException;
import com.board.BoardDAO;
import com.board.BoardVO;
import com.commons.Action;

public class BoardUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String b_num = request.getParameter("b_num");
		String b_name = request.getParameter("b_name");
		String b_subject = request.getParameter("b_subject");
		String b_contents = request.getParameter("b_contents");
		BoardDAO bDao = BoardDAO.getInstance();
		BoardVO bVo = new BoardVO();
		bVo.setB_contents(b_contents);
		bVo.setB_name(b_name);
		bVo.setB_num(Integer.parseInt(b_num));		
		bVo.setB_subject(b_subject);
		bDao.updateBoard(bVo);
		
		response.sendRedirect("./BoardServlet?cmd=board_view&b_num="+b_num);
		
		
	}
}
