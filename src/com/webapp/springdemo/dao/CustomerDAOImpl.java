package com.webapp.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webapp.springdemo.entity.Customer;

//Note: @Repository is an annotation for DAO classes.
//			1.Allows component scanning
//			2.Translate JDBC exceptions
//		
//		@Autowired is used for dependency injection

//A DAO class for Customer: Responsible for interacting with customer table in the database
@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	//function to get a list of customers from the database
	@Override
	public List<Customer> getCustomers(){
		Session session = sessionFactory.getCurrentSession();
	
		//Create and execute query to get query result
		Query<Customer> query = session.createQuery("FROM Customer", Customer.class);
		List<Customer> customers = query.getResultList();
		
		return customers;
	}

	//function to add or update customer to the database
	@Override
	public void addOrUpdateCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();

		session.saveOrUpdate(customer);
	}

	//function to get customer info with the specified id from the database
	@Override
	public Customer getCustomer(int customerID) {
		Session session = sessionFactory.getCurrentSession();
		
		Customer customer = session.get(Customer.class, customerID);
		
		return customer;
	}

	//function to delete customer with the specified id from the database
	@Override
	public void deleteCustomer(int customerID) {
		Session session = sessionFactory.getCurrentSession();
		
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery("DELETE FROM Customer WHERE id=:customerID");
		query.setParameter("customerID", customerID);
		query.executeUpdate();
	}
}
