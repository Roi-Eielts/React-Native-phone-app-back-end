package nl.phoneStorageApp.persistance.dao;

import nl.phoneStorageApp.model.Product;
import nl.phoneStorageApp.persistance.interfaces.IProductDAO;


public class ProductDAO extends GenericHibernateDAO<Product, Integer> implements IProductDAO {

}
