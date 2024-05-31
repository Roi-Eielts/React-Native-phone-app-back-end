package nl.phoneStorageApp.action;

import java.util.Set;

import io.micronaut.websocket.WebSocketSession;
import nl.phoneStorageApp.model.Company;
import nl.phoneStorageApp.model.Product;
import nl.phoneStorageApp.model.User;
import nl.phoneStorageApp.module.Action;

public class GetCompanyAllProducts implements Action {
	User user;
	Set<Product> products;
	@Override
	public void execute(WebSocketSession session) {
		user = user.findById();
		Company comp = user.getCompany();
		products = comp.getProduct();
		session.sendAsync(this);
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Set<Product> getProduct() {
		return products;
	}
	public void setProduct(Set<Product> product) {
		this.products = product;
	}
}
