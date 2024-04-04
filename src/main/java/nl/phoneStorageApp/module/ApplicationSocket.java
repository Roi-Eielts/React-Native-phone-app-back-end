package nl.phoneStorageApp.module;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.websocket.WebSocketSession;
import io.micronaut.websocket.annotation.OnClose;
import io.micronaut.websocket.annotation.OnMessage;
import io.micronaut.websocket.annotation.OnOpen;
import io.micronaut.websocket.annotation.ServerWebSocket;
import nl.phoneStorageApp.Inteceptor.Hibernate;
import nl.phoneStorageApp.session.SessionManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ServerWebSocket("/")
public class ApplicationSocket {
	private static final Logger LOG = LoggerFactory.getLogger(ApplicationSocket.class);
	
	@OnOpen
	public void onOpen(WebSocketSession session) {
		SessionManager.getInstance().getApplicationSession().add(session);
		LOG.info(String.format("[%s] started the connection ", session.getId()));
	}
	
	@Hibernate
	@OnMessage(maxPayloadLength = 1000000)
	public void onMessage(String message, WebSocketSession session) {
		Action action;
		try {
            action = new ObjectMapper().readValue(message, Action.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        action.execute(session);
	}
	
	@OnClose
    public void onClose( WebSocketSession session) {
        SessionManager.getInstance().getApplicationSession().remove(session);
        LOG.info(String.format("[%s] disconnected the session ", session.getId()));
    }
	
	
}
