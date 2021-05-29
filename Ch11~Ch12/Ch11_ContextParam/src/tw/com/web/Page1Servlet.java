package tw.com.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/page1"},name = "page1Servlet")
public class Page1Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//this.getServletContext().getInitParameter(name)//共同擁有的
		//this.getInitParameter(name)//專屬於某Servlet
		ServletContext app= this.getServletContext();
		String dbAccount = app.getInitParameter("dbaccount");
		String dbPass = app.getInitParameter("dbpass");
		resp.getWriter().println("page1:"+dbAccount+":"+dbPass);
		//this.getServletConfig().getInitParameter("")
		String id = getInitParameter("id");
		String count = getInitParameter("count");
		resp.getWriter().println("page1:"+id+":"+count);
	}
	
}
