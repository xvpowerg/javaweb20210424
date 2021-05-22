package tw.com.web.bean;

import javax.servlet.http.HttpServletRequest;

public class AccountAttr {
	public static final String ACCOUNT_ATTR_KEY = "ac";
	public static <T>void setAttr(HttpServletRequest req,T v) {
		req.setAttribute(ACCOUNT_ATTR_KEY, v);
	}
	public static <T> T getAttr(HttpServletRequest req) {
		return (T)req.getAttribute(ACCOUNT_ATTR_KEY);
	}

}
