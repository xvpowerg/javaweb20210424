package tw.com.web;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tw.com.bean.Student;
@WebServlet("/page2")
public class TestPage2Servlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<String> list = new ArrayList<>();
		 HttpSession session =  req.getSession();
		 list.add("Ken");
		 list.add("Vivin");
		 list.add("Lindy");
		 list.add("Join");
		 session.setAttribute("myList", list);
		 Student st = new Student(10,"Ken");
		getServletContext().setAttribute("student", st);
		resp.sendRedirect("page2.jsp");
		 
		
	}
}
