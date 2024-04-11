package nl.phoneStorageApp.persistance.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import nl.phoneStorageApp.model.Product;
import nl.phoneStorageApp.persistance.interfaces.IProductDAO;


public class ProductDAO extends GenericHibernateDAO<Product, Integer> implements IProductDAO {

	@Override
	public List<Product> getProductsByCompany(int id) {
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<Product> criteria = builder.createQuery(getPersistentClass());
		Root<Product> root = criteria.from(getPersistentClass());
		criteria.where(builder.equal(root.get("company_id"), id));
		List<Product> products = null;
		try {
			products = (List<Product>) getSession().createQuery(criteria);
		} catch (NoResultException e) {
			return null;
		}
		return products;
	}


}
