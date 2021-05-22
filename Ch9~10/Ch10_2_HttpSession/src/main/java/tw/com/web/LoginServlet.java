package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	private String pass="12345",account = "ken";
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String inputPass = req.getParameter("pass");
		String inputAccount = req.getParameter("account");
		if (pass.equals(inputPass) && account.equals(inputAccount)) {
			HttpSession session = req.getSession();
			session.setAttribute("pass", "true");
			session.setAttribute("name", "Ken");
			//Âà­¶ ·|´«ºô§}
			resp.sendRedirect("user");
		}else {
			PrintWriter out = resp.getWriter();
			out.println("Faill");
			
		}
		
	}
 
}
