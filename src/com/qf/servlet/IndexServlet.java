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
import com.qf.tool.*;



@WebServlet(
		urlPatterns= {"/index.html"},
		name="Index"
		)
public class IndexServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
		rsp.setHeader("Access-Control-Allow-Origin", "*");
		rsp.setHeader("Content-Type","text/html; charset=utf-8");

	        String str = MainTool.getFileStr(req.getServletContext().getRealPath("")+"\\index.html");
	        	        
	        rsp.getWriter().print(str);
	        

			
		}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
