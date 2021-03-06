package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/page1")
public class Page1Servlet extends HttpServlet {
	
	final String htmlTmp = "<!DOCTYPE html>\r\n"
			+ "<html>\r\n"
			+ "<head>\r\n"
			+ "<meta charset=\"UTF-8\">\r\n"
			+ "<title>Insert title here</title>\r\n"
			+ "</head>\r\n"
			+ "<body>\r\n"
			+ "%s"
			+ "</body>\r\n"
			+ "</html>";
	final String imageTmp = "<img alt='史萊姆%d' src='/Ch4_1_TestGet1/images/image%d.jpg'>";
	//優點
	//get 速度快
	//可以加到我的最愛
	//簡單
	//取得資訊 顯示資料 查詢資料 通常不寫入
	//缺點
	//安全性低
	@Override
	protected void doGet(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out =   resp.getWriter();
		//out.println("Page1");
		//所有Parameter 都是String
		String gl = req.getParameter("gl");
		String page = req.getParameter("page");
		String countStr = req.getParameter("count");
		
		if (countStr == null) countStr = "0"; 
		int count = 0;
		try{
			count = Integer.parseInt(countStr);	
		}catch(NumberFormatException ex) {
			System.out.println("錯誤的數字");
		}
		
		StringBuilder imags = new StringBuilder();
		 
		for ( int i = 1; i <= count;i++ ) {
			String image1 = String.format(imageTmp, i%3+1,i%3+1);
			imags.append(image1);
		}
	
		
		
		
		String html = String.format(htmlTmp, imags.toString());
		out.println(html);
//		int  pageInt = Integer.parseInt(page);
//		for (int i = 1;i <= pageInt;i++) {
//			out.print(i);
//		}
//		out.println();
//		out.println(gl+":"+page);
		
	}	
}
