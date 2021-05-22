package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/page1")
public class Page1Servlet  extends HttpServlet  {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		int sessionCount = 0;
		int appCount = 0;
		HttpSession session =  req.getSession();
		ServletContext app = getServletContext();
		
		if (!session.isNew()) {
			sessionCount = (Integer)session.getAttribute("sessionCount");			
		}
		if (app.getAttribute("appCount") != null) {
			appCount = (Integer)app.getAttribute("appCount");
		}
		
		app.setAttribute("appCount", ++appCount);		
		session.setAttribute("sessionCount", ++sessionCount);
		
		out.println("sess online:"+sessionCount);
		out.println("appCount online:"+appCount);
		
	}
		
}
