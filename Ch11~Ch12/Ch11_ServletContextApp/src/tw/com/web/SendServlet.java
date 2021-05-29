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
		//getParameter���� Request ����ƨϥ�utf-8�覡�s�X
		req.setCharacterEncoding("utf-8");
		String msg = req.getParameter("msg");
		getServletContext().setAttribute("myMsg", msg);		
		
		
	}
}
