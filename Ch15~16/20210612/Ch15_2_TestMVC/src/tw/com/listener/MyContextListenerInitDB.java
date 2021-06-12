package tw.com.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import tw.com.db.DbTools;
@WebListener
public class MyContextListenerInitDB implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context= sce.getServletContext();
		String url = context.getInitParameter("url");
		String account = context.getInitParameter("account");
		String password = context.getInitParameter("password");
		String dbType =  context.getInitParameter("dbtype");
		DbTools.setURL(url);
		DbTools.setUser(account);
		DbTools.setPassword(password);	
		DbTools.setDbType(dbType);
	}
}
