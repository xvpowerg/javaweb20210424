package tw.com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/login")
public class LoginServlet extends HttpServlet{
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			String account = req.getParameter("account");
			String pass = req.getParameter("pass");
			
			HttpSession session = req.getSession();
			Object userPass =  session.getAttribute("userPass");
			
			if (userPass == null || (Boolean)userPass == false) {
				//登入成功的情況
				if (account.equals("ken") && pass.equals("12345")) {
					session.setAttribute("userPass", true);
					req.getRequestDispatcher("/user").forward(req, resp);
				}else {
					session.setAttribute("userPass", false);
					resp.getWriter().println("Login Fail");
				}				
				
			}else{				
				req.getRequestDispatcher("/user").forward(req, resp);
			}
			
			
			
		}
}
