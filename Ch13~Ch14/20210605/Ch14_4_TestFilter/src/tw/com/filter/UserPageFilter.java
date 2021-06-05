package tw.com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
//�p�G���@�Ӻ��}�O/user �|�i�� Filter �����@���ˬd
//�p�G���� �i�����ഫ���� �άO ��X���~
@WebFilter("/user")
public class UserPageFilter implements Filter {
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		//�i�z�L�O�_�I�schain.doFilter �ӱ��� �O�_��ܳQ�����
		HttpServletRequest httpReq = (HttpServletRequest)req;
		//�p�GSession ���s�b�^��null
		HttpSession session =  httpReq.getSession(false);
		if (session!= null ) {
			Boolean userPass =  (Boolean)session.getAttribute("userPass");
			//��ܵn�J���\
			if (userPass!= null && userPass == true) {
				//�i�H�i�J/user
				chain.doFilter(req, resp);
				return;
			}
		}
		//�p�G�S�n�J���\ �N���errormsg
		req.setAttribute("errormsg", "not Login!");
		req.getRequestDispatcher("/error.jsp").forward(req, resp);		
	}

}
