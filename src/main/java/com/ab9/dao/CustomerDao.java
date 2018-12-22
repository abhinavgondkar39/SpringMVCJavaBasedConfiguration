package com.ab9.dao;

import java.util.List;

import com.ab9.entities.CustomerEntity;

public interface CustomerDao {

	boolean addCustomer(CustomerEntity customerEntity);
	CustomerEntity getCustomer(int customerId);
	CustomerEntity deleteCustomer(int customerId);
	CustomerEntity updateCustomer(CustomerEntity customerEntity);
	List<CustomerEntity> getAllCustomers();
	
}
