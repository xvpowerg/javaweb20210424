package tw.com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tw.com.bean.User;
import tw.com.db.UserDB;

@WebServlet("/login")
public class LoingPageServlet  extends HttpServlet{
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			//�O�_�n�J�L
			HttpSession session = req.getSession(false);			
			//�S���n�J�L
			if (session == null || session.getAttribute("loginPass") ==null) {				
				//�ˬd�b���K�X����.....
				String account = req.getParameter("account");
				String password = req.getParameter("password");	
				User user = new User();
				boolean isPass = UserDB.login(account, password, user);						
				if (isPass) {
					session = req.getSession();
					session.setAttribute("loginPass", true);
					//��Session�L�� �i���n�X
					//session.invalidate();
					session.setAttribute("user", user);
					//�ഫ��user_page
					resp.sendRedirect("user_page.jsp");
				}else {
					session.setAttribute("msg", "�n�J����");
					resp.sendRedirect("login.jsp");
				}				
			}else {
				//�ഫ��user_page
				resp.sendRedirect("user_page.jsp");		
			}
			

			
			
			
			//�S���n�J�L
//			if (session == null || session.getAttribute("loginPass") ==null) {				
//				//�ˬd�b���K�X����.....
//				String account = req.getParameter("account");
//				String password = req.getParameter("password");	
//				User user = new User();
//				boolean isPass = UserDB.login(account, password, user);		
//					if (!isPass) {
//						session.setAttribute("msg", "�n�J����");
//						resp.sendRedirect("login.jsp");
//						return;
//					}				
//					session = req.getSession();
//					session.setAttribute("loginPass", true);
//					//��Session�L�� �i���n�X
//					//session.invalidate();
//					session.setAttribute("user", user);	
//			}
//			//�ഫ��user_page
//			resp.sendRedirect("user_page.jsp");		
//			
			
				
		}
}
