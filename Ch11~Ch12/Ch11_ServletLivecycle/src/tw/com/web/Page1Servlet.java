package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//�Ĥ@��Servlet �B��ɶ���
//init(ServletConfig)
//init(ServletConfig) �I�sinit()
//���ͤFServlet����
//�|�}�s����� �B��service(ServletRequest req, ServletResponse res)
//service(ServletRequest req, ServletResponse res)�I�sservice(HttpServletRequest req, HttpServletResponse resp)
//��service(HttpServletRequest req, HttpServletResponse resp) �P�w�өI�sdoGet�άOdoPost...
//�C���e�������� �|�I�s destroy �i����귽

//�p�G�w��Servlet����
//�|�}�s����� �B��service(ServletRequest req, ServletResponse res)
//service(ServletRequest req, ServletResponse res)�I�sservice(HttpServletRequest req, HttpServletResponse resp)
//��service(HttpServletRequest req, HttpServletResponse resp) �P�w�өI�sdoGet�άOdoPost...


@WebServlet("/page1")
public class Page1Servlet extends HttpServlet {
	ServletConfig myConfig;
		
	@Override
	public void init() throws ServletException {
		System.out.println("init!!!");
	}
	
	//����ĳ�Ƽginit(ServletConfig config)
	//�]��init(ServletConfig config)��k���@�@�Ǫ�l�ƪ��ʧ@
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		myConfig = config;
		super.init(config);
	}

	//�p�G���ݨD�A�i�JdoGet dogPost�e�@�@�� �e�m �i�H�Ƽg
	//service(HttpServletRequest req, HttpServletResponse resp)
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("Http service ");		
		//�P�_�өI�sdoGet�٬OdoPost
		super.service(req, resp);
		System.out.println(this.getServletConfig() == myConfig); 
		
	}

	//�p�G�AHttpServlet���l���O�� ���ݭnOverride  service(ServletRequest req, ServletResponse res)
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, res);
	}
	

	@Override
	protected void doGet(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println("Page1Servlet!!");
	}
	
	//�i����귽����...
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("page1 destroy!");
	}
	
	
	
}
