package com.webapp.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.springdemo.dao.CustomerDAO;
import com.webapp.springdemo.entity.Customer;

//Note: A Service Layer is an intermediate layer for custom business logic
//Integrate data from multiple sources (DAO/repositories)
//
//@Transactional is used to automatically begin and end transaction for Hibernate code
@Service
public class CustomerServiceImpl implements CustomerService{
	
	//inject customer dao
	@Autowired
	private CustomerDAO customerDAO;
	
	@Transactional
	@Override
	public List<Customer> getCustomers(){
		return customerDAO.getCustomers();
	}

	@Transactional
	@Override
	public void addOrUpdateCustomer(Customer customer) {
		customerDAO.addOrUpdateCustomer(customer);
	}

	@Transactional
	@Override
	public Customer getCustomer(int customerID) {
		return customerDAO.getCustomer(customerID);
	}
	
	@Transactional
	@Override
	public void deleteCustomer(int customerID) {
		customerDAO.deleteCustomer(customerID);
	}
}
