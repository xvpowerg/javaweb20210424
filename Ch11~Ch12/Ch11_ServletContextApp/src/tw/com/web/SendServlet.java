package tw.com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/send")
public class SendServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		//getParameter等等 Request 取資料使用utf-8方式編碼
		req.setCharacterEncoding("utf-8");
		String msg = req.getParameter("msg");
		getServletContext().setAttribute("myMsg", msg);		
		
		
	}
}
