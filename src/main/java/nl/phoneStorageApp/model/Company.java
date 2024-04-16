package nl.phoneStorageApp.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import nl.phoneStorageApp.persistance.factories.DAOFactory;

@Entity
@Table(name = "company")
public class Company implements Comparable<Company>, Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
 
	@OneToMany(mappedBy = "company")
	private Set<User> users;

	
	@OneToMany(mappedBy = "company")
	private Set<Product> product;

	public void save() {
		DAOFactory.getTheFactory().getCompanyDAO().saveOrUpdate(this);
	}

	public void delete() {
		DAOFactory.getTheFactory().getCompanyDAO().delete(this);
	}

	public Company findById() {
		return DAOFactory.getTheFactory().getCompanyDAO().findById(this.id);
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

	@JsonIgnore
	public List<Product> getCompanyProducts() {
		return DAOFactory.getTheFactory().getProductDAO().getProductsByCompany(this.id)
;
	}
	
	public User findUserByUsername(String username) {
		for (User a : getUsers()) {
			if (a.getUsername().equalsIgnoreCase(username)) {
				System.out.println(a);
				return a;
			}
		}
		return null;
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

	public void setUser(User user) {
		this.users.add(user);
	}

	public Set<Product> getProduct() {
		return product;
	}

	public void setProduct(Set<Product> product) {
		this.product = product;
	}

	@Override
	public int compareTo(Company o) {
		return name.compareTo(o.getName());
	}

}
