package nl.phoneStorageApp.persistance.interfaces;

import java.util.List;

import nl.phoneStorageApp.model.Product;


public interface IProductDAO extends IGenericDAO<Product, Integer>{

	List<Product> getProductsByCompany(int id);
	
//	List<Product> getProductsByCompany(int id);

}
