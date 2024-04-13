package nl.phoneStorageApp.module;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.micronaut.websocket.WebSocketSession;
import nl.phoneStorageApp.action.GetProducts;
// class imports
import nl.phoneStorageApp.action.LearnAction;
import nl.phoneStorageApp.action.LoginAction;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ 
	@JsonSubTypes.Type(value = LearnAction.class, name = "first"),
	@JsonSubTypes.Type(value = LoginAction.class, name = "LOGIN"),
	@JsonSubTypes.Type(value = GetProducts.class, name = "GET_PRODUCTS"),

})

public interface Action {

    void execute(WebSocketSession session);

}