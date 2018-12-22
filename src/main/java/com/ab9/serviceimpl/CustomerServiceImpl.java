package com.ab9.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ab9.beans.Customer;
import com.ab9.dao.CustomerDao;
import com.ab9.entities.CustomerEntity;
import com.ab9.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerDao;
	
	public boolean addCustomer(Customer customer) {
		
		return customerDao.addCustomer(getCustomerEntity(customer));
	}

	public Customer getCustomer(int customerId) {
		// TODO Auto-generated method stub
		return getCustomerBean(customerDao.getCustomer(customerId));
	}

	public Customer deleteCustomer(int customerId) {
		// TODO Auto-generated method stub
		return getCustomerBean(customerDao.deleteCustomer(customerId));
	}

	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return getCustomerBean(customerDao.updateCustomer(getCustomerEntity(customer)));
	}
	
	

	
	
	private CustomerEntity getCustomerEntity(Customer customer) {
		CustomerEntity customerEntity = new CustomerEntity();
		customerEntity.setCustomerId(customer.getCustomerId());
		customerEntity.setCustomerName(customer.getCustomerFirstName() + " " + customer.getCustomerLastName());
		customerEntity.setCustomerAge(customer.getCustomerAge());
		customerEntity.setCustomerEmail(customer.getCustomerEmail());
		customerEntity.setCustomerAddress(customer.getCustomerAddress());
		return customerEntity;
	}

	private Customer getCustomerBean(CustomerEntity customerEntity) {

		Customer customer = new Customer();
		customer.setCustomerId(customerEntity.getCustomerId());
		
		String[] names=customerEntity.getCustomerName().split(" ");
		//System.out.println(names[0]);	
		//System.out.println(names[1]);
		customer.setCustomerFirstName(names[0]);
		customer.setCustomerLastName(names[1]);
		customer.setCustomerAge(customerEntity.getCustomerAge());
		customer.setCustomerEmail(customerEntity.getCustomerEmail());
		customer.setCustomerAddress(customerEntity.getCustomerAddress());

		return customer;
	}
	
	
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return getCustomerBeanList(customerDao.getAllCustomers());
	}
	
	private List<Customer> getCustomerBeanList(List<CustomerEntity> allCustomers) {
		List<Customer> customers = new ArrayList<Customer>();
		for (CustomerEntity customerEntity : allCustomers) {
			customers.add(getCustomerBean(customerEntity));
		}

		return customers;
	}

}
