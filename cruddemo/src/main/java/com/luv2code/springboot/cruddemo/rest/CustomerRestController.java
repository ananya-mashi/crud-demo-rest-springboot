package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.luv2code.springboot.cruddemo.entity.Customer;
import com.luv2code.springboot.cruddemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	private CustomerService s;
	
	@Autowired
	public CustomerRestController(CustomerService service) {
	s=service;
	}
	
	@GetMapping("/Customers")
	public List<Customer> findAll() {
		return s.findAll();
	}

	
	@GetMapping("/Customers/{id}")
	public Customer getCustomer(@PathVariable int id){
	Customer customer=s.findById(id);
	if(customer==null){
		throw new RuntimeException("CustomerNot Found "+id);
	}
	return customer;
	}
	@PostMapping("/Customers")
	public Customer addCustomer(@RequestBody Customer customer){
	customer.setId(0); //save or update
	s.save(customer);
	return customer;
	}
	
	
	@PutMapping("/Customers")
	public Customer updateCustomer(@RequestBody Customer c){
	
	s.save(c);
	return c;
	}
	

	
	@DeleteMapping("/Customers/{id}")
	public String deleteCustomer(@PathVariable int id){
	Customer customer=s.findById(id);
	if(customer==null){
		throw new RuntimeException("CustomerNot Found "+id);
	}
	s.deleteById(id);
	return "Deleted Customer id  -" +id;
	}
}










