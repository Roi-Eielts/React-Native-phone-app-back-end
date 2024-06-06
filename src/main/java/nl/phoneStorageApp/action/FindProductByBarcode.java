package nl.phoneStorageApp.action;

import java.util.Set;

import io.micronaut.websocket.WebSocketSession;
import nl.phoneStorageApp.model.Product;
import nl.phoneStorageApp.module.Action;

public class FindProductByBarcode implements Action{
	String barcode;
	Product product;
	Product foundProduct;
	Set<Product> products;
	
	@Override
	public void execute(WebSocketSession session) {
		product = new Product();
		products = product.findAll();
		for(Product p : products) {
			if(p.getBarcode() != null) {
				if(p.getBarcode().equals(barcode)) {
					foundProduct = p;
				}
			}
		}
		session.sendAsync(this);
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public Product getFoundProduct() {
		return foundProduct;
	}

	public void setFoundProduct(Product foundProduct) {
		this.foundProduct = foundProduct;
	}
	
}
