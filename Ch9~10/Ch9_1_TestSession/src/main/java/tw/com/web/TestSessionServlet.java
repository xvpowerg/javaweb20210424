package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.web.app.MySession;
import tw.com.web.app.WebApplication;

@WebServlet("/testSession")
public class TestSessionServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.print("testSession!!");
		MySession session =  WebApplication.
				getMySession(req, resp);
		session.addAttrbute("msg1", "Test1");
		session.addAttrbute("msg2", "Test2");
		System.out.println(session);
	}

}
