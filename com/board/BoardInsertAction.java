package com.board;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletException;
import com.board.BoardDAO;
import com.board.BoardVO;
import com.commons.Action;

public class BoardInsertAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String b_subject = request.getParameter("b_subject");
		String b_name= request.getParameter("b_name");
		String b_passwd= request.getParameter("b_passwd");
		String b_contents= request.getParameter("b_contents");
		BoardVO bVo = new BoardVO();
		bVo.setB_subject(b_subject);
		bVo.setB_name(b_name);
		bVo.setB_passwd(b_passwd);
		bVo.setB_contents(b_contents);
		BoardDAO bDAO = BoardDAO.getInstance();
		bDAO.insertBoard(bVo);
		response.sendRedirect("./BoardServlet?cmd=board_list");
	}
}
