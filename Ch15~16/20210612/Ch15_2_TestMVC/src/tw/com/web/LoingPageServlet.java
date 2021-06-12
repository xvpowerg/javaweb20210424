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
			//是否登入過
			HttpSession session = req.getSession(false);			
			//沒有登入過
			if (session == null || session.getAttribute("loginPass") ==null) {				
				//檢查帳號密碼等等.....
				String account = req.getParameter("account");
				String password = req.getParameter("password");	
				User user = new User();
				boolean isPass = UserDB.login(account, password, user);						
				if (isPass) {
					session = req.getSession();
					session.setAttribute("loginPass", true);
					//使Session無效 可做登出
					//session.invalidate();
					session.setAttribute("user", user);
					//轉換到user_page
					resp.sendRedirect("user_page.jsp");
				}else {
					session.setAttribute("msg", "登入失敗");
					resp.sendRedirect("login.jsp");
				}				
			}else {
				//轉換到user_page
				resp.sendRedirect("user_page.jsp");		
			}
			

			
			
			
			//沒有登入過
//			if (session == null || session.getAttribute("loginPass") ==null) {				
//				//檢查帳號密碼等等.....
//				String account = req.getParameter("account");
//				String password = req.getParameter("password");	
//				User user = new User();
//				boolean isPass = UserDB.login(account, password, user);		
//					if (!isPass) {
//						session.setAttribute("msg", "登入失敗");
//						resp.sendRedirect("login.jsp");
//						return;
//					}				
//					session = req.getSession();
//					session.setAttribute("loginPass", true);
//					//使Session無效 可做登出
//					//session.invalidate();
//					session.setAttribute("user", user);	
//			}
//			//轉換到user_page
//			resp.sendRedirect("user_page.jsp");		
//			
			
				
		}
}
