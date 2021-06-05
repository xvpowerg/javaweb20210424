package tw.com.web.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class MySessionAttributeListener implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		
		String name = event.getName();
		String value = event.getValue().toString();
		System.out.println("attributeAdded:"+name+":"+value);
	}

	
	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		//�i�Ѫ�����Session  ���s��
		event.getSession().getAttribute("logintime");
		String name = event.getName();
		//���o�­�
		String value = event.getValue().toString();
		System.out.println("attributeReplaced:"+name+":"+value);
	}
	
	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		String name = event.getName();
		String value = event.getValue().toString();
		System.out.println("attributeRemoved:"+name+":"+value);
	}

		
}
