package tw.com.ejb;

import javax.ejb.Local;

import tw.com.entity.MyUser;
@Local
public interface MyUserBeanLocal {
	
	 boolean regisrter(String account,String password); 
	 MyUser login(String account,String password);
}
