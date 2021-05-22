package tw.com.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/page1")
public class TestSessionPage1Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<String> nameList = new ArrayList();
		nameList.add("Ken");
		nameList.add("Vivin");
		HttpSession session = req.getSession();
		session.setAttribute("msg1","Test1" );		
		session.setAttribute("list", nameList);
	　　//session.invalidate();//使得HttpSession無效 作用於登出
	}

}
