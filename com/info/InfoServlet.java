package com.info;

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

@WebServlet("/InfoServlet")
public class InfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoServlet() {
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
		String url="";
		if(cmd.equals("operation")) {
			url = "./InfoCorp/info_operation.jsp";
		}else if (cmd.equals("value")) {			
			url = "./InfoCorp/info_value.jsp";
		}else if (cmd.equals("vision")) {
			url = "./InfoCorp/info_vision.jsp";
		}else if (cmd.equals("factory")) {
			url = "./ExplainBusiness/explain_factory.jsp";
		}else if (cmd.equals("research")) {
			url = "./ExplainBusiness/explain_research.jsp";
		}else if (cmd.equals("business")) {
			url = "./ExplainBusiness/explainBusiness.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
}
	
