package nl.phoneStorageApp.action;

import io.micronaut.websocket.WebSocketSession;
import nl.phoneStorageApp.model.Company;
import nl.phoneStorageApp.model.Product;
import nl.phoneStorageApp.model.User;
import nl.phoneStorageApp.module.Action;

public class CreateProduct implements Action {
	
	Product product;
	User user;

	@Override
	public void execute(WebSocketSession session) {
		user = user.findById();
		Company comp = user.getCompany();
		product.setCompany(comp);
		product.save();
		session.sendAsync(this);
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
