package com.webapp.springdemo.dao;

import java.util.List;

import com.webapp.springdemo.entity.Customer;

//An interface to define methods that must be implemented by Customer DAO class
public interface CustomerDAO {
	public List<Customer> getCustomers();
	
	public void addOrUpdateCustomer(Customer customer);
	
	public Customer getCustomer(int customerID);
	
	public void deleteCustomer(int customerID);
}
