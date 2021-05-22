package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.web.bean.AccountAttr;

@WebServlet("/page2")
public class Page2Servlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("page2 doGet!!");
		PrintWriter out = resp.getWriter();
		String str = AccountAttr.getAttr(req);
		//Object obj = req.getAttribute("ac");
		out.print("Page2 doGet!!"+str);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("page2 doPost!!");
		PrintWriter out =  resp.getWriter();
		Object ac = req.getAttribute("ac");
		out.println("Page doPost!!"+ac);
		
		
	}
	
}
