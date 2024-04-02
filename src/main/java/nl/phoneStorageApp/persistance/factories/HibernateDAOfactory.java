package nl.phoneStorageApp.persistance.factories;

import org.hibernate.Session;

import nl.phoneStorageApp.model.Company;
import nl.phoneStorageApp.model.Product;
import nl.phoneStorageApp.model.User;
import nl.phoneStorageApp.persistance.dao.CompanyDAO;
import nl.phoneStorageApp.persistance.dao.GenericHibernateDAO;
import nl.phoneStorageApp.persistance.dao.ProductDAO;
import nl.phoneStorageApp.persistance.dao.UserDAO;
import nl.phoneStorageApp.persistance.interfaces.ICompanyDAO;
import nl.phoneStorageApp.persistance.interfaces.IProductDAO;
import nl.phoneStorageApp.persistance.interfaces.IUserDAO;
import nl.phoneStorageApp.persistance.utils.HibernateSessionManager;

public class HibernateDAOfactory extends DAOFactory {

	protected Session getCurrentSession() {
		return HibernateSessionManager.getSessionFactory().openSession();
	}

	@Override
	public IUserDAO getUserDAO() {
		GenericHibernateDAO<User, Integer> dao = null;
		try {
			dao = UserDAO.class.newInstance();
			dao.setSession(getCurrentSession());
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return (IUserDAO) dao;
	}

	@Override
	public IProductDAO getProductDAO() {
		GenericHibernateDAO<Product, Integer> dao = null;
		try {
			dao = ProductDAO.class.newInstance();
			dao.setSession(getCurrentSession());
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return (IProductDAO) dao;
	}
	
	@Override
	public ICompanyDAO getCompanyDAO() {
		GenericHibernateDAO<Company, Integer> dao = null;
		try {
			dao = CompanyDAO.class.newInstance();
			dao.setSession(getCurrentSession());
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return (ICompanyDAO) dao;
	}
}
