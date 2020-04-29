package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import com.luv2code.springboot.cruddemo.entity.Customer;

public interface CustomerService {
	
	public List<Customer> findAll();

	public Customer findById(int id);
	
	

	public void deleteById(int id);

	void save(Customer customer);
	
	
}
