package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.web.tools.MyVerification;

@WebServlet("/page2")
public class Page2Servlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out =   resp.getWriter();
		Map <String,String[]> map  = req.getParameterMap();
		
		map.forEach((k,v)->{
			String tmp= "";
			Optional<String[]> op= Optional.ofNullable(v);
			if (op.isPresent()) {
				tmp = Stream.of(op.get()).collect(Collectors.joining(","));
			}
			out.println(k+":"+tmp);			
		});
		
		boolean exist = MyVerification.nameInParam("status", req);
		out.print(exist);
	}
	
	

}
