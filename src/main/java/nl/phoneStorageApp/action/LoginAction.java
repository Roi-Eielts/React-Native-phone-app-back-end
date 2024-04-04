package nl.phoneStorageApp.action;


import io.micronaut.websocket.WebSocketSession;
import nl.phoneStorageApp.model.ApplicationFacade;
import nl.phoneStorageApp.model.Company;
import nl.phoneStorageApp.model.User;
import nl.phoneStorageApp.module.Action;

public class LoginAction implements Action{
	private User user;

	@Override
	public void execute(WebSocketSession session) {
		User fullUser = ApplicationFacade.getInstance().findUserByUsername(user.getUsername());
		System.out.println(user);
		System.out.println(fullUser);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
