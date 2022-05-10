package com.example.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomertRepositoryImpl implements CustomerRepository{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Customer> getAllCustomers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Customer> customerList = session.createQuery("from Customer").list();
		return customerList;
	}

	@Override
	public Customer getCustomer(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Customer customer = session.get(Customer.class, id);
		return customer;
	}

	@Override
	public Customer addCustomer(Customer customer) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(customer);
		return customer;
	}

	@Override
	public void updateCustomer(Customer customer) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(customer);
	}

	@Override
	public void deleteCustomer(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Customer customer = (Customer)session.load(Customer.class, new Integer(id));
		if(null != customer) session.delete(customer);
		
	}

}
