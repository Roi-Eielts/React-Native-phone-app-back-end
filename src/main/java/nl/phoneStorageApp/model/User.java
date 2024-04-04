package nl.phoneStorageApp.model;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonBackReference;

import nl.phoneStorageApp.persistance.factories.DAOFactory;

@Entity
@Table(name = "user", uniqueConstraints = { @UniqueConstraint(columnNames = "email") })
public class User implements Comparable<User> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "email", nullable = false, unique = true)
	private String email;
	@Column(name = "username", unique = true, nullable = false)
	private String username;
	@Column(name = "password", nullable = false)
	private String password;
	
	@ManyToOne
	@JsonBackReference(value = "users")
	private Company company;

	public User findById() {
		return DAOFactory.getTheFactory().getUserDAO().findById(this.id);
	}

	public void save() {
		DAOFactory.getTheFactory().getUserDAO().saveOrUpdate(this);
	}

	public void delete() {
		DAOFactory.getTheFactory().getUserDAO().delete(this);
	}

	public Set<User> findAll() {
		return DAOFactory.getTheFactory().getUserDAO().findAll();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public int compareTo(User o) {
		return username.compareTo(o.getUsername());
	}

}
