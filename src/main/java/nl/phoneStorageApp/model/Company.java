package nl.phoneStorageApp.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import nl.phoneStorageApp.persistance.factories.DAOFactory;

@Entity
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@OneToMany(mappedBy = "company", cascade = { CascadeType.ALL })
	private Set<User> users;
	
	@OneToMany(mappedBy = "company", cascade = { CascadeType.ALL })
	private Set<Product> product;
	
	public void save() {
		DAOFactory.getTheFactory().getCompanyDAO().saveOrUpdate(this);
	}
	
	public void delete() {
		DAOFactory.getTheFactory().getCompanyDAO().delete(this);
	}
	
	public Company findById(int id) {
		return DAOFactory.getTheFactory().getCompanyDAO().findById(id);
	}
	
	public Set<Company> getAll() {
		return DAOFactory.getTheFactory().getCompanyDAO().findAll();
	}
	
	public Company merge() {
		return DAOFactory.getTheFactory().getCompanyDAO().merge(this);
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public Set<Product> getProduct() {
		return product;
	}
	public void setProduct(Set<Product> product) {
		this.product = product;
	}
	
}
