package com.hss.service;

import com.hss.model.CustomerModel;

public interface CustomerManagerServices {

	public String registerCustomer(CustomerModel model);
	
	public CustomerModel getCustomerDetailsBasedOnId(Long cid);
	
	public CustomerModel getCustomerBasedOnPanNo(String panNo);
	
	public CustomerModel getCustomerBasedOnAadharNo(long aadharNo);
	
	public String removeCustomerBasedOnId(long id);
}
