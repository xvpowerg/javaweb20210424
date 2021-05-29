package tw.com.web;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/page2"},loadOnStartup = 3)
public class Page2Servlet extends HttpServlet {
		
	@Override
	public void init() throws ServletException {
		
		System.out.println("Page2 Iniit...");
		try {
			TimeUnit.SECONDS.sleep(2);	
		}catch(InterruptedException ex) {
			
		}
		
		
		System.out.println("Page2 Iniit End...");
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
			
		resp.getWriter().println("Page2");
	}
	
}
