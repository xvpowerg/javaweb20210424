package tw.com.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/page2")
public class Page2Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//this.getServletContext().getInitParameter(name)//共同擁有的
		//this.getInitParameter(name)//專屬於某Servlet
		ServletContext app= this.getServletContext();
		String dbAccount = app.getInitParameter("dbaccount");
		String dbPass = app.getInitParameter("dbpass");
		resp.getWriter().println("page2:"+dbAccount+":"+dbPass);
		
	}
	
}
