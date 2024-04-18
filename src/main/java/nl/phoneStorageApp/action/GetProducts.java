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
	private Set<Product> products;

	@Override
	public void execute(WebSocketSession session) {
		user = user.findById();
		products = user.getCompany().getProduct();
		session.sendAsync(this);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

}
