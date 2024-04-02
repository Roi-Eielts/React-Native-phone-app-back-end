package nl.phoneStorageApp.persistance.dao;


import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;

import nl.phoneStorageApp.persistance.interfaces.IGenericDAO;

public abstract class GenericHibernateDAO<T, ID extends Serializable> implements IGenericDAO<T, ID> {

	private Class<T> persistentClass;
	private Session session;

	@SuppressWarnings("unchecked")
	public GenericHibernateDAO() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	public void setSession(Session s) {
		this.session = s;
	}

	protected Session getSession() {
		if (session == null) {
			throw new IllegalStateException("Session has not been set on DAO before usage");
		}
		return session;
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}
	
	@Override
	public T saveOrUpdate(T entity) {
		try {
			getSession().beginTransaction();
			getSession().saveOrUpdate(entity);
			getSession().getTransaction().commit();
			// TODO Do not catch at high level. Catch specific exception
		} catch (PersistenceException e) {
			entity = null;
			
			if (getSession().getTransaction() != null) {
				getSession().getTransaction().rollback();

			}
			if(e.getCause() instanceof ConstraintViolationException) {
				ConstraintViolationException cve = (ConstraintViolationException) e.getCause();
				System.out.println(cve.getSQLException().getSQLState());
				throw (ConstraintViolationException) e.getCause();
			}
		}
		return entity;
	}

	@Override
	public void delete(T entity) {
		getSession().beginTransaction();
		getSession().delete(entity);
		getSession().getTransaction().commit();
	}

	@Override
	public T findById(ID id) {
		getSession().beginTransaction();
		T entity = 	getSession().find(getPersistentClass(), id);
		getSession().getTransaction().commit();
		return entity;
			
	}

	@Override
	public Set<T> findAll() {
		getSession().beginTransaction();

		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		
		CriteriaQuery<T> criteria = builder.createQuery(getPersistentClass());
		Root<T> root = criteria.from(getPersistentClass());
		criteria.select(root);
		
		List<T> list = getSession().createQuery(criteria).getResultList();
		
		getSession().getTransaction().commit();
		
		Set<T> set = new TreeSet<>();
		set.addAll(list);
	
		return set;
	}	

	public void flush() {
		getSession().flush();
	}

	public void clear() {
		getSession().clear();
	}

}
