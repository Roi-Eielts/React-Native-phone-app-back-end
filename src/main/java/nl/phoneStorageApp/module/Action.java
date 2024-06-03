package nl.phoneStorageApp.module;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.micronaut.websocket.WebSocketSession;
import nl.phoneStorageApp.action.CreateProduct;
import nl.phoneStorageApp.action.DeleteProduct;
import nl.phoneStorageApp.action.GetCompanyAllProducts;
import nl.phoneStorageApp.action.GetProducts;
// class imports
import nl.phoneStorageApp.action.LearnAction;
import nl.phoneStorageApp.action.LoadProduct;
import nl.phoneStorageApp.action.LoadProductToEdit;
import nl.phoneStorageApp.action.LoginAction;
import nl.phoneStorageApp.action.SaveProduct;
import nl.phoneStorageApp.action.SaveProductQuantity;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ 
	@JsonSubTypes.Type(value = LearnAction.class, name = "first"),
	@JsonSubTypes.Type(value = LoginAction.class, name = "LOGIN"),
	@JsonSubTypes.Type(value = GetProducts.class, name = "GET_PRODUCTS"),
	@JsonSubTypes.Type(value = CreateProduct.class, name = "CREATE_PRODUCT"),
	@JsonSubTypes.Type(value = GetCompanyAllProducts.class, name = "GET_ALL_COMPANY_PRODUCTS"),
	@JsonSubTypes.Type(value = LoadProduct.class, name = "LOAD_PRODUCT"),
	@JsonSubTypes.Type(value = SaveProductQuantity.class, name = "SAVE_QUANTITY"),
	@JsonSubTypes.Type(value = DeleteProduct.class, name = "DELETE_PRODUCT"),
	@JsonSubTypes.Type(value = LoadProductToEdit.class, name = "LOAD_PRODUCT_TO_EDIT"),
	@JsonSubTypes.Type(value = SaveProduct.class, name = "SAVE_PRODUCT"),
})

public interface Action {

    void execute(WebSocketSession session);

}