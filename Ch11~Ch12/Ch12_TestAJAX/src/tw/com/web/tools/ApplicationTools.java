package tw.com.web.tools;

import javax.servlet.ServletContext;
import java.util.Optional;
public class ApplicationTools {
	public  static int getAttribute(ServletContext app,String name,int def) {
		Integer obj = (Integer)app.getAttribute(name);
		Optional<Integer> option = Optional.ofNullable(obj);
		//option.orElseGet 表示如果option內容為null會回傳 def 並且呼叫setAttribute
		//表示如果option內容不是null回傳內容
		return option.orElseGet(()->{
			app.setAttribute(name, def);
			return def;});
		
	}
}
