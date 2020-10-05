package com.hss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hss.model.CustomerModel;
import com.hss.repository.CustomerManagerRepository;

@Service("customerService")
public class CustomerManagerServicesImpl implements CustomerManagerServices {

	@Autowired
	private CustomerManagerRepository custRepo;
	
	@Override
	public String registerCustomer(CustomerModel model) {
		String result=null;
		CustomerModel outMod=null;
		//register customer
		outMod=custRepo.save(model);
		if(outMod!=null)
			result="Customer Deatails Added Successfully "+outMod.getCustomerName()+" Customer ID ::"+outMod.getCustomerId();
		else 
			result="Customer not Added";
		
		
		return result;
	}

	@Override
	public CustomerModel getCustomerDetailsBasedOnId(Long cid) {
		// find customer id based on id
		return custRepo.findById(cid).get();
	}

	@Override
	public CustomerModel getCustomerBasedOnPanNo(String panNo) {
		//get customer by pan no
		
		return custRepo.findByPanNo(panNo);
	}
	
	@Override
	public CustomerModel getCustomerBasedOnAadharNo(long aadharNo) {
		//get customer by aadhar no
		
		return custRepo.findByAadharNo(aadharNo);
	}

	@Override
	public String removeCustomerBasedOnId(long id) {
		 String result=null;
		// get customer by id
		   if(custRepo.existsById(id)) {
			   custRepo.deleteById(id);
		        result="Customer With Id: "+id+" found and remove ";
		   }
		   else
			   result="Customer Id :"+id+" not found";
			   
		return null;
	}

}
