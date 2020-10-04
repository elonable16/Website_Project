package com.auth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import org.apache.commons.fileupload.*;
import java.util.*;
import java.io.File;
import com.commons.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String cmd = request.getParameter("cmd");
		if(cmd.equals("loginform")) {
			String url = "./Login/Login.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}else if (cmd.equals("loginOk")) {	
			loginOk(request,response);
		}else if (cmd.equals("logout")) {
			logOut(request,response);
		}else if (cmd.equals("signup")) {
			signUp(request,response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
//		
//		String cmd = request.getParameter("cmd");
//		if(cmd.equals("upload")) {
//			uploadOk(request,response);
//		}else {
//			doGet(request, response);
//		}
	}
	
//	protected void uploadOk(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String path = "D:\\elon\\WebProg\\JSPBook\\WebContent\\product\\images";
//		try {
//			DiskFileUpload upload = new DiskFileUpload();
//			List items = upload.parseRequest(request);
//			Iterator params = items.iterator();
//			params.hasNext(); // 일반폼
//			FileItem item = null;
//			item = (FileItem)params.next();
//			String name = item.getFieldName();
//			String value = item.getString("utf-8");
//			System.out.println(name + ":" + value);
//			params.hasNext(); // 파일폼
//			item = null;
//			item = (FileItem)params.next();
//			String fileFieldName = item.getFieldName();
//			String fileName = item.getName(); // 파일 이름
//			System.out.println(fileName);
//			File file = new File(path + "/" + fileName);
//			item.write(file);
//		}catch(Exception e) {
//			System.out.println(e.toString());
//		}
//	}
	
	protected void loginOk(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		boolean chk = false;
		loginDAO lDao = loginDAO.getInstance();
		chk = lDao.checkLogin(id, passwd);
		String url="";
		String error="";
		if(chk) {
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			url="./HomeServlet?cmd=main";
		}else {
			error="1";
			request.setAttribute("error", error);
			url="./LoginServlet?cmd=loginform";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}
	protected void logOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url="";
		HttpSession session = request.getSession();
		session.invalidate();
		url="./HomeServlet?cmd=main";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	protected void signUp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String email = request.getParameter("email");
		String u_name =request.getParameter("u_name");
		String phone =request.getParameter("phone");
		String signin = MyDate.getDate();
		String ip = request.getRemoteAddr();
		boolean chk = false;
		loginDAO lDao = loginDAO.getInstance();
		chk = lDao.checkId(id);
		String url="";
		String error="";
		if(chk) { // 중복아이디 
			error="2";
			request.setAttribute("error", error);
			url="./LoginServlet?cmd=loginform";
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}else {
			lDao.insertCustomer(id, email, passwd, phone, signin, u_name, ip);
			url="./LoginServlet?cmd=loginform&notice=1";
			response.sendRedirect(url);;
		}
		
		
	}
}
