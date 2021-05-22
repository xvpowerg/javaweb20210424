package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.LocalTime;

@WebServlet("/testCookies")
public class TestCookiesServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		PrintWriter out = 	resp.getWriter();
		out.println("Test Cookies!!");
		//����s�������� �w�]���p�UCookie�]�|����
		Cookie cookie1 = new Cookie("cookiName",LocalTime.now().toString());		
		Cookie cookie2 = new Cookie("cookiName2",LocalTime.now().toString());
		//���O��
		cookie1.setMaxAge(60);
		//�w�]���p
		//cookie1.setMaxAge(-1);
		//�R��cookie
		//cookie1.setMaxAge(0);		
		resp.addCookie(cookie1);
		resp.addCookie(cookie2);
		
		
	}
	
}
