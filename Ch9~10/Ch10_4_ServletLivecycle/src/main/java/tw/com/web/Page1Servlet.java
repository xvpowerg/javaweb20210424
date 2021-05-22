package tw.com.web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/page1")
public class Page1Servlet extends HttpServlet{

	//類似建構式
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
			System.out.println("init page1 Servlet!");
	}

//	@Override
//	public void init(ServletConfig config) throws ServletException {
//		// TODO Auto-generated method stub
//		super.init(config);
//	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//只有第一次進入Servlet會 建立新物件 
		//所有客戶端 都使用相同的Servlet物件
		//使用不同的Thread
		//必須考量執行續安全
		System.out.println(this.hashCode());
		System.out.println(Thread.currentThread().getName());
		
	}
	
}
