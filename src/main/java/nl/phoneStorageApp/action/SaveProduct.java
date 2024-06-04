package nl.phoneStorageApp.action;

import java.util.Set;

import io.micronaut.websocket.WebSocketSession;
import nl.phoneStorageApp.model.Product;
import nl.phoneStorageApp.model.User;
import nl.phoneStorageApp.module.Action;

public class SaveProduct implements Action{
	
	Product product;

	@Override
	public void execute(WebSocketSession session) {
		Product oldProduct = product.findByid();
		product.setCompany(oldProduct.getCompany());
		product.save();
		session.sendAsync(this);
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}
