package tw.com.web;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//loadOnStartup 大於0 就會在容器運行初始化 預設-1
@WebServlet(urlPatterns = {"/page1"},loadOnStartup = 1)
public class Page1Servlet extends HttpServlet {
		
	@Override
	public void init() throws ServletException {
		
		System.out.println("Page1 Iniit...");
		try {
			TimeUnit.SECONDS.sleep(2);	
		}catch(InterruptedException ex) {
			
		}
		
		
		System.out.println("Page1 Iniit End...");
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
			
		resp.getWriter().println("Page1");
	}
	
}
