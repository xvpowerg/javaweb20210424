package tw.com.web.app;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.ThreadLocalRandom;
//維護MySession
//MySession 綁訂瀏覽器
public final class WebApplication {
	private WebApplication() {}
   private static Map<String,MySession> sessionMap = new HashMap<>();
   
	 static void addMySession(HttpServletRequest req,
				HttpServletResponse resp,String key) {
		 MySession mySession = MySession.getMySession();
		 sessionMap.put(key, mySession);
	 }
	 //表示不在Session時 要新增Session
	public static MySession getMySession(HttpServletRequest req,
				HttpServletResponse resp) {				
		 return getMySession(req,resp,true);
	 }
	public static MySession getMySession(HttpServletRequest req,
				HttpServletResponse resp,boolean newSession) {
		
		//如果Key不在我就
		//newSession 是否為 true
		//true 就新增
		//false 就不新增
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
		//toHexString 10進位轉16進位
		   String key = 
				   Integer.toHexString(ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE));
		   Cookie cookie = new Cookie(MySession.MY_SESSION_ID,key);
		   resp.addCookie(cookie);		
		return key;
	}
}
