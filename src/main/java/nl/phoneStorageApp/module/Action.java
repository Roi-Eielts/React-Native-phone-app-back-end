package nl.phoneStorageApp.module;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.micronaut.websocket.WebSocketSession;

// class imports
import nl.phoneStorageApp.action.LearnAction;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ 
	@JsonSubTypes.Type(value = LearnAction.class, name = "first"),
})

public interface Action {

    void execute(WebSocketSession session);

}