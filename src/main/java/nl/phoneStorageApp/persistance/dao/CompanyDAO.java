package nl.phoneStorageApp.persistance.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import nl.phoneStorageApp.model.Company;
import nl.phoneStorageApp.model.Product;
import nl.phoneStorageApp.persistance.interfaces.ICompanyDAO;

public class CompanyDAO extends GenericHibernateDAO<Company, Integer> implements ICompanyDAO {

}
