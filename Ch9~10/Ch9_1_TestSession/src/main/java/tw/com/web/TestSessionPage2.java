package tw.com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.web.app.MySession;
import tw.com.web.app.WebApplication;

@WebServlet("/testPage2")
public class TestSessionPage2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		MySession mySession = 
				WebApplication.getMySession(req, resp);
		String m1 = mySession.getAttrbute("msg1")+"";
		String m2 = mySession.getAttrbute("msg2")+"";
		System.out.println(m1+":"+m2);
	}

}
