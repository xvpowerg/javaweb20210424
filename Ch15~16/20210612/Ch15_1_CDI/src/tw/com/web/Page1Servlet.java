package tw.com.web;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.bean.Student;
@WebServlet("/page1")
public class Page1Servlet extends HttpServlet{
	 @Inject
	 @Named("Ken")
	 Student st;
	 
	 @Inject
	 List<Student> stList;
	 
	@Override
		protected void doGet(HttpServletRequest req,
				HttpServletResponse resp) throws ServletException, IOException {
		 System.out.println(st.getName()+":"+st.getId());
		 System.out.println(stList);
		}
}
