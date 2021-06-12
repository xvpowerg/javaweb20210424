package tw.com.ejb;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import tw.com.entity.MyUser;
//無狀態的Bean 可多人重複使用
@Stateless
public class MyUserBean implements MyUserBeanLocal{
	@Inject
	private EntityManager em;
	@Override
	public boolean regisrter(String account, String password) {
		
		MyUser myUser = new MyUser();
		myUser.setAccount(account);
		myUser.setPassword(password);
		try{			
			em.persist(myUser);
			return true; 
		}catch(Exception ex) {
			System.out.println(ex);
		}		
		return false;
	}

	@Override
	public MyUser login(String account, String password) {
		
	TypedQuery<MyUser>	query = em.createNamedQuery("findUser",MyUser.class);
	query.setParameter("account", account);	
	//取得第一筆資料
	MyUser myUser = query.getSingleResult();
		if (myUser != null && myUser.getPassword().equals(password)) {
			return myUser;
		}
		
	 return null;
	}

}
