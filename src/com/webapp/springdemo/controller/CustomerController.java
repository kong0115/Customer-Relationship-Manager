package com.webapp.springdemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.webapp.springdemo.entity.Customer;
import com.webapp.springdemo.service.CustomerService;


//This class will handle HTTP requests for /customer route.
@Controller
@RequestMapping("/customer")
public class CustomerController {

	//inject customer service for interacting with database
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String listCustomers(Model model) {
		
		List<Customer> customers = customerService.getCustomers();
		model.addAttribute("customers", customers);
		
		return "listCustomers";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String showFormForAdd(Model model) {
		
		Customer customer = new Customer();
		
		//bind model data to the form 
		model.addAttribute("customer", customer);
		
		return "customerForm";
	}
	
	@RequestMapping(value="/processCustomerForm", method=RequestMethod.POST)
	public String processCustomerForm(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {
		
		//check for input validations
		if(bindingResult.hasErrors()) {
			return "customerForm";
		}
		
		//add or update customer to the database
		customerService.addOrUpdateCustomer(customer);
		
		//redirect to the listCustomers page
		return "redirect:/customer/list";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String showFormForUpdate(@RequestParam("customerID") int customerID, Model model) {
		
		//get customer from service
		Customer customer = customerService.getCustomer(customerID);
		
		//pre-populate the form with customer info
		model.addAttribute("customer", customer);
		
		return "customerForm";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String processDelete(@RequestParam("customerID") int customerID) {
		
		//delete customer from the database
		customerService.deleteCustomer(customerID);
		
		//redirect to the listCustomers page
		return "redirect:/customer/list";
	}
	
	//add init binder to trim input strings(remove leading and trailing whitespace); convert to null when only has whitespace
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		//true means trim to null when only has whitespace
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
}
