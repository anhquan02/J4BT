package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtils {
	private static EntityManager em;
	private static EntityManagerFactory factory;
	
	private JpaUtils() {
		
	}
	public static EntityManagerFactory getEntityManagerFactory() {
		if(factory == null || !factory.isOpen()) {
			factory = Persistence.createEntityManagerFactory("Assignment_BanThe");
		}
		return factory;
	}
	public static EntityManager getEntityManager() {		
		if(em == null || !em.isOpen()) {
			getEntityManagerFactory();
			em = factory.createEntityManager();
		}
		return em;
	}
}
