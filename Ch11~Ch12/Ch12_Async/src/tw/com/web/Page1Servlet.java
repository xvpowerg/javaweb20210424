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
	//當功能需要長時間運行時 會用占用運行Servlet的執行緒數量
	//導致能進入容器的 用戶變少
	//這時可開啟新的執行緒 解決此問題
	//但無法回應這時可使用asyncSupported
	//執行緒池
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
							act.complete();//非同步要做的事情完成
						}catch(InterruptedException | IOException ex) {
							System.out.println(ex);
						}
					});
					
					
					System.out.println("Page1Servlet End!!!");
		
		}
}
