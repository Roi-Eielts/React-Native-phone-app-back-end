package nl.phoneStorageApp.persistance.interfaces;

import java.io.Serializable;
import java.util.Set;

public interface IGenericDAO<T, ID extends Serializable>{
	
	public T saveOrUpdate(T entity);
	
	public void delete(T entity);
	
	public T findById(ID id);
	
	public Set<T> findAll();
	
	public T merge(T entity);

}
