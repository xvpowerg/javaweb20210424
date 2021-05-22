package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.web.bean.AccountAttr;

@WebServlet("/page1")
public class Page1Servlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Page1 doGet!! Step1");	
		String account = req.getParameter("account");
		account = "Title:"+account;
		AccountAttr.setAttr(req, account);
//		req.setAttribute("ac", account);
		
		PrintWriter out = resp.getWriter();
		out.print("Page1 doGet!!");
		//在呼叫forward 之前不可呼叫out.flush()
		//out.flush();	
		//page2 使用哪種方法接收 forward 看page1在哪個方法 forward
		req.getRequestDispatcher("/page2").forward(req, resp);
		System.out.println("Page1 doGet!! Step2");	
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Page1 doPost!!");
		String account = req.getParameter("account");
		req.setAttribute("ac", account);
		req.getRequestDispatcher("/page2").forward(req, resp);
		
	}
	
}
