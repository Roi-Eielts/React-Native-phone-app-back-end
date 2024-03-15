package nl.phoneStorageApp.session;

import java.util.HashSet;
import java.util.Set;

import io.micronaut.websocket.WebSocketSession;

public abstract class AbstractSession {
	private final Set<WebSocketSession> sessions = new HashSet<>();

    public void add(WebSocketSession session) {
        this.sessions.add(session);
    }

    public void remove(WebSocketSession session) {
        this.sessions.remove(session);
    }

    public Set<WebSocketSession> getSessions() {
        return sessions;
    }
}
