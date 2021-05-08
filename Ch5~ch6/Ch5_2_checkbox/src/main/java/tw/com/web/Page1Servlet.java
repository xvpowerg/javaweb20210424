package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/page1")
public class Page1Servlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//String hobby = req.getParameter("hobby");
		String[] hobbys = req.getParameterValues("hobby");
		//�b���oPrintWriter ���e�]�wContentType  �i��X����
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out =   resp.getWriter();
		HashMap<String,String> map = new HashMap<>();
		map.put("0","����g!");
		map.put("1","�\Ū");
		map.put("2","�B��");
		map.put("3","����");
		
		// �ഫ��
/*		if (hobbys!= null) {
			for (String h  : hobbys) {			
				out.println("hobby:"+h);	
			}	
		}*/
		 /*�\Ū
        �B��
       ����*/
		
		hobbys = 
				Optional.ofNullable(hobbys).orElse(new String[] {"0"});
		//Stream.of(hobbys).map(v->map.get(v)).forEach(v->out.println(v));
	String liStr = 	Stream.of(hobbys).map(v->"<li>"+map.get(v)+"</li>").collect(Collectors.
				joining("\n", "<ol>", "</ol>"));
	
		
	out.print(liStr);
		
	}

}
