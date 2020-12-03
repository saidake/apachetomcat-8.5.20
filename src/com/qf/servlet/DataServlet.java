package com.qf.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.qf.bean.*;

import com.qf.dao.DbHelper;

@WebServlet(
		urlPatterns= {"/koko"},
		name="Data"
		)
public class DataServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Content-Type","text/html; charset=utf-8");
		
			String method = req.getParameter("m");  
			switch (method) {
			case "getuser":  
				List<User> ulist = DbHelper.getAllUser();
				String ujson = new Gson().toJson(ulist);  
		        resp.getWriter().print(ujson);
				break;
			case "getadmin":  
				List<Admin> admlist = DbHelper.getAllAdmin();
				String admjson = new Gson().toJson(admlist);  
		        resp.getWriter().print(admjson);
				break;
			case "getscore":  
				List<Score> sclist = DbHelper.getAllScore();
				String scjson = new Gson().toJson(sclist);  
		        resp.getWriter().print(scjson);
				break;
			case "getexampaper":  
				List<ExamPaper> elist = DbHelper.getAllExamPaper();
				String ejson = new Gson().toJson(elist);  
		        resp.getWriter().print(ejson); 
				break;
			case "getchoice_question":  
				List<ChoiceQuestion> cholist = DbHelper.getAllChoiceQuestion();
				String chojson = new Gson().toJson(cholist);  
		        resp.getWriter().print(chojson);
				break;
			case "getcompletion":  
				List<Completion> comlist = DbHelper.getAllCompletion();
				String comjson = new Gson().toJson(comlist);  
		        resp.getWriter().print(comjson);
				break;
			case "getcalculation":  
				List<Calculation> callist = DbHelper.getAllCalculation();
				String caljson = new Gson().toJson(callist);  
		        resp.getWriter().print(caljson);
				break;
			case "addscore":
				String user_name = req.getParameter("user_name");
				String exam_name = req.getParameter("exam_name");
				String score = req.getParameter("score");
				String exam_situation = req.getParameter("exam_situation");

				Score score1 = new Score();
				score1.setUser_name(user_name);
				score1.setExam_name(exam_name);
				score1.setScore(score);
				score1.setExam_situation(exam_situation);
				int re= DbHelper.addScore(score1);
				if(re==1) {
					resp.getWriter().println("提交成功");
				}else {
					resp.getWriter().println("提交失败"+user_name+exam_name+score+exam_situation);
				}
				
				break;	
				
				
				
	
					
				

//			case "deleteRecord":
//				int id = Integer.valueOf(req.getParameter("flag"));
//				if (DbHelper.deleteRecord(id) > 0) {
//					System.out.println("锟絟锟斤拷锟缴癸拷");
//					resp.getWriter().print(new Gson().toJson("200"));
//				} else {
//					System.out.println("锟絟锟斤拷失锟斤拷");
//					resp.getWriter().print(new Gson().toJson("400"));
//				}
//				break;
				
				
				
			default:
				break;
			}
		
		
		
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
