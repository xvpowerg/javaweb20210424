package tw.com.web.tools;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class MyVerification {
  
	public static boolean  nameInParam(String name,HttpServletRequest req) {
		boolean exist = true;				
		Map<String,String[]>  map =  req.getParameterMap();
		exist = map.keySet().stream().anyMatch(n->n.equals(name));		
		return exist;
		
	}
	
}
