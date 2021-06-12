package tw.com.cdi;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Produces;
import javax.inject.Named;

import tw.com.bean.Student;

public class MyProduces {
	@Produces
	@Named("Ken")
	public Student getKenSetudent() {		
		Student st = new Student();
		st.setName("Kne");
		st.setId(10);
		return st;		
	}
	@Produces
	@Named("QueryStudent")
	public List<Student> queryAllStuednt() {
		List<Student> list = new ArrayList();
		Student st = new Student();
		st.setName("Kne");
		st.setId(10);
		Student st2 = new Student();
		st2.setName("Iris");
		st2.setId(25);
		list.add(st);
		list.add(st2);
		return list;
	}
	
}
