package nl.phoneStorageApp.persistance.dao;

import nl.phoneStorageApp.model.User;
import nl.phoneStorageApp.persistance.interfaces.IUserDAO;

public class UserDAO extends GenericHibernateDAO<User, Integer> implements IUserDAO{

}
