package nl.phoneStorageApp.persistance.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.query.Query;

import nl.phoneStorageApp.model.Product;
import nl.phoneStorageApp.persistance.interfaces.IProductDAO;


public class ProductDAO extends GenericHibernateDAO<Product, Integer> implements IProductDAO {

	@Override
	public List<Product> getProductsByCompany(int id) {
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<Product> criteriaQ = builder.createQuery(getPersistentClass());
		Root<Product> root = criteriaQ.from(getPersistentClass());
		criteriaQ.select(root).where(builder.equal(root.get("company"), id));
		Query<Product> q = getSession().createQuery(criteriaQ);

		return q.list();
	}


}
