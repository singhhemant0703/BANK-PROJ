package com.hss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hss.model.CustomerModel;
@Repository
public interface CustomerManagerRepository extends JpaRepository<CustomerModel, Long> {

	public CustomerModel findByPanNo(String panNo);
	
	public CustomerModel findByAadharNo(long uid);
}
