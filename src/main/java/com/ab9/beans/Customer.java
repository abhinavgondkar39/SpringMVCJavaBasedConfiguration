package com.ab9.beans;

public class Customer {
	
	private int customerId;
	private String customerFirstName;
	private String customerLastName;
	private int customerAge;
	private String customerEmail;
	private String customerAddress;
	
	
	
	@Override
	public String toString() {
		return "\n Customer [customerId=" + customerId + ", customerFirstName=" + customerFirstName + ", customerLastName="
				+ customerLastName + ", customerAge=" + customerAge + ", customerEmail=" + customerEmail
				+ ", customerAddress=" + customerAddress + "]";
	}
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Customer(int customerId, String customerFirstName, String customerLastName, int customerAge,
			String customerEmail, String customerAddress) {
		super();
		this.customerId = customerId;
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.customerAge = customerAge;
		this.customerEmail = customerEmail;
		this.customerAddress = customerAddress;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerFirstName() {
		return customerFirstName;
	}
	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}
	public String getCustomerLastName() {
		return customerLastName;
	}
	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}
	public int getCustomerAge() {
		return customerAge;
	}
	public void setCustomerAge(int customerAge) {
		this.customerAge = customerAge;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	
	
}
