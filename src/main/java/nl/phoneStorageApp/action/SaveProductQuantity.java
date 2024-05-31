package nl.phoneStorageApp.action;

import io.micronaut.websocket.WebSocketSession;
import nl.phoneStorageApp.model.Product;
import nl.phoneStorageApp.module.Action;

public class SaveProductQuantity implements Action {
	Product product;
	int quantity;
	
	@Override
	public void execute(WebSocketSession session) {
		product = product.findByid();
		product.setQuantity(quantity);
		product.save();
		session.sendAsync(this);
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
