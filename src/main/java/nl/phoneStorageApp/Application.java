package nl.phoneStorageApp;

import org.hibernate.Session;

import io.micronaut.runtime.Micronaut;
import nl.phoneStorageApp.model.ApplicationFacade;
import nl.phoneStorageApp.model.Company;
import nl.phoneStorageApp.model.User;
import nl.phoneStorageApp.persistance.factories.DAOFactory;
import nl.phoneStorageApp.persistance.factories.HibernateDAOfactory;
import nl.phoneStorageApp.persistance.utils.HibernateSessionManager;

public class Application {

	public static void main(String[] args) {
		DAOFactory.setTheFactory(HibernateDAOfactory.class);
		Micronaut.run(Application.class, args);
		System.out.println("started server");

		createOneAccount();
	}

	public static void createOneAccount() {
		Session session = HibernateSessionManager.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Company comp;
		User user;

		if (ApplicationFacade.getInstance() == null) {
			comp = new Company();
			user = new User();
			
			//create company
			comp.setName("first Company");
			DAOFactory.getTheFactory().getCompanyDAO().saveOrUpdate(comp);
			
			user.setCompany(comp);
			user.setEmail("test@mail");
			user.setUsername("admin");
			user.setPassword("sha1:64000:18:4TdQQu9vaKx66vkbE/w+ZLdR3jqf9ha2:FdLm6AgFHMxt0LyO0k6PJS0I");
			DAOFactory.getTheFactory().getUserDAO().saveOrUpdate(user);
			
			HibernateSessionManager.getSessionFactory().getCurrentSession().getTransaction().commit();
		}
		session.close();
	}
}