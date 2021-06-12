package tw.com.cdi;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class EMProvider {
	//@PersistenceContext 作用 交給容器 維護 EntityManager 管理
	//可幫助我們自動完成交易
	@PersistenceContext
	@Produces
	private EntityManager em;
}
