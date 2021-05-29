package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/page1"},asyncSupported = true)
public class Page1Servlet extends HttpServlet {
	//��\��ݭn���ɶ��B��� �|�Υe�ιB��Servlet��������ƶq
	//�ɭP��i�J�e���� �Τ��ܤ�
	//�o�ɥi�}�ҷs������� �ѨM�����D
	//���L�k�^���o�ɥi�ϥ�asyncSupported
	//�������
	private ExecutorService service = Executors.newCachedThreadPool();
		@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub					
					System.out.println("Page1Servlet Start!!!");
					AsyncContext act =  req.startAsync();
					service.execute(()->{						
						try {
							TimeUnit.SECONDS.sleep(10);	
							PrintWriter out =  act.getResponse().getWriter();
							out.println("Complete!!...");
							act.complete();//�D�P�B�n�����Ʊ�����
						}catch(InterruptedException | IOException ex) {
							System.out.println(ex);
						}
					});
					
					
					System.out.println("Page1Servlet End!!!");
		
		}
}
