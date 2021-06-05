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
//如果有一個網址是/user 會進來 Filter 先做一次檢查
//如果失敗 可控制轉換網頁 或是 輸出錯誤
@WebFilter("/user")
public class UserPageFilter implements Filter {
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		//可透過是否呼叫chain.doFilter 來控制 是否顯示被控制頁面
		HttpServletRequest httpReq = (HttpServletRequest)req;
		//如果Session 不存在回傳null
		HttpSession session =  httpReq.getSession(false);
		if (session!= null ) {
			Boolean userPass =  (Boolean)session.getAttribute("userPass");
			//表示登入成功
			if (userPass!= null && userPass == true) {
				//可以進入/user
				chain.doFilter(req, resp);
				return;
			}
		}
		//如果沒登入成功 就轉到errormsg
		req.setAttribute("errormsg", "not Login!");
		req.getRequestDispatcher("/error.jsp").forward(req, resp);		
	}

}
