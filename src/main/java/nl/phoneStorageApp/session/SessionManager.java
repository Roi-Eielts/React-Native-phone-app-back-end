package nl.phoneStorageApp.session;

import java.util.HashSet;
import java.util.Set;

import io.micronaut.websocket.WebSocketSession;
import nl.phoneStorageApp.module.ApplicationSession;

public class SessionManager {

    private static SessionManager instance = null;
    private final ApplicationSession applicationSession = new ApplicationSession();



    public static SessionManager getInstance() {
        if (instance == null)
            instance = new SessionManager();
        return instance;
    }
    
    public ApplicationSession getApplicationSession() {
    	return applicationSession;
    }

    public Set<WebSocketSession> getAllSessions() {
        Set<WebSocketSession> sessions = new HashSet<>();
        sessions.addAll(applicationSession.getSessions());
        return sessions;
    }
}
