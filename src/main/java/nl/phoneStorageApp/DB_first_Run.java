package nl.phoneStorageApp;

import org.hibernate.Session;

import nl.phoneStorageApp.model.Company;
import nl.phoneStorageApp.model.Password;
import nl.phoneStorageApp.model.Password.CannotPerformOperationException;
import nl.phoneStorageApp.persistance.factories.DAOFactories;
import nl.phoneStorageApp.persistance.factories.DAOFactory;
import nl.phoneStorageApp.persistance.utils.HibernateSessionManager;
import nl.phoneStorageApp.model.User;

public class DB_first_Run {
	
	public static void main(String[] args) {
			DAOFactory.setTheFactory(DAOFactories.HIBERNATE.getTheFactory());

			Session session = HibernateSessionManager.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			User user = new User();
			Company company = new Company();
			user.setUsername("iemand");
			user.setEmail("jante@mail.nl");
			user.setPassword("sha1:64000:18:4TdQQu9vaKx66vkbE/w+ZLdR3jqf9ha2:FdLm6AgFHMxt0LyO0k6PJS0I");
			
			
			company.setName("yes");
			company.save();
			user.setCompany(company);
			user.save();
			HibernateSessionManager.getSessionFactory().getCurrentSession().getTransaction().commit();
			HibernateSessionManager.shutdown();
			

		
	}

}
