package nl.phoneStorageApp.persistance.interfaces;

import nl.phoneStorageApp.model.User;

public interface IUserDAO extends IGenericDAO<User, Integer> {

	User getByUsername(String username);

}
