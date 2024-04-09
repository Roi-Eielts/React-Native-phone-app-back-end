package nl.phoneStorageApp.model;

import java.util.Set;
import java.util.SortedSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import nl.phoneStorageApp.persistance.factories.DAOFactory;

@Entity
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	@OneToMany(mappedBy = "company")
	@JsonManagedReference(value = "users")
	private SortedSet<User> users;

	@OneToMany(mappedBy = "company")
	@JsonManagedReference(value = "products")
	private SortedSet<Product> product;

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

	public User findUserByUsername(String username) {
		for (User a : getUsers()) {
			if (a.getUsername().equalsIgnoreCase(username)) {
				return a;
			}
		}
		return null;
	}
	
	public User findUserByEmail(String email) {
		for (User a : getUsers()) {
			if (a.getEmail().equalsIgnoreCase(email)) {
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

	public SortedSet<User> getUsers() {
		return users;
	}

	public void setUsers(SortedSet<User> users) {
		this.users = users;
	}

	public void setUser(User user) {
		this.users.add(user);
	}

	public SortedSet<Product> getProduct() {
		return product;
	}

	public void setProduct(SortedSet<Product> product) {
		this.product = product;
	}

}
