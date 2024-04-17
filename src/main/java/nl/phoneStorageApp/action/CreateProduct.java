package nl.phoneStorageApp.action;

import io.micronaut.websocket.WebSocketSession;
import nl.phoneStorageApp.model.Company;
import nl.phoneStorageApp.model.Product;
import nl.phoneStorageApp.model.User;
import nl.phoneStorageApp.module.Action;

public class CreateProduct implements Action {
	
	Product product;
	Company comp;
	User user;

	@Override
	public void execute(WebSocketSession session) {
		
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Company getComp() {
		return comp;
	}

	public void setComp(Company comp) {
		this.comp = comp;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
