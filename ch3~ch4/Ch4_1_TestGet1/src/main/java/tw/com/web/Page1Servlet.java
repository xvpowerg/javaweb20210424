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
	final String imageTmp = "<img alt='�v�ܩi%d' src='/Ch4_1_TestGet1/images/image%d.jpg'>";
	//�u�I
	//get �t�ק�
	//�i�H�[��ڪ��̷R
	//²��
	//���o��T ��ܸ�� �d�߸�� �q�`���g�J
	//���I
	//�w���ʧC
	@Override
	protected void doGet(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out =   resp.getWriter();
		//out.println("Page1");
		//�Ҧ�Parameter ���OString
		String gl = req.getParameter("gl");
		String page = req.getParameter("page");
		String image1 = String.format(imageTmp, 1,1);
		String image2 = String.format(imageTmp, 2,2);
		String html = String.format(htmlTmp, image1+image2);
		out.println(html);
//		int  pageInt = Integer.parseInt(page);
//		for (int i = 1;i <= pageInt;i++) {
//			out.print(i);
//		}
//		out.println();
//		out.println(gl+":"+page);
		
	}	
}
