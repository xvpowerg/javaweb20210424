package tw.com.web.app;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//維護屬性
public class MySession {
	public static final String MY_SESSION_ID="MySESSIONID";
	private Map<String,Object> attrbuteMap = new HashMap<>();
	//在不同package不能new MySession
	MySession(){}
	
	static MySession getMySession() {
		return getMySession(true);
	}
	
	static MySession getMySession(boolean newSession) {
		MySession mySession = null;
		if (newSession) {
			 mySession = new MySession();	
		}		
		return mySession;
	}
	
   public void addAttrbute(String key,Object value) {	  
	   attrbuteMap.put(key, value);
   }
   
   public Object getAttrbute(String key) {
	   System.out.println(attrbuteMap);
	   return attrbuteMap.get(key); 
   }


}
