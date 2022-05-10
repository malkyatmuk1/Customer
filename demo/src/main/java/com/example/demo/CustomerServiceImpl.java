package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService{

	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.getAllCustomers();
	}

	@Override
	public Customer getCustomer(int id) {
		return customerRepository.getCustomer(id);
	}

	@Override
	public Customer addCustomer(Customer customer) {
		return customerRepository.addCustomer(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerRepository.updateCustomer(customer);
		
	}

	@Override
	public void deleteCustomer(int id) {
		customerRepository.deleteCustomer(id);
		
	}	
}
