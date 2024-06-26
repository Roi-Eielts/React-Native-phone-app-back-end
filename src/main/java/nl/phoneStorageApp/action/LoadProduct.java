package nl.phoneStorageApp.action;

import io.micronaut.websocket.WebSocketSession;
import nl.phoneStorageApp.model.Product;
import nl.phoneStorageApp.module.Action;

public class LoadProduct implements Action {
	Product product;

	@Override
	public void execute(WebSocketSession session) {
		product = product.findByid();
		session.sendAsync(this);
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}
