package com.qf.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.tool.MainTool;

@WebServlet(
		urlPatterns= {"/teacher"},
		name="IndexTeacher"
		)
public class IndexTeacherServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Content-Type","text/html; charset=utf-8");

		String str = MainTool.getFileStr(req.getServletContext().getRealPath("")+"\\index_teacher.html");
	   
		resp.getWriter().print(str);
	        


			
		}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
