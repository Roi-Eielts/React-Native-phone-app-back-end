package nl.phoneStorageApp.action;

import java.util.List;
import java.util.Set;

import io.micronaut.websocket.WebSocketSession;
import nl.phoneStorageApp.model.Company;
import nl.phoneStorageApp.model.Product;
import nl.phoneStorageApp.model.User;
import nl.phoneStorageApp.module.Action;

public class GetProducts implements Action{
	
	User user;
	static Company company;
	List<Product> products;

	@Override
	public void execute(WebSocketSession session) {
		company = company.findById(user.getCompany().getId());
		products = company.getCompanyProducts();
		session.sendAsync(this);
	}

}
