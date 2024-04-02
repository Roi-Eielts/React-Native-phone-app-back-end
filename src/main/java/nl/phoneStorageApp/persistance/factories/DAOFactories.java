package nl.phoneStorageApp.persistance.factories;

public enum DAOFactories {
	HIBERNATE(HibernateDAOfactory.class);
	
	private final Class<? extends DAOFactory> theFactory;
	
	private DAOFactories(Class<? extends DAOFactory> factory) {
		this.theFactory = factory;
	}
	
	public Class<? extends DAOFactory> getTheFactory() {
		return theFactory;
	}
}
