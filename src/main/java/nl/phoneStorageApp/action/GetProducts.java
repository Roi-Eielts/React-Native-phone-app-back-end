package nl.phoneStorageApp.action;

import java.util.List;
import java.util.Set;

import io.micronaut.websocket.WebSocketSession;
import nl.phoneStorageApp.model.Company;
import nl.phoneStorageApp.model.Product;
import nl.phoneStorageApp.model.User;
import nl.phoneStorageApp.module.Action;

public class GetProducts implements Action{
	
	private User user;
	private Company company;
	private List<Product> products;

	@Override
	public void execute(WebSocketSession session) {
		user = user.findById();
		company = company.findById(user.getCompany().getId());
		products = company.getCompanyProducts();
		session.sendAsync(this);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
