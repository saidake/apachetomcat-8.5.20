package com.qf.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qf.bean.*;

public class DbHelper {
	private static final String name = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/examsystem?characterEncoding=utf-8";
	private static final String user = "root";
	private static final String password = "root";
	private Connection connection;
	private PreparedStatement preparedStatement;

	public DbHelper(String sql) {
		try {
			Class.forName(name);
			connection = DriverManager.getConnection(url, user, password);
			preparedStatement = connection.prepareStatement(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void close(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	// ��ȡ���й���Ա-------------------------------------------------------
			public static List<Admin> getAllAdmin() {
				// ����һ���յļ��ό���
				List<Admin> admlist = new ArrayList<>();
				DbHelper admbHelper = new DbHelper("select * from admin"); 
				ResultSet admresultSet = null;
				try {
					admresultSet = admbHelper.preparedStatement.executeQuery();
					while (admresultSet.next()) {
						Admin admin = new Admin();
						admin.setAdmin_id(admresultSet.getInt("admin_id"));
						admin.setPermission(admresultSet.getInt("permission"));
						admin.setAdmin_name(admresultSet.getString("admin_name"));
						admin.setAdmin_password(admresultSet.getString("admin_password"));
						admin.setStatus(admresultSet.getString("status"));
						admlist.add(admin);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					admbHelper.close(admresultSet);
				}
				return admlist;
			}
			
// ��ȡ�����û�-------------------------------------------------------
		public static List<User> getAllUser() {
			// ����һ���յļ��ό���
			List<User> list = new ArrayList<>();
			DbHelper dbHelper = new DbHelper("select * from user;");
			ResultSet resultSet = null;
			try {
				// ���в�ԃ�Z��
				resultSet = dbHelper.preparedStatement.executeQuery();
				
				while (resultSet.next()) {
					User user = new User();
					user.setUser_id(resultSet.getInt("user_id"));
					user.setPermission(resultSet.getInt("permission"));
					user.setUser_name(resultSet.getString("user_name"));
					user.setUser_password(resultSet.getString("user_password"));
					user.setStatus(resultSet.getString("status"));
					list.add(user);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				dbHelper.close(resultSet);
			}
			return list;
		}
// ��ȡ���гɼ�-------------------------------------------------------
				public static List<Score> getAllScore() {
					// ����һ���յļ��ό���
					List<Score> list = new ArrayList<>();
					DbHelper dbHelper = new DbHelper("select * from score");
					ResultSet resultSet = null;
					try {
						resultSet = dbHelper.preparedStatement.executeQuery();
						
						while (resultSet.next()) {
							Score score = new Score();
							score.setScore_id(resultSet.getInt("score_id"));
							score.setUser_name(resultSet.getString("user_name"));
							score.setExam_name(resultSet.getString("exam_name"));
							score.setScore(resultSet.getString("score"));
							score.setExam_situation(resultSet.getString("exam_situation"));
							// ��ӵ������б������Д���
							list.add(score);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					} finally {
						dbHelper.close(resultSet);
					}
					return list;
				}
				
		
// ��ȡ���п�Ŀ-------------------------------------------------------
	public static List<ExamPaper> getAllExamPaper() {
		// ����һ���յļ��ό���
		List<ExamPaper> list = new ArrayList<>();
		DbHelper dbHelper = new DbHelper("select * from exampaper");
		ResultSet resultSet = null;
		try {
			// ���в�ԃ�Z��
			resultSet = dbHelper.preparedStatement.executeQuery();
			// ͨ�^while��v�����������еĔ���
			
			while (resultSet.next()) {
				ExamPaper exampaper = new ExamPaper();
				exampaper.setExam_id(resultSet.getInt("exam_id"));
				exampaper.setExam_name(resultSet.getString("exam_name"));
				exampaper.setCat_all(resultSet.getString("cat_all"));
				exampaper.setStatus(resultSet.getString("status"));
				// ��ӵ������б������Д���
				list.add(exampaper);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbHelper.close(resultSet);
		}
		return list;
	}

	// ��ȡ����ѡ����-------------------------------------------------------
		public static List<ChoiceQuestion> getAllChoiceQuestion() {
			// ����һ���յļ��ό���
			List<ChoiceQuestion> list = new ArrayList<>();
			String sql = "select * from choice_question";
			DbHelper dbHelper = new DbHelper(sql);
			ResultSet resultSet = null;
			try {
				// ���в�ԃ�Z��
				resultSet = dbHelper.preparedStatement.executeQuery();
				// ͨ�^while��v�����������еĔ���
				
				while (resultSet.next()) {
					ChoiceQuestion choicequestion = new ChoiceQuestion();
					choicequestion.setChoque_id(resultSet.getInt("choque_id"));
					choicequestion.setExam_name(resultSet.getString("exam_name"));
					choicequestion.setCat(resultSet.getString("cat"));
					choicequestion.setQuestion(resultSet.getString("question"));
					choicequestion.setAnswer_a(resultSet.getString("answer_a"));
					choicequestion.setAnswer_b(resultSet.getString("answer_b"));
					choicequestion.setAnswer_c(resultSet.getString("answer_c"));
					choicequestion.setAnswer_d(resultSet.getString("answer_d"));
					choicequestion.setAnswer(resultSet.getString("answer"));
					// ��ӵ������б������Д���
					list.add(choicequestion);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				dbHelper.close(resultSet);
			}
			return list;
		}
// ��ȡ���������-------------------------------------------------------
		public static List<Completion> getAllCompletion() {
			// ����һ���յļ��ό���
			List<Completion> comlist = new ArrayList<>();
			String sql = "select * from completion";
			DbHelper dbHelper = new DbHelper(sql);
			ResultSet resultSet = null;
			try {
				// ���в�ԃ�Z��
				resultSet = dbHelper.preparedStatement.executeQuery();
				// ͨ�^while��v�����������еĔ���
				
				while (resultSet.next()) {
					Completion completion = new Completion();
					completion.setChoque_id(resultSet.getInt("comque_id"));
					completion.setExam_name(resultSet.getString("exam_name"));
					completion.setCat(resultSet.getString("cat"));
					completion.setQuestion(resultSet.getString("question"));
					completion.setAnswer(resultSet.getString("answer"));
					// ��ӵ������б������Д���
					comlist.add(completion);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				dbHelper.close(resultSet);
			}
			return comlist;
		}
		
// ��ȡ���м�����-------------------------------------------------------
		public static List<Calculation> getAllCalculation() {
			// ����һ���յļ��ό���
			List<Calculation> callist = new ArrayList<>();
			DbHelper dbHelper = new DbHelper("select * from calculation");
			ResultSet resultSet = null;
			try {
				resultSet = dbHelper.preparedStatement.executeQuery();
				
				while (resultSet.next()) {
					Calculation calculation = new Calculation();
					calculation.setCalque_id(resultSet.getInt("calque_id"));
					calculation.setExam_name(resultSet.getString("exam_name"));
					calculation.setCat(resultSet.getString("cat"));
					calculation.setQuestion(resultSet.getString("question"));
					calculation.setAnswer(resultSet.getString("answer"));
					callist.add(calculation);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				dbHelper.close(resultSet);
			}
			return callist;
		}
		
		
		
		
//-------��������FSFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF
	public static int addScore(Score score) {
		String sql = "update score set score=?,exam_situation=? where user_name=? and exam_name=?";//�˳ɼ����ݱ����Ѿ�����
		Object[] params = {score.getScore(), score.getExam_situation(), score.getUser_name(),  score.getExam_name()};
		if (DbHelper.executeUpdate(sql, params) > 0) {
			return 1;
		} else {
			return 0;
		}
	}
//
////----��ѯ����һ������
//	public static RecordBean selectLastRecord(){
//		String sql="select * from product order by pid desc limit 1";
//		DbHelper dbHelper=new DbHelper(sql);
//		RecordBean recordBean=new RecordBean();
//		ResultSet resultSet=null;
//		try {
//			resultSet=dbHelper.preparedStatement.executeQuery();
//			while (resultSet.next()) {
//				recordBean.setPid(resultSet.getInt("pid"));
//				recordBean.setName(resultSet.getString("name"));
//				recordBean.setRegion(resultSet.getString("region"));
//				recordBean.setTime(resultSet.getString("time"));
//				recordBean.setImgpath(resultSet.getString("imgpath"));
//				recordBean.setCategory(resultSet.getString("category"));
//			}
//			return recordBean;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			dbHelper.close(resultSet);
//		}
//		return null;
//	}
//	
//
//
//----------------��ɾ������
	public static int executeUpdate(String sql, Object... params) {
		DbHelper dbHelper = new DbHelper(sql);
		try {
			// ͨ��forѭ����ռλ������ֵ
			for (int i = 0; i < params.length; i++) {
				dbHelper.preparedStatement.setObject(i + 1, params[i]);
			}
			// ִ��sql���
			int result = dbHelper.preparedStatement.executeUpdate();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbHelper.close(null);
		}
		return -1;
	}
//
//	/**
//	 * ����IDɾ�����ݿ��ж�Ӧ����������
//	 * 
//	 * @param id
//	 * @return
//	 */
//	public static int deleteRecord(int id) {
//		String sql = "delete from product where pid =?";
//		Object[] params = { id };
//		return DbHelper.executeUpdate(sql, params);
//	}
	
	
	
	
	
}
