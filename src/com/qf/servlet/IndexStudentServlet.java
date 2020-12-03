package com.qf.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qf.tool.MainTool;

@WebServlet(
		urlPatterns= {"/student"},
		name="IndexStudent"
		)
public class IndexStudentServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
		rsp.setHeader("Access-Control-Allow-Origin", "*");
		rsp.setHeader("Content-Type","text/html; charset=utf-8");
		String rep_user_name = req.getParameter("rep");
		HttpSession session=req.getSession();     
		session.setMaxInactiveInterval(3600);
	    
	    if(rep_user_name!=null) {
	    	session.setAttribute("rep_user_name",rep_user_name); 
	    	
	    }else {
		    String str = MainTool.getFileStr(req.getServletContext().getRealPath("")+"\\index_student.html");
		    
		    str=str.replace("###",(CharSequence) session.getAttribute("rep_user_name"));
		    rsp.getWriter().print(str);	
	    } 

	        
	        
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
