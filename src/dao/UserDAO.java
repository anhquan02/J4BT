package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entity.User;
import utils.JpaUtils;

public class UserDAO extends BaseDAO<User>{
	private EntityManager em ;
	public UserDAO() {
	this.em = JpaUtils.getEntityManager();
	}
	@Override
	public String getBaseClass() {
		return User.class.getSimpleName();
	}

	@Override
	public Class<User> getFullClass() {
		// TODO Auto-generated method stub
		return User.class;
	}
	public User login(String username , String password) {
		String jpql = "FROM User WHERE username = :username";
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		query.setParameter("username", username);
		List<User> lst = query.getResultList();
		for (User user : lst) {
			if(user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}

}
