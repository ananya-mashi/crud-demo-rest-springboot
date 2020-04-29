package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.cruddemo.dao.CustomerDAO;
import com.luv2code.springboot.cruddemo.entity.Customer;
@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerDAO Customerdao;
	
	@Autowired
	public CustomerServiceImpl(CustomerDAO theCustomerdao){ //@Qualifier annotation for new jpa implementation (--this is not jpa repository
		Customerdao=theCustomerdao;
	}
	@Override
	@Transactional
	public List<Customer> findAll() {
	return Customerdao.findAll();
	}
	@Override
	@Transactional
	public Customer findById(int id) {
		// TODO Auto-generated method stub
		return Customerdao.findById(id);
	}
	@Override
	@Transactional
	public void deleteById(int id) {
		Customerdao.deleteById(id);
	}
	@Override
	@Transactional
	public void save(Customer customer) {
		Customerdao.save(customer);
	}

}
