package tw.com.web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/page1")
public class Page1Servlet extends HttpServlet{

	//�����غc��
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
			System.out.println("init page1 Servlet!");
	}

//	@Override
//	public void init(ServletConfig config) throws ServletException {
//		// TODO Auto-generated method stub
//		super.init(config);
//	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//�u���Ĥ@���i�JServlet�| �إ߷s���� 
		//�Ҧ��Ȥ�� ���ϥάۦP��Servlet����
		//�ϥΤ��P��Thread
		//�����Ҷq������w��
		System.out.println(this.hashCode());
		System.out.println(Thread.currentThread().getName());
		
	}
	
}
