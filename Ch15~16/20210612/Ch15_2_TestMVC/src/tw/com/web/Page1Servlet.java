package tw.com.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.bean.User;
import tw.com.db.UserDB;
@WebServlet("/page1")
public class Page1Servlet extends HttpServlet {
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			//M Model  Bean �ӷ~�޿� ��Ʈw�d�ߵ���.... �i��W�ϥ� ����web�������p
			//V View JSP HTML ���
			//C Controller Servlet ����y�{
//			boolean pass = UserDB.regisrter("Iris", "12345");
//			System.out.println(pass);
			
			User user = new User();
			boolean loginPass = UserDB.login("Iris", "12345", user);
			System.out.println(loginPass);
			
			// TODO Auto-generated method stub
//			String url = "jdbc:mysql://localhost:3306/db20210612?serverTimezone=CST&useSSL=false&allowPublicKeyRetrieval=true";
//			String user = "root";
//			String passwordr = "123456";
//			try(Connection conn =   DriverManager.getConnection(url,user,passwordr)){
//				
//			}catch(SQLException ex) {
//				
//				System.out.println(ex);
//			}
		}
}
