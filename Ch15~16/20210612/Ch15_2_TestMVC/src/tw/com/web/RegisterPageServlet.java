package tw.com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tw.com.db.UserDB;

@WebServlet("/register")
public class RegisterPageServlet  extends HttpServlet{
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			String account = req.getParameter("account");
			String password = req.getParameter("password");	
			//��Ʈw�����J
			boolean registerComplete = 
					UserDB.regisrter(account, password);
			if (registerComplete) {
				//�ɤJ��n�J�e��
				resp.sendRedirect("login.jsp");
			}else {
				//�ɤJ����U�e�� ��ܵ��U����
				resp.sendRedirect("register.jsp");
			}
			
			
			
		}
}
