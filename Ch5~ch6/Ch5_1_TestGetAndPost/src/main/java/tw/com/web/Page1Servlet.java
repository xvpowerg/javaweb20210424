package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/page1")
public class Page1Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
	PrintWriter out = 	resp.getWriter();
	out.print("Get!");
	}

	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
	PrintWriter out = 	resp.getWriter();
	String account = req.getParameter("account");
	String pass =  req.getParameter("pass");
	out.println("Post!");
	out.println("account:"+account);
	out.println("pass:"+pass);
	}
	
}
