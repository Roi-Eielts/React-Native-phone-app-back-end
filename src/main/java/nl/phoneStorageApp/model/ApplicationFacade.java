package nl.phoneStorageApp.model;

import nl.phoneStorageApp.persistance.factories.DAOFactory;

public class ApplicationFacade {
	private static Company instance;

	public static Company getInstance() {
		if(instance != null) {
			instance.save();
			instance.merge();
		}
		if(instance == null) {
			instance = DAOFactory.getTheFactory().getCompanyDAO().findById(1);
		}
		
		
		return instance;
	}

	public static void setInstance(Company instance) {
		ApplicationFacade.instance = instance;
	}


}
