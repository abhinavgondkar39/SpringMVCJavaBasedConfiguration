package com.ab9.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ab9.beans.Customer;
import com.ab9.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value = "/addCustomer", method = RequestMethod.GET)
	public ModelAndView index() {

		System.out.println("index page");
		Map<String, Object> map = new HashMap<String, Object>();
		// blank object --> form field must be initialize to default
			
		map.put("customer", new Customer());
		
		// get list of customer which are already added in db
		map.put("listOfCustomers", customerService.getAllCustomers());

		//addcustomer --> page name to send result --> view
		// map --> result --> model 
		return new ModelAndView("addCustomer", map);
	}
	@RequestMapping(value ={ "/customer","/customer/customer"}, method = RequestMethod.POST)
	public ModelAndView addCustomer(@ModelAttribute("customer") Customer customer) {
		System.out.println(customer.getCustomerId());
		if (customer.getCustomerId() == 0) {
			customerService.addCustomer(customer);
		} else {
			customerService.updateCustomer(customer);
		}
		customer = new Customer();
		ModelAndView model = new ModelAndView("redirect:/addCustomer");
		return model;
	}

	@RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
	public ModelAndView editCustomer(@PathVariable("id") int customerId) {
		System.out.println(customerId);
		Customer customer = customerService.getCustomer(customerId);
		System.out.println(customer);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("customer", customer);
		map.put("listOfCustomers", customerService.getAllCustomers());

		return new ModelAndView("addCustomer", map);
	}

	@RequestMapping(value = "/customerdel/{id}", method = RequestMethod.GET)
	public ModelAndView deleteCustomer(@PathVariable("id") int customerId) {
		System.out.println(customerId);
		Customer customer = customerService.getCustomer(customerId);
		System.out.println("deleting:" + customer);
		customerService.deleteCustomer(customerId);
		return new ModelAndView("redirect:/addCustomer");
	}
}

