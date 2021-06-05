package tw.com.web.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
@WebListener
public class MyRequestListener implements ServletRequestListener{

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
			System.out.println("requestDestroyed!!!");
			
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("requestInitialized!!!");
		sre.getServletRequest().setAttribute("msg", "Hello MSg");
		
	}
	
}
