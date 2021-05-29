package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reveive")
public class ReceiveServlet extends HttpServlet {
	private String html = "<!DOCTYPE html>\r\n" + 
			"<html>\r\n" + 
			"<head>\r\n" + 
			"<meta charset=\"utf-8\">\r\n" + 
			"<title>Insert title here</title>\r\n" + 
			"	<script>			\r\n" + 
			"	var inter = setInterval(() => {\r\n" + 
			"	location.reload(true);\r\n" + 
			"	}, 1000);		\r\n" + 
			"	</script>\r\n" +
			"<H1>%s</H1>"+
			"</head>\r\n" + 
			"<body>\r\n" + 
			"</body>\r\n" + 
			"</html>";
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String msg = (String)getServletContext().getAttribute("myMsg");
			resp.setContentType("text/html;charset=UTF-8");
			PrintWriter out =   resp.getWriter();
			out.println(String.format(html, msg));
			
			
			
		}
}
