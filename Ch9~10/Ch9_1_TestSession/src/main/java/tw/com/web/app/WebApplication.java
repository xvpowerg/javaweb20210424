package tw.com.web.app;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.ThreadLocalRandom;
//���@MySession
//MySession �j�q�s����
public final class WebApplication {
	private WebApplication() {}
   private static Map<String,MySession> sessionMap = new HashMap<>();
   
	 static void addMySession(HttpServletRequest req,
				HttpServletResponse resp,String key) {
		 MySession mySession = MySession.getMySession();
		 sessionMap.put(key, mySession);
	 }
	 //��ܤ��bSession�� �n�s�WSession
	public static MySession getMySession(HttpServletRequest req,
				HttpServletResponse resp) {				
		 return getMySession(req,resp,true);
	 }
	public static MySession getMySession(HttpServletRequest req,
				HttpServletResponse resp,boolean newSession) {
		
		//�p�GKey���b�ڴN
		//newSession �O�_�� true
		//true �N�s�W
		//false �N���s�W
		String key = getKey(req,resp);
		  if (!sessionMap.containsKey(key) && newSession) {
			  addMySession(req, resp, key);
		  }		
		 return sessionMap.get(key);
	 }
	
	private static String getKey(HttpServletRequest req,
			HttpServletResponse resp) {
		 Cookie[] cookies =  req.getCookies();
		if (cookies != null){
		   Stream<Cookie> cookStr = Stream.of(cookies);
		  Optional<Cookie> optional =cookStr.filter(cook->cook.getName().equals(MySession.MY_SESSION_ID)).
		   findFirst();
		  if (optional.isPresent()) {
			  return optional.get().getValue(); 
		  }
		}
		//toHexString 10�i����16�i��
		   String key = 
				   Integer.toHexString(ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE));
		   Cookie cookie = new Cookie(MySession.MY_SESSION_ID,key);
		   resp.addCookie(cookie);		
		return key;
	}
}
