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
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	    PrintWriter out =    resp.getWriter();
	    out.println("Page1");
	    
	    String p = req.getParameter("p");
	    
		if (p!= null && p.equals("2")) {
			//將Page1工作交付給Page2
			req.getRequestDispatcher("/page2").forward(req, resp);
		}
	}

	
	
}
