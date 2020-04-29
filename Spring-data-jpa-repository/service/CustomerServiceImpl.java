package com.luv2code.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.cruddemo.dao.CustomerRepository;
import com.luv2code.springboot.cruddemo.entity.Customer;
@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerrepo;
	
	@Autowired
	public CustomerServiceImpl(CustomerRepository thecustomerrepo){
	customerrepo=thecustomerrepo;
	}
	@Override
	//remove@transactional
	public List<Customer> findAll() {
	return customerrepo.findAll();
	}
	@Override
	public Customer findById(int id) {
		// TODO Auto-generated method stub
		Optional<Customer> result = customerrepo.findById(id);
		Customer c=null;
		if(result.isPresent()){
			c=result.get();
		}
		return c;
	}
	@Override
	public void deleteById(int id) {
		customerrepo.deleteById(id);
	}
	@Override
	public void save(Customer customer) {
		customerrepo.save(customer);
	}

}
