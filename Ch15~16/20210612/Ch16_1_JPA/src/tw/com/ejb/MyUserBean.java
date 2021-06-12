package tw.com.ejb;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import tw.com.entity.MyUser;
//�L���A��Bean �i�h�H���ƨϥ�
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
	//���o�Ĥ@�����
	MyUser myUser = query.getSingleResult();
		if (myUser != null && myUser.getPassword().equals(password)) {
			return myUser;
		}
		
	 return null;
	}

}
