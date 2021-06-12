package tw.com.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.ejb.MyUserBeanLocal;
import tw.com.entity.MyUser;
@WebServlet("/jpaServlet")
public class JpaServlet  extends HttpServlet{
	@Inject
	EntityManager em;
	@EJB
	private MyUserBeanLocal myUserBean;
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String account = "ken";
		String password = "12345";
			boolean b1 = myUserBean.regisrter(account, password);
			System.out.println(b1);
			MyUser myUser = myUserBean.login(account, password);
			System.out.println(myUser);
		}
}
