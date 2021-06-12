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

@WebServlet("/logout")
public class LogoutPageServlet  extends HttpServlet{
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			//µn¥X
			HttpSession session = req.getSession();			
			session.invalidate();					
			resp.sendRedirect("login.jsp");		
		}
}
