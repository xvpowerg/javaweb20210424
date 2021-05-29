package tw.com.web.tools;

import javax.servlet.ServletContext;
import java.util.Optional;
public class ApplicationTools {
	public  static int getAttribute(ServletContext app,String name,int def) {
		Integer obj = (Integer)app.getAttribute(name);
		Optional<Integer> option = Optional.ofNullable(obj);
		//option.orElseGet ��ܦp�Goption���e��null�|�^�� def �åB�I�ssetAttribute
		//��ܦp�Goption���e���Onull�^�Ǥ��e
		return option.orElseGet(()->{
			app.setAttribute(name, def);
			return def;});
		
	}
}
