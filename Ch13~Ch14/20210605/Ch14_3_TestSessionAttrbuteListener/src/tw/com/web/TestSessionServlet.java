package tw.com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.joda.time.LocalDateTime;

@WebServlet("/testSession")
public class TestSessionServlet extends HttpServlet {
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			 HttpSession session =  req.getSession();
			 session.setAttribute("logintime", 
					 LocalDateTime.now().toString());
			 session.setAttribute("logintime","Empty");
			 session.removeAttribute("logintime");
		}
}
