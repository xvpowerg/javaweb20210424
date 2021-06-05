package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/page1")
public class TestPage1Servlet extends HttpServlet {
	private int value =209;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 //PrintWriter out =  resp.getWriter();
		 //out.println("TestJsp!!");
		//text/html; charset=UTF-8
		resp.setContentType("text/html; charset=UTF-8");
		 String countStr = req.getParameter("count");
		 countStr = countStr == null?"0":countStr;
		 
		 int count = Integer.parseInt(countStr);
		 //out.println("TestJsp!!:"+count);
		 req.setAttribute("count", count);
		 req.getRequestDispatcher("/page1.jsp").forward(req, resp);
	
		 
	}
}
