package tw.com.cdi;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class EMProvider {
	//@PersistenceContext �@�� �浹�e�� ���@ EntityManager �޲z
	//�i���U�ڭ̦۰ʧ������
	@PersistenceContext
	@Produces
	private EntityManager em;
}
