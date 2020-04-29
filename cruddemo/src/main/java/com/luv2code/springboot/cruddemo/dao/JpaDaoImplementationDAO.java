package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.entity.Customer;

@Repository
public class JpaDaoImplementationDAO implements CustomerDAO {
private EntityManager entityManager;
	
	@Autowired
	public void CustomerDAoHibImpl(EntityManager tentityManager){
		entityManager=tentityManager;
	}
	
	@Transactional
	public List<Customer> findAll() {
		
Session currentSession = entityManager.unwrap(Session.class);

Query<Customer> theQuery = 
		currentSession.createQuery("from Customer",
									Customer.class);
List<Customer> customers = theQuery.getResultList();
return customers;
		
	}

	@Override
	public Customer findById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);

	
		return currentSession.get(Customer.class,id);
		
	}

	public void save(Customer customer) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(customer);
		
	}
	@Override
	public void deleteById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Customer> theQuery = 
				currentSession.createQuery(" delete from Customer where id=:id");
	theQuery.setParameter("id",id);
	theQuery.executeUpdate();
	}




}
