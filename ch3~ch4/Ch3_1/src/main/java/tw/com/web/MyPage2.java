package tw.com.web;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//@WebServlet如果name跟web.xml一樣
//@WebServlet 的url會被web.xml 覆蓋
//如果name跟web.xml不一樣
/*@WebServlet 的url 會出錯
如果沒設定name則附加*/
@WebServlet("/testPage2")
//@WebServlet(name= "Page2", urlPatterns = {"/testPage2"})
public class MyPage2 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	PrintWriter out = resp.getWriter();
		out.println("Page2");
	}

	
	
}
