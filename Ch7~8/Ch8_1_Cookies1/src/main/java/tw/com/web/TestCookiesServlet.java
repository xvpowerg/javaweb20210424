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
		//整個瀏覽器關閉 預設情況下Cookie也會消失
		Cookie cookie1 = new Cookie("cookiName",LocalTime.now().toString());		
		Cookie cookie2 = new Cookie("cookiName2",LocalTime.now().toString());
		//單位是秒
		cookie1.setMaxAge(60);
		//預設情況
		//cookie1.setMaxAge(-1);
		//刪除cookie
		//cookie1.setMaxAge(0);		
		resp.addCookie(cookie1);
		resp.addCookie(cookie2);
		
		
	}
	
}
