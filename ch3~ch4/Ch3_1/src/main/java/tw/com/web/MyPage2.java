package tw.com.web;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//@WebServlet�p�Gname��web.xml�@��
//@WebServlet ��url�|�Qweb.xml �л\
//�p�Gname��web.xml���@��
/*@WebServlet ��url �|�X��
�p�G�S�]�wname�h���[*/
@WebServlet("/testPage2")
//@WebServlet(name= "Page2", urlPatterns = {"/testPage2"})
public class MyPage2 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	PrintWriter out = resp.getWriter();
		out.println("Page2");
	}

	
	
}
