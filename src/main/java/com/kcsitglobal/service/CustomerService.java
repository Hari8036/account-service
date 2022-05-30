package com.kcsitglobal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kcsitglobal.entity.Customer;
import com.kcsitglobal.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public Customer save(Customer customer) {
		double fee = customer.getFee();
		double tax = (fee * 10) / 100;
		double totalValue = customer.getTotalValue();
		customer.setTotalValue(totalValue);
		customer.setTax(tax);
		Customer newCustomer = customerRepository.save(customer);
		return newCustomer;

	}

	public List<Customer> getCustomers() {
		return customerRepository.findAll();

	}

	public Optional<Customer> getCustomerById(int id) {
		return customerRepository.findById(id);
	}

	
}
