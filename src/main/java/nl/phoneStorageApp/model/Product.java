package nl.phoneStorageApp.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import nl.phoneStorageApp.persistance.factories.DAOFactory;


@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String ammount;
	private String barcode;
	private TypeOfProduct type;
	
	@ManyToOne
	@JsonBackReference(value = "products")
	private Company company;
	
	
	public Product findByid() {
		return DAOFactory.getTheFactory().getProductDAO().findById(this.id);
	}

	public void save() {
		DAOFactory.getTheFactory().getProductDAO().saveOrUpdate(this);
	}

	public void delete() {
		DAOFactory.getTheFactory().getProductDAO().delete(this);
	}

	public Set<User> findAll() {
		return DAOFactory.getTheFactory().getUserDAO().findAll();
	}
	
	// get and setters
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
	public String getAmmount() {
		return ammount;
	}
	public void setAmmount(String ammount) {
		this.ammount = ammount;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public TypeOfProduct getType() {
		return type;
	}
	public void setType(TypeOfProduct type) {
		this.type = type;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}	
}
