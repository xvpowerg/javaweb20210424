package tw.com.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import tw.com.bean.ImageObj;

public class MyContextListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("contextDestroyed!!");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("contextInitialized!!");		
		String imagePath = sce.getServletContext().getInitParameter("imagePath");
		ImageObj.setImagePath(imagePath);
	}

	
	
}
