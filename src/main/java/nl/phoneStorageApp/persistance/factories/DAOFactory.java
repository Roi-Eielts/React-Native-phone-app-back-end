package nl.phoneStorageApp.persistance.factories;

import nl.phoneStorageApp.persistance.interfaces.ICompanyDAO;
import nl.phoneStorageApp.persistance.interfaces.IProductDAO;
import nl.phoneStorageApp.persistance.interfaces.IUserDAO;

public abstract class DAOFactory {
	 private static DAOFactory theFactory;

	    public static DAOFactory getTheFactory() {
	        return theFactory;
	    }



		public static void setTheFactory(Class<? extends DAOFactory> factory) {
			try {
				theFactory = factory.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
				throw new RuntimeException("Unable to create DAOFactory: " + factory);
			}
		}
	    
//	    interfaces of get DAO`S
	    public abstract IUserDAO getUserDAO();
	    public abstract IProductDAO getProductDAO();
	    public abstract ICompanyDAO getCompanyDAO();
}
