package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


import utils.JpaUtils;

abstract public class BaseDAO<T> {
	abstract public String getBaseClass();
 	abstract public Class<T> getFullClass();
	private EntityManager em;
	public BaseDAO() {
		this.em = JpaUtils.getEntityManager();
	}
	public T create(T entity) {
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}
	
	public T update(T entity) {
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException();
		}
	}

	public T remove(int id) {
		try {
			T entity = this.findById(id);
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException();
		}
	}

	public T findById(int id) {
		T entity = em.find(getFullClass(), id);
		return entity;
	}
	
	public List<T> getAll(){
		List<T> lst = new ArrayList<T>();
		try {
			String jpql ="FROM "+getBaseClass();
			TypedQuery<T> query = em.createQuery(jpql, getFullClass());
			lst = query.getResultList();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lst;
	}
}
