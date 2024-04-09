package nl.phoneStorageApp.persistance.dao;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import nl.phoneStorageApp.model.User;
import nl.phoneStorageApp.persistance.interfaces.IUserDAO;

public class UserDAO extends GenericHibernateDAO<User, Integer> implements IUserDAO{

	@Override
	public User getByUsername(String username) {
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<User> criteria = builder.createQuery(getPersistentClass());
		Root<User> root = criteria.from(getPersistentClass());
		criteria.where(builder.equal(root.get("username"), username));
		User user = null;
		try {
			user = getSession().createQuery(criteria).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
		return user;
	}	
}
