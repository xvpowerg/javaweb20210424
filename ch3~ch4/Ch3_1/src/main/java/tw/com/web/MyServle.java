package tw.com.web;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/page1")
public class MyServle extends HttpServlet {
	
//1 ÃþÄ~©ÓHttpServlet
//µùÄÀ
	// request ¬Oinput
	// Response ¬Ooutput
	@Override
	protected void doGet(HttpServletRequest req,
			HttpServletResponse respon)throws 
						ServletException,IOException {
		 PrintWriter out =   respon.getWriter();
	
		 out.println("<HTML>");
		   out.println("<BODY>");
		     out.print("HELLO Ken Vivin Test!!");
			 out.println("A");
			 out.println("B");
			 out.println("C");
			 out.print("D<br/>");
			 out.print("E<br/>");
		   out.println("</BODY>");		 
	   out.println("</HTML>");	 
		
	}
}
