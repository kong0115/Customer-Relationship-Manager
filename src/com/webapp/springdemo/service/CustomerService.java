package com.webapp.springdemo.service;

import java.util.List;

import com.webapp.springdemo.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();
	
	public void addOrUpdateCustomer(Customer customer);
	
	public Customer getCustomer(int customerID);
	
	public void deleteCustomer(int customerID);
}
