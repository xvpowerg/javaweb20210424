package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//第一隻Servlet 運行時順序
//init(ServletConfig)
//init(ServletConfig) 呼叫init()
//產生了Servlet物件
//會開新執行序 運行service(ServletRequest req, ServletResponse res)
//service(ServletRequest req, ServletResponse res)呼叫service(HttpServletRequest req, HttpServletResponse resp)
//由service(HttpServletRequest req, HttpServletResponse resp) 判定該呼叫doGet或是doPost...
//每次容器關閉時 會呼叫 destroy 可釋放資源

//如果已有Servlet物件
//會開新執行序 運行service(ServletRequest req, ServletResponse res)
//service(ServletRequest req, ServletResponse res)呼叫service(HttpServletRequest req, HttpServletResponse resp)
//由service(HttpServletRequest req, HttpServletResponse resp) 判定該呼叫doGet或是doPost...


@WebServlet("/page1")
public class Page1Servlet extends HttpServlet {
	ServletConfig myConfig;
		
	@Override
	public void init() throws ServletException {
		System.out.println("init!!!");
	}
	
	//不建議複寫init(ServletConfig config)
	//因為init(ServletConfig config)方法有作一些初始化的動作
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		myConfig = config;
		super.init(config);
	}

	//如果有需求再進入doGet dogPost前作一些 前置 可以複寫
	//service(HttpServletRequest req, HttpServletResponse resp)
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("Http service ");		
		//判斷該呼叫doGet還是doPost
		super.service(req, resp);
		System.out.println(this.getServletConfig() == myConfig); 
		
	}

	//如果再HttpServlet的子類別內 不需要Override  service(ServletRequest req, ServletResponse res)
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, res);
	}
	

	@Override
	protected void doGet(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println("Page1Servlet!!");
	}
	
	//可釋放資源等等...
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("page1 destroy!");
	}
	
	
	
}
